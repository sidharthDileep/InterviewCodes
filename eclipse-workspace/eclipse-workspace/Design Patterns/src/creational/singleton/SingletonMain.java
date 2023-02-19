package creational.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

public class SingletonMain {

	public static void main(String[] args) {
		
		Singleton instance1 = Singleton.getinstance();
		Singleton instance2 = null;
		
		try {
			Constructor[] constructors = 
					Singleton.class.getDeclaredConstructors();
			for(Constructor constructor : constructors) {
				constructor.setAccessible(true);
				instance2 = (Singleton) constructor.newInstance();
				break;
			}
		} catch (Exception e) 
        {
            e.printStackTrace();
        }
          
		
		Singleton instance3 = Singleton.getinstance();
		try {
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream("file.txt"));
			out.writeObject(instance3);
			out.close();
			
			ObjectInput in = new ObjectInputStream(new FileInputStream("file.text"));
			Singleton instance4 = (Singleton) in.readObject();
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		System.out.println("Instance1 :"  + instance1.hashCode());
		//System.out.println("Instance2 :"  + instance2.hashCode());
		
		
		
		
	}

}
