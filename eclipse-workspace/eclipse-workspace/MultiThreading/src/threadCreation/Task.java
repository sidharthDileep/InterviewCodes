package threadCreation;

import java.util.concurrent.Callable;

public class Task implements Callable<String> {
	
	private String message;
	
	public Task(String msg){
		this.message = msg;
	}

	@Override
	public String call() throws Exception {
		return "Hi, " + message;
	}

}
