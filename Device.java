import java.util.Random;

class Device extends Thread{
	String name;
	String type;
	int connectionNum;
	Random millis = new Random();
	private Router router;
	protected Device(String name, String deviceType , Router router) { 
		this.name = name;
		this.router = router;
		deviceType = deviceType.toLowerCase();
		switch(deviceType) {
		case "mobile": case "tablet": case "pc": case "laptop":
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
			System.out.println("Connection " + (connectionNum+1) + ": "+ name + " (" + type + ") "  + "Performs online activity");
			Device.sleep(5000 + millis.nextInt(5000));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
