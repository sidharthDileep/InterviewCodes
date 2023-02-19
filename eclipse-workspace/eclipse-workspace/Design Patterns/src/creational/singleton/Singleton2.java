package creational.singleton;

public class Singleton2 {
	private static Singleton2 obj = new Singleton2();
	
	private Singleton2() {
		
	}
	
	public static Singleton2 getInstance() {
		return obj;
	}

}
