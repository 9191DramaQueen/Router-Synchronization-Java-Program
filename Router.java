class Router{
	private Device[] listOfConnections;
	private LabSemaphore semaphore;

	public Router(int value) {
		semaphore = new LabSemaphore(value);
		listOfConnections = new Device[value];
		for(int i = 0 ;  i < value ; i++)
			listOfConnections[i] = null;
	}

	public int occupy(Device device) {
		synchronized (semaphore){
			if (semaphore.aPlaceExists()) {
				System.out.println("(" + device.name + ")" + " (" + device.type + ")" + " arrived.");
			} else {
				System.out.println("(" + device.name + ")" + " (" + device.type + ")" + " arrived and waiting.");
			}
			semaphore.Lock();
			int index = 0;
			for (int i = 0; i < listOfConnections.length; i++) {
				if (listOfConnections[i] == null) {
					listOfConnections[i] = device;
					index = i;
					break;
				}
			}
			System.out.println("Connection " + (index+1) + ": "+ device.name + " (" + device.type + ") "  + " Occupied");
			return index;
		}
	}
	
	public void release(Device device) {
		synchronized (semaphore){
			for (int i = 0; i < listOfConnections.length; i++) {
				if (listOfConnections[i] == device) {
					System.out.println("Connection " + (i + 1) + ": " + device.name + " (" + device.type + ") " + "Logged out");
					listOfConnections[i] = null;
					semaphore.Release();
					break;
				}
			}
		}
	}
}
