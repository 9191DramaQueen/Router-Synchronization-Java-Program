import java.util.Random;

class Device extends Thread{
	enum DeviceType {
        MOBILE, TABLET, LABTOP, PC
    };
	String name;
	static String type;
	int connectionNum;
	Random millis = new Random();
	private static Router router;
	@SuppressWarnings("static-access")
	protected Device(String name, String deviceType , Router router) { 
		this.name = name;
		this.router = router;
		deviceType = deviceType.toLowerCase();
		switch(deviceType) {
		case "mobile": case "tablet": case "pc": case "labtop":
			type = deviceType.toUpperCase();
			break;
		default:
			type = "Device";
	}	
			
	}
	public void run() {
		connectionNum = router.occupy(this);
		this.Connect();
		this.PreformActivity();
		this.Disconnect();
	}
	public void Connect() {
		System.out.println("Connection " + connectionNum + ": "+ name + " (" + type + ") " + "Arrived");
	}
	public void Waiting() {
		System.out.println(name + " (" + type + ") "  + "Arrived and waiting"); //Sorry
	}

	public void Disconnect() {
		router.release(this);
		System.out.println("Connection " + connectionNum + ": "+ name + " (" + type + ") "  + "Logged out");
	}
	
	public void PreformActivity() {
		try {
			Device.sleep(millis.nextInt(10000));
			System.out.println("Connection " + connectionNum + ": "+ name + " (" + type + ") "  + "Performs online activity");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
