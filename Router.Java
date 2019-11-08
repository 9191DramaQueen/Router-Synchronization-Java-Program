class Router{
	private static Device[] listOfConnections;
	private Device device;
	private LabSemaphore sema;
	@SuppressWarnings("static-access")
	public Router(String name , String type , LabSemaphore sema) {
		device.name = name;
		device.type = type;
		this.sema = sema;
		listOfConnections = new Device[this.sema.value];
		for(int i = 0 ;  i < listOfConnections.length ; i++) {
			listOfConnections[i] = null;
		}
		device.start();
	}
	public Router(){
		
	}
	public void occupy(Device dev) {
		for(int i = 0 ; i < listOfConnections.length ; i++) {
			if(listOfConnections[i].equals(null)) {
				listOfConnections[i] = dev;
				break;
			}
		}
	}
	public void release(Device dev) {
		for(int i = 0 ; i < listOfConnections.length ; i++) {
			if(listOfConnections[i].equals(dev)) {
				listOfConnections[i] = null;
				break;
			}
		}
	}
	@SuppressWarnings("static-access")
	public void printList() {
		for(int i = 0 ; i < listOfConnections.length ; i++) {
			if(listOfConnections[i].equals(null))
				System.out.println("Device Name :    , Type :    ");
			else
				System.out.println("Device Name : " + listOfConnections[i].name + " , Type : " + listOfConnections[i].type);
		}
	}
}

