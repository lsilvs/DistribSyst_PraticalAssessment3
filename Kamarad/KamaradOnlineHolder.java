package Kamarad;

/**
* Kamarad/KamaradOnlineHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from kamarad.idl
* Wednesday, March 5, 2014 5:17:45 PM GMT
*/

public final class KamaradOnlineHolder implements org.omg.CORBA.portable.Streamable
{
  public Kamarad.KamaradOnline value = null;

  public KamaradOnlineHolder ()
  {
  }

  public KamaradOnlineHolder (Kamarad.KamaradOnline initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Kamarad.KamaradOnlineHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Kamarad.KamaradOnlineHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Kamarad.KamaradOnlineHelper.type ();
  }

}
