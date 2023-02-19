package problems.interview.tricky;

public class ThreadTest extends Thread{

	public static void main(String[] args) {
		
		new ThreadTest().start();

	}
	
	public void run() {
		try {
			System.out.println("Hi..");
			wait(1000);
			
		}catch(InterruptedException e) {
			e.printStackTrace();
			System.out.println("Hello");
		}  catch(Exception e) {
			System.out.println("I am");
		}
	}

}
