import org.omg.PortableServer.*;
import Kamarad.*;
import org.omg.CORBA.*;
import java.util.*;

class KamaradServant implements KamaradOnlineOperations {

	private Hashtable<String, KamaradAccountDetails> allAccounts = new Hashtable<String, KamaradAccountDetails>();
	private KamaradAccountDetails accountDetails;
	private static long ID = 0001;

	public void register (org.omg.CORBA.Any kamaradAccountDetails, org.omg.CORBA.AnyHolder uniqueId) {
		String strLong = String.format("%04d" , this.ID++);

		accountDetails = KamaradAccountDetailsHelper.extract(kamaradAccountDetails);
		accountDetails.unique_id = strLong;
		allAccounts.put(strLong, accountDetails);

		Any keyAux = ORB.init().create_any();
		keyAux.insert_string(strLong);
		uniqueId.value = keyAux;

	}

  public void topup (org.omg.CORBA.Any uniqueId, org.omg.CORBA.Any amount, org.omg.CORBA.AnyHolder kamaradAccountDetails) {

  }

  public void getCredit (org.omg.CORBA.Any uniqueId, org.omg.CORBA.AnyHolder kamaradCredit) {

  }

}