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
  private static ORB orb;
  private static KamaradOnline kamaradRef;

  public static void main(String args[]) {
		try {
			NameComponent nc[]= new NameComponent[2];

			Properties prop = new Properties();
			prop.put("org.omg.CORBA.ORBInitialPort", "1050");

			// create and initialize the ORB
			orb = ORB.init(args, prop);
			org.omg.CORBA.Object objRef = orb.resolve_initial_references("NameService");
			rootCtx = NamingContextExtHelper.narrow(objRef);

			nc[0] = new NameComponent("Kamarad", "Context");
			nc[1] = new NameComponent("KamaradOnLine", "Object");

			// NameComponent path[] = {nc};
			org.omg.CORBA.Object objRefKamarad = rootCtx.resolve(nc);
			kamaradRef = KamaradOnlineHelper.narrow(objRefKamarad);

			Integer option = 0;

			while	(option != 4) {
				// Display menu
		    System.out.println("============================");
		    System.out.println("|      MENU SELECTION      |");
		    System.out.println("============================");
		    System.out.println("| Options:                 |");
		    System.out.println("|        1. Register       |");
		    System.out.println("|        2. Top up         |");
		    System.out.println("|        3. Get Credit     |");
		    System.out.println("|        4. Exit           |");
		    System.out.println("============================");

		    System.out.println("Select option:");
		    option = Integer.parseInt(System.console().readLine());

				// Switch construct
				switch (option) {
					case 1:
						String resp1 = register();
						System.out.println(resp1);
						System.out.println("Enter to continue.");
						System.console().readLine();
						break;
					case 2:
						KamaradAccountDetails resp2 = topup();
						System.out.println(resp2.balance);
						System.out.println("Enter to continue.");
						System.console().readLine();
						break;
					case 3:
						Float resp3 = getCredit();
						System.out.println(resp3);
						System.out.println("Enter to continue.");
						System.console().readLine();
						break;
					case 4:
						System.out.println("bye...");
						break;
					default:
						System.out.println("Invalid Option");
						break;
				}

			}

		} catch (Exception e) {
			System.out.println("ERROR : " + e) ;
			e.printStackTrace(System.out);
		}
	}


	private static String register() {
		System.out.print("Enter you name: ");
		String name = System.console().readLine();

		System.out.print("Enter you phone_number: ");
		String phone_number = System.console().readLine();

		System.out.print("Enter you address: ");
		String address = System.console().readLine();

		System.out.print("Enter you bank_number: ");
		Integer bank_number = Integer.parseInt(System.console().readLine());

		System.out.print("Enter you balance: ");
		Long balance = Long.parseLong(System.console().readLine());

		float kamarad_credit = Float.parseFloat("0");

		KamaradAccountDetails accountDetails = new KamaradAccountDetails(
				"", // unique_id
				name, // name
				phone_number, // phone_number
				address, // address
				bank_number, // bank_number
				balance, // balance
				kamarad_credit // kamarad_credit
		);

		Any anyAccount = orb.create_any();
		AnyHolder uniqueId = new AnyHolder();
		
		try {
			KamaradAccountDetailsHelper.insert(anyAccount, accountDetails);
		} catch (SystemException se) {
			System.out.println("insert any error\n" + "Unexpected exception:\n" + se.toString ());
			return "error";
		}

		kamaradRef.register(anyAccount, uniqueId);
		return uniqueId.value.extract_string();
	}


	private static KamaradAccountDetails topup() {
		System.out.print("Password: ");
		String password = System.console().readLine();

		System.out.print("Amount: ");
		Long amount = Long.parseLong(System.console().readLine());

		Any anyID = orb.create_any();
		anyID.insert_string(password);

		Any anyAmount = orb.create_any();
		anyAmount.insert_float(amount);

		AnyHolder anyHolderAccount = new AnyHolder();

		kamaradRef.topup(anyID, anyAmount, anyHolderAccount);
		KamaradAccountDetails accountDetails = KamaradAccountDetailsHelper.extract(anyHolderAccount.value);

		// System.out.println(accountDetails.unique_id);
		// System.out.println(accountDetails.name);
		// System.out.println(accountDetails.phone_number);
		// System.out.println(accountDetails.address);	
		// System.out.println(accountDetails.bank_number);
		// System.out.println(accountDetails.balance);
		// System.out.println(accountDetails.kamarad_credit);

		return accountDetails;
	}


	private static Float getCredit() {
		System.out.print("Password: ");
		String password = System.console().readLine();

		Any anyID = orb.create_any();
		anyID.insert_string(password);
		AnyHolder anyHolderCredit = new AnyHolder();

		kamaradRef.getCredit(anyID, anyHolderCredit);
		return anyHolderCredit.value.extract_float();
	}

}