package zhaowei.study.thread.productcustom;

public class Factory {

	// private static Stack<Integer> products = new Stack<Integer>();

	private static int MAX_SIZE = 5;

	private static Integer[] products = new Integer[MAX_SIZE];

	public static void product(Integer product) {
		synchronized (products) {
			if (!isFull()) {
				for (int i = MAX_SIZE - 1; i >= 0; i--) {
					if (products[i] == null) {
						products[i] = product;
						System.out.println("product " + product + " has been produced by "
								+ Thread.currentThread().getName());
						return;
					}
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " is waiting.");
			}
		}
	}

	public static Integer expense() {
		synchronized (products) {
			if (!isEmpty()) {
				for (int i = MAX_SIZE - 1; i >= 0; i--) {
					if (products[i] != null) {
						Integer product = products[i];
						System.out.println("product " + product + " has been expensed by "
								+ Thread.currentThread().getName());
						products[i] = null;
						return product;
					}
				}
			} else {
				System.out.println(Thread.currentThread().getName() + " is waiting.");
			}
			return null;
		}
	}

	private static boolean isEmpty() {
		synchronized (products) {
			for (int i = 0; i < products.length; i++) {
				if (products[i] != null) {
					return false;
				}
			}
			return true;
		}
	}

	private static boolean isFull() {
		synchronized (products) {
			for (int i = 0; i < products.length; i++) {
				if (products[i] == null) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Queue q = new Queue();
		for (int i = 0; i < 3; i++) {
			new Thread(new Productor(q), "Productor" + i).start();
		}

		for (int i = 0; i < 2; i++) {
			new Thread(new Customer(q), "Customer" + i).start();
		}

	}

}
