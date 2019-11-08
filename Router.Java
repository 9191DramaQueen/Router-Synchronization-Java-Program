import java.util.Vector;

class Router{ 
	private static Vector<Device> listOfConnections;
	private Device currentDevice;
	private semaphore sema;
	public Router() {
		listOfConnections = new Vector<Device>();
		currentDevice = null;
		sema = null;
	}
	public Router(Device device , semaphore sema) {
		currentDevice = device;
		this.sema = sema;
	}
	public synchronized void run() throws InterruptedException {
		if(sema.value > 0) {
			listOfConnections.add(currentDevice);
			sema.P();
			currentDevice.run();
			int index = listOfConnections.indexOf(currentDevice);
			listOfConnections.remove(index);
			sema.V();
		}
		else {
			currentDevice.wait();
		}
	}
	public Vector<Device> getListOfConnections(){
		return listOfConnections;
	}
	public void showRouterList() {
		for(int i = 0 ; i < listOfConnections.size() ; i++) {
			System.out.println("Device : " + listOfConnections.get(i).name + " Type : " + listOfConnections.get(i).type);
		}
	}
}

