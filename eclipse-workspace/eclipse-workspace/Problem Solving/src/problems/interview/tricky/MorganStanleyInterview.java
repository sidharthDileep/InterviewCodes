package problems.interview.tricky;

public class MorganStanleyInterview {

	public static void main(String[] args) {

		Integer i = new Integer(10);
		Integer j = new Integer(20);

		System.out.println(i + " " + j); // 10 20

		swap(i, j);

		System.out.println(i + " " + j); // 10 20
		
		int a = 3;
		int b = 4;
		
		System.out.println(a + " " + b);
		
		swap(a, b);
		
		System.out.println(a + " " + b);
		

	}

	public static void swap(Integer a, Integer b) {
		Integer c = a;
		a = b;
		b = c;

		System.out.println(a + " " + b); // 20 10
	}
	
	public static void swap(int a, int b) {
		int c = a;
		a = b;
		b = c;

		System.out.println(a + " " + b); // 20 10
	}

}
