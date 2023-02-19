package creational.singleton;

import java.io.Serializable;

public class Singleton implements Serializable{

	private static Singleton obj;
	
	private Singleton() {
		if(obj != null) {
			throw new InstantiationError("Creation of objects not allowed");
		}
		
	}
	
	public static synchronized Singleton getinstance() {
		if(obj == null) {
			obj = new Singleton();
		}
		return obj;
	}
	
	protected Object readResolve() {
		return obj;
	}
	
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
}
