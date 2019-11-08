import java.util.concurrent.Semaphore;

class Device extends Thread{
	enum DeviceType {
        MOBILE, TABLET, LABTOP, PC
    };
	String name;
	DeviceType type;
	Semaphore semaphore;
	protected Device(String name, String deviceType, Semaphore semaphore) { 
		this.name = name;
		this.semaphore = semaphore;
		deviceType = deviceType.toLowerCase();
		switch(deviceType) {
			case "mobile":	type = DeviceType.MOBILE;
			case "tablet":	type = DeviceType.TABLET;
			case "labtop":	type = DeviceType.LABTOP;
			case "pc":		type = DeviceType.PC;
		}	
	}
	public void run() {
		
	}
	public static void Connect() {
		
	}
	
	public static void Disconnect() {
		
	}
	
	public static void PreformActivity() {
		
	}
	
}
