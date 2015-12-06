package zhaowei.study.thread.productcustom;

public class Productor implements Runnable {
	
	private Queue queue;
	
	public Productor(Queue queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(600);
//				Factory.product(Product.getProduct());
				queue.product(Product.getProduct());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
