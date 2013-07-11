package zhaowei.study.thread.join;

public class CustomThread extends Thread {

	CustomThread1 thread1;
	
	public CustomThread(CustomThread1 thread1) {
		super("[CustomThread] Thread");
		this.thread1 = thread1;
	}
	
	public void run() {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");
		try {
			thread1.join();
			System.out.println(threadName + " end ");
		} catch (Exception e) {
			System.out.println("Exception from " + threadName + ".run");
		}
	}
}
