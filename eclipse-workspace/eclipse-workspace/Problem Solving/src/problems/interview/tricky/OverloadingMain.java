package problems.interview.tricky;

public class OverloadingMain {

	public static void main(String[] args) {
		Conversion c = new Conversion();
		 
        // Invoking the method with different signature
        c.method(10);
        c.method(new Integer(15));
        c.method(new Long(100));
 
        // Using short will give, argument mismatch;
        // possible lossy conversion from int to short
        // c.method(new Short(15));
        
        Test test = new Test();
        //int res = test.test(1, 1); ambiguous error
        int res = test.test(1, 1f);
        
       // test.test2(2.0); not possible
        
        
        
        System.out.println("Result : " + res);

	}

}

class Test{
	public int test(int a, float b) {
		System.out.println("I am in int float method");
    	return 1;
    }
	
	public float test(float a, int b) {
		System.out.println("I am in int float method");
    	return 2;
    }
	
	public void test2(int a) {
		System.out.println("int method");
	}
	public void test2(float a) {
		System.out.println("int method");
	}
}
