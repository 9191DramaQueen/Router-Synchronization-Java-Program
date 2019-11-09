import java.util.Random;

class Device extends Thread{
	enum DeviceType {
        MOBILE, TABLET, LABTOP, PC
    };
	String name;
	static String type;
	int connectionNum;
	Random millis = new Random();
	private Router router;
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
		this.Connect();
		this.PreformActivity();
		this.Disconnect();
	}
	public void Connect() {
		connectionNum = router.occupy(this);
	}
	public void Disconnect() {
		router.release(this);
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
