package Kamarad;


/**
* Kamarad/KamaradOnlinePOATie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from kamarad.idl
* Wednesday, March 5, 2014 5:17:45 PM GMT
*/

public class KamaradOnlinePOATie extends KamaradOnlinePOA
{

  // Constructors

  public KamaradOnlinePOATie ( Kamarad.KamaradOnlineOperations delegate ) {
      this._impl = delegate;
  }
  public KamaradOnlinePOATie ( Kamarad.KamaradOnlineOperations delegate , org.omg.PortableServer.POA poa ) {
      this._impl = delegate;
      this._poa      = poa;
  }
  public Kamarad.KamaradOnlineOperations _delegate() {
      return this._impl;
  }
  public void _delegate (Kamarad.KamaradOnlineOperations delegate ) {
      this._impl = delegate;
  }
  public org.omg.PortableServer.POA _default_POA() {
      if(_poa != null) {
          return _poa;
      }
      else {
          return super._default_POA();
      }
  }
  public void register (org.omg.CORBA.Any kamaradAccountDetails, org.omg.CORBA.AnyHolder uniqueId)
  {
    _impl.register(kamaradAccountDetails, uniqueId);
  } // register

  public void topup (org.omg.CORBA.Any uniqueId, org.omg.CORBA.Any amount, org.omg.CORBA.AnyHolder kamaradAccountDetails)
  {
    _impl.topup(uniqueId, amount, kamaradAccountDetails);
  } // topup

  public void getCredit (org.omg.CORBA.Any uniqueId, org.omg.CORBA.AnyHolder kamaradCredit)
  {
    _impl.getCredit(uniqueId, kamaradCredit);
  } // getCredit

  private Kamarad.KamaradOnlineOperations _impl;
  private org.omg.PortableServer.POA _poa;

} // class KamaradOnlinePOATie
