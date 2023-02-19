package structural.proxy;

public class proxyMain {

	public static void main(String[] args) {
		CommandExecutor executor = new CommandExecutorProxy("Sidharth", "sid");
		try {
			executor.runCommand("ls -ltr");
			executor.runCommand(" rm -rf abc.pdf");
		} catch (Exception e) {
			System.out.println("Exception Message::"+e.getMessage());
		}
	}

}
