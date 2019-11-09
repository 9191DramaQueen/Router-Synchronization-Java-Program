
class LabSemaphore{
	protected int value = 0 ;
	protected LabSemaphore() {
			value = 0 ;
	}
	protected LabSemaphore(int initial) { 
		value = initial ; 
	}
	public synchronized void Lock() {
		value-- ;
		if ( value < 0)
			try { 
				wait() ; 
			}catch(InterruptedException e) { 
				
			}
	}
	public synchronized void Release() {
		value++ ; 
		if (value <= 0) 
			notify() ;
		}
	public boolean aPlaceExists() {
		return value > 0;
	}
}
