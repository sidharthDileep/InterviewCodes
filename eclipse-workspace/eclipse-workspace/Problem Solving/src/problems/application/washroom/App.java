package problems.application.washroom;

public class App {

	public static void main(String[] args) {
		Washroom r = new Washroom();
		for (int i = 0; i < 10; i++) {
			Thread client = new Thread(new Client(r));
			client.start();
		}
	}

}
