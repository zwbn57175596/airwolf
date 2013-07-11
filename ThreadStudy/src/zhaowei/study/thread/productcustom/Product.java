package zhaowei.study.thread.productcustom;

public class Product {
	private static int SN = 0;
	public synchronized static Integer getProduct() {
		return new Integer(SN++);
	}
	public static void main(String[] args) {
		
		for (int i = 0; i < 10; i ++) {
			new Thread(new TestProduct(), "Thread" + i).start();
		}
	}
}

class TestProduct implements Runnable {

	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName() + "produce: " + Product.getProduct());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}