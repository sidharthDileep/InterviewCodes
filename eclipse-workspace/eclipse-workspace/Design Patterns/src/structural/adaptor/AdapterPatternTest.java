package structural.adaptor;

public class AdapterPatternTest {

	public static void main(String[] args) {
		
		SocketAdaptor sockAdaptor = new SocketClassAdapterImpl();
		
		Volt v3 = sockAdaptor.get3Volt();
		Volt v12 = sockAdaptor.get12Volt();
		Volt v120 = sockAdaptor.get120Volt();
		
		System.out.println("v3 volts using Object Adapter="+v3.getVolts());
		System.out.println("v12 volts using Object Adapter="+v12.getVolts());
		System.out.println("v120 volts using Object Adapter="+v120.getVolts());

	}

}
