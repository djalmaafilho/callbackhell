package callbackhell;

public class BackgroundProcess extends Thread {
	
	private Process callback;

	public BackgroundProcess(Process callback) {
		super();
		this.callback = callback;
	}
	
	@Override
	final public void run() {
		try {
			super.run();
			callback.onResult(callback.process());
		} catch (Exception e) {
			callback.onError(e);	
		}
	}
}
