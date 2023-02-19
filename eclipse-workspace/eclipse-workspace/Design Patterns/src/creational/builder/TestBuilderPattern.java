package creational.builder;

public class TestBuilderPattern {

	public static void main(String[] args) {
		
		Computer comp = new Computer.ComputerBuilder("500GB", "2GB")
									.setBluetoothEnabled(true)
									.setGraphicsCardEnabled(true)
									.build();
		
		System.out.print("Computer : " + comp.toString());

	}

}
