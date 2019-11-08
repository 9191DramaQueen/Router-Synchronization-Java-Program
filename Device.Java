
class Device extends Thread{
	enum DeviceType {
        MOBILE, TABLET, LABTOP, PC
    };
	String name;
	static String type;
	LabSemaphore semaphore;
	protected Device(String name, String deviceType, LabSemaphore semaphore) { 
		this.name = name;
		this.semaphore = semaphore;
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
		if(semaphore.aPlaceExists()) {
			this.Connect();
			this.PreformActivity();
			this.Disconnect();
		}else {
			this.Waiting();
		}
		
		
	}
	public void Connect() {
		System.out.println(type + "Arrived");
		semaphore.Lock();
	}
	public void Waiting() {
		System.out.println(type + "Arrived and waiting");
		semaphore.Lock();
	}

	public void Disconnect() {
		semaphore.Release();
		System.out.println(type + "Logged out");
	}
	
	public void PreformActivity() {
		System.out.println(type + "Performs online activity");
	}
	
}
