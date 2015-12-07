package zhaowei.study.thread.productcustom;

public class Customer implements Runnable {

	private Queue queue;
	
	public Customer(Queue queue) {
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(600);
//				Factory.expense();
				queue.expense();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
