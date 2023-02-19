package problems.interview;

import java.util.HashSet;

public class WrappedString {

	private String s;

	public WrappedString(String s) {
		this.s = s;
	}

	public static void main(String[] args) {

		HashSet<Object> hs = new HashSet<Object>();

		WrappedString hs1 = new WrappedString("sidharth");
		WrappedString hs2 = new WrappedString("sidharth");
		String hs3 = new String("sidharth");
		String hs4 = new String("sidharth");

		hs.add(hs1);
		hs.add(hs2);
		hs.add(hs3);
		hs.add(hs4);

		System.out.println(hs.size());
		
		String obj = "hello";
		String obj1 = "world";
		String obj2 = obj;
		obj2 = " world";
		
		System.out.println(obj + " " + obj2);

	}

}
