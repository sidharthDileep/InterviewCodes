package creational.abstractFactory;

public class TestAbstractFactory {

	public static void main(String[] args) {
		Computer pc = ComputerFactory.getComputer(new PCFactory("2GB", "500GB", "2.4GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB","1 TB","2.9 GHz"));
		System.out.println("AbstractFactory PC Config :: "+pc);
		System.out.println("AbstractFactory Server Config :: "+server);

	}

}
