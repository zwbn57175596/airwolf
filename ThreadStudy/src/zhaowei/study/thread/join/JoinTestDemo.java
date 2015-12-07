package zhaowei.study.thread.join;

public class JoinTestDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String threadName = Thread.currentThread().getName();
		System.out.println(threadName + " start.");
		CustomThread1 thread1 = new CustomThread1();
		CustomThread thread = new CustomThread(thread1);
		
		try {
			thread1.start();
			Thread.sleep(2000);
			thread.start();
			// thread.join(); // 
		} catch (Exception e) {
			System.out.println("Exception from main");
		}
		
		System.out.println(threadName + " end! ");
	}

}
