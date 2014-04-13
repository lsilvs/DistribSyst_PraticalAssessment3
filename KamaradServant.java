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
  	// check if hashtable contains the uniqueId key
    if (this.allAccounts.containsKey(uniqueId.extract_string())) {
    	accountDetails = this.allAccounts.get(uniqueId.extract_string());
    	accountDetails.balance = accountDetails.balance - amount.extract_float();
    	accountDetails.kamarad_credit = accountDetails.kamarad_credit + amount.extract_float();
    	allAccounts.put(uniqueId.extract_string(), accountDetails);

    	Any keyAux = ORB.init().create_any();
			KamaradAccountDetailsHelper.insert(keyAux, accountDetails);
			kamaradAccountDetails.value = keyAux;

    }
  }

  public void getCredit (org.omg.CORBA.Any uniqueId, org.omg.CORBA.AnyHolder kamaradCredit) {
  	// check if hashtable contains the uniqueId key
    if (this.allAccounts.containsKey(uniqueId.extract_string())) {
    	accountDetails = this.allAccounts.get(uniqueId.extract_string());

    	Any keyAux = ORB.init().create_any();
			keyAux.insert_float(accountDetails.kamarad_credit);
			kamaradCredit.value = keyAux;

    }

  }

}