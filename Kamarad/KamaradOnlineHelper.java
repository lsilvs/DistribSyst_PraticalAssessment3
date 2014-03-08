package Kamarad;


/**
* Kamarad/KamaradOnlineHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from kamarad.idl
* Wednesday, March 5, 2014 5:17:45 PM GMT
*/

abstract public class KamaradOnlineHelper
{
  private static String  _id = "IDL:Kamarad/KamaradOnline:1.0";

  public static void insert (org.omg.CORBA.Any a, Kamarad.KamaradOnline that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static Kamarad.KamaradOnline extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (Kamarad.KamaradOnlineHelper.id (), "KamaradOnline");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static Kamarad.KamaradOnline read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_KamaradOnlineStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, Kamarad.KamaradOnline value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static Kamarad.KamaradOnline narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Kamarad.KamaradOnline)
      return (Kamarad.KamaradOnline)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Kamarad._KamaradOnlineStub stub = new Kamarad._KamaradOnlineStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static Kamarad.KamaradOnline unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof Kamarad.KamaradOnline)
      return (Kamarad.KamaradOnline)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      Kamarad._KamaradOnlineStub stub = new Kamarad._KamaradOnlineStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}