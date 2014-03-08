import org.omg.PortableServer.*;
import Kamarad.*;
import org.omg.CORBA.*;

class KamaradServant implements KamaradOnlineOperations {

	private KamaradAccountDetails accountDetails;

	private static long ID = 0001;

	public void register (org.omg.CORBA.Any kamaradAccountDetails, org.omg.CORBA.AnyHolder uniqueId) {
		
	}

  public void topup (org.omg.CORBA.Any uniqueId, org.omg.CORBA.Any amount, org.omg.CORBA.AnyHolder kamaradAccountDetails) {

  }

  public void getCredit (org.omg.CORBA.Any uniqueId, org.omg.CORBA.AnyHolder kamaradCredit) {

  }

}