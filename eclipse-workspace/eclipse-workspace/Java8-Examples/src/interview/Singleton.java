package interview;

public class Singleton {
	
	private static Singleton obj = new Singleton();
	
	private Singleton() {
		
	}
	
	public static synchronized Singleton getInstance() {
		return obj;
	}

}
