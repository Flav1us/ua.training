package main;

public abstract class Institute extends Thread {
	public volatile Queue queue;
	
	public Institute(){}
	
	public Institute(Queue queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true) {
			try {
				processQueue();
				sleep(10);
			} catch (IndexOutOfBoundsException e) {
				break;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	protected abstract void processQueue();
}

