package Kamarad;


/**
* Kamarad/KamaradOnlinePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from kamarad.idl
* Wednesday, March 5, 2014 5:17:45 PM GMT
*/

public abstract class KamaradOnlinePOA extends org.omg.PortableServer.Servant
 implements Kamarad.KamaradOnlineOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("register", new java.lang.Integer (0));
    _methods.put ("topup", new java.lang.Integer (1));
    _methods.put ("getCredit", new java.lang.Integer (2));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // Kamarad/KamaradOnline/register
       {
         org.omg.CORBA.Any kamaradAccountDetails = in.read_any ();
         org.omg.CORBA.AnyHolder uniqueId = new org.omg.CORBA.AnyHolder ();
         this.register (kamaradAccountDetails, uniqueId);
         out = $rh.createReply();
         out.write_any (uniqueId.value);
         break;
       }

       case 1:  // Kamarad/KamaradOnline/topup
       {
         org.omg.CORBA.Any uniqueId = in.read_any ();
         org.omg.CORBA.Any amount = in.read_any ();
         org.omg.CORBA.AnyHolder kamaradAccountDetails = new org.omg.CORBA.AnyHolder ();
         this.topup (uniqueId, amount, kamaradAccountDetails);
         out = $rh.createReply();
         out.write_any (kamaradAccountDetails.value);
         break;
       }

       case 2:  // Kamarad/KamaradOnline/getCredit
       {
         org.omg.CORBA.Any uniqueId = in.read_any ();
         org.omg.CORBA.AnyHolder kamaradCredit = new org.omg.CORBA.AnyHolder ();
         this.getCredit (uniqueId, kamaradCredit);
         out = $rh.createReply();
         out.write_any (kamaradCredit.value);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:Kamarad/KamaradOnline:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public KamaradOnline _this() 
  {
    return KamaradOnlineHelper.narrow(
    super._this_object());
  }

  public KamaradOnline _this(org.omg.CORBA.ORB orb) 
  {
    return KamaradOnlineHelper.narrow(
    super._this_object(orb));
  }


} // class KamaradOnlinePOA
