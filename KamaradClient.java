import java.io.*;
import org.omg.CORBA.*;
import Kamarad.*;
import org.omg.CosNaming.* ;
import org.omg.CosNaming.NamingContextPackage.*;
import java.util.Scanner;
import java.util.Properties;

import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;


public class KamaradClient {
  public static NamingContextExt rootCtx;

  public static void main(String args[]) {
		try {
			NameComponent nc[]= new NameComponent[2];

			Properties prop = new Properties();
			prop.put("org.omg.CORBA.ORBInitialPort", "1050");

			// create and initialize the ORB
			ORB orb = ORB.init(args, prop);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			rootCtx = NamingContextExtHelper.narrow(objRef);

			nc[0] = new NameComponent("Kamarad", "Context");
			nc[1] = new NameComponent("KamaradOnLine", "Object");

			// NameComponent path[] = {nc};
			org.omg.CORBA.Object objRefKamarad = rootCtx.resolve(nc);
			KamaradOnline kamaradRef = KamaradOnlineHelper.narrow(objRefKamarad);

			// Stub to call REGISTER mehtod #########################################
			float balance = Float.parseFloat("250");
			float kamaradCredit = Float.parseFloat("0");

			KamaradAccountDetails accountDetails = new KamaradAccountDetails(
					"", // uniqueId
					"Alan Turing", // name
					"0831776655", // phoneNumber
					"NCI on Campus", // address
					9876543, // bankNumber
					balance, // balance
					kamaradCredit // kamaradCredit
			);

			Any anyAccount = orb.create_any();
			AnyHolder uniqueId = new AnyHolder();
			
			try {
				KamaradAccountDetailsHelper.insert(anyAccount, accountDetails);
			} catch (SystemException se) {
				System.out.println("insert any error\n" + "Unexpected exception:\n" + se.toString ());
				return;
			}

			kamaradRef.register(anyAccount, uniqueId);
			System.out.println(uniqueId.value.extract_string());

			
			// Stub to call TOPUP mehtod ############################################
			Any anyID = orb.create_any();
			anyID.insert_string("0001");

			Any anyAmount = orb.create_any();
			anyAmount.insert_float(15);

			AnyHolder anyHolderAccount = new AnyHolder();

			kamaradRef.topup(anyID, anyAmount, anyHolderAccount);
			accountDetails = KamaradAccountDetailsHelper.extract(anyHolderAccount.value);
			System.out.println(accountDetails.unique_id);
			System.out.println(accountDetails.name);
			System.out.println(accountDetails.phone_number);
			System.out.println(accountDetails.address);	
			System.out.println(accountDetails.bank_number);
			System.out.println(accountDetails.balance);
			System.out.println(accountDetails.kamarad_credit);



			// Stub to call GETCREDIT mehtod ############################################
			AnyHolder anyHolderCredit = new AnyHolder();

			kamaradRef.getCredit(anyID, anyHolderCredit);
			System.out.println(anyHolderCredit.value.extract_float());


		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}
}