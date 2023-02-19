package creational.builder;

public class Computer {
	
	private String HDD;
	private String RAM;
	
	private boolean isGraphicsCardEnabled;
	private boolean isBluetoothEnabled;
	
	
	public Computer(ComputerBuilder builder) {
		this.HDD=builder.HDD;
		this.RAM=builder.RAM;
		this.isGraphicsCardEnabled=builder.isGraphicsCardEnabled;
		this.isBluetoothEnabled=builder.isBluetoothEnabled;
	}
	
	public String getHDD() {
		return HDD;
	}
	public void setHDD(String hDD) {
		HDD = hDD;
	}
	public String getRAM() {
		return RAM;
	}
	public void setRAM(String rAM) {
		RAM = rAM;
	}
	public boolean isGraphicsCardEnabled() {
		return isGraphicsCardEnabled;
	}
	public void setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
		this.isGraphicsCardEnabled = isGraphicsCardEnabled;
	}
	public boolean isBluetoothEnabled() {
		return isBluetoothEnabled;
	}
	public void setBluetoothEnabled(boolean isBluetoothEnabled) {
		this.isBluetoothEnabled = isBluetoothEnabled;
	}
	
	
	
	
	@Override
	public String toString() {
		return "Computer [HDD=" + HDD + ", RAM=" + RAM + ", isGraphicsCardEnabled=" + isGraphicsCardEnabled
				+ ", isBluetoothEnabled=" + isBluetoothEnabled + "]";
	}




	public static class ComputerBuilder{
		
		private String HDD;
		private String RAM;

		private boolean isGraphicsCardEnabled;
		private boolean isBluetoothEnabled;
		
		
		
		public ComputerBuilder(String hDD, String rAM) {
			this.HDD = hDD;
			this.RAM = rAM;
		}

		
		public String getHDD() {
			return HDD;
		}
		public void setHDD(String hDD) {
			HDD = hDD;
		}
		public String getRAM() {
			return RAM;
		}
		public void setRAM(String rAM) {
			RAM = rAM;
		}
		public boolean isGraphicsCardEnabled() {
			return isGraphicsCardEnabled;
		}
		public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
			this.isGraphicsCardEnabled = isGraphicsCardEnabled;
			return this;
		}
		public boolean isBluetoothEnabled() {
			return isBluetoothEnabled;
		}
		public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
			this.isBluetoothEnabled = isBluetoothEnabled;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
		
	}
	
	
}
