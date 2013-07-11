package zhaowei.study.thread.productcustom;

public class Queue {
	// private static Stack<Integer> products = new Stack<Integer>();

	private static int MAX_SIZE = 100;

	private static Integer[] products = new Integer[MAX_SIZE];

	public synchronized void product(Integer product) {
		try {
			while (isFull()) {
				System.out.println(Thread.currentThread().getName() + " is waiting.");
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		for (int i = MAX_SIZE - 1; i >= 0; i--) {
			if (products[i] == null) {
				products[i] = product;
				System.out.println("product " + product + " has been produced by "
						+ Thread.currentThread().getName());
				notify();
				return;
			}
		}

	}

	public synchronized Integer expense() {
		try {
			while (isEmpty()) {
				System.out.println(Thread.currentThread().getName() + " is waiting.");
				wait();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (int i = MAX_SIZE - 1; i >= 0; i--) {
			if (products[i] != null) {
				Integer product = products[i];
				System.out.println("product " + product + " has been expensed by "
						+ Thread.currentThread().getName());
				products[i] = null;
				notify();
				return product;
			}
		}
		return null;
	}

	private synchronized boolean isEmpty() {
		for (int i = 0; i < products.length; i++) {
			if (products[i] != null) {
				return false;
			}
		}
		return true;
	}

	private synchronized boolean isFull() {
		for (int i = 0; i < products.length; i++) {
			if (products[i] == null) {
				return false;
			}
		}
		return true;
	}
}
