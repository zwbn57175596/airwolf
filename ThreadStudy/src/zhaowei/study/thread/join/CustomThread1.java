package zhaowei.study.thread.join;

public class CustomThread1 extends Thread {

	public CustomThread1() {
		super("[CustomThread1] Thread");
	}

	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");
		try {
			for (int i = 0; i < 5; i++) {
				System.out.println(threadName + " loop at " + i);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Exception from " + threadName + ".run"); 
		}
	}
}
