package zhaowei.study.thread.banker;

import zhaowei.study.thread.banker.resource.A;
import zhaowei.study.thread.banker.resource.B;
import zhaowei.study.thread.banker.resource.C;
import zhaowei.study.thread.banker.resource.D;
import zhaowei.study.thread.banker.resource.Resource;

public class Customer implements Runnable {

	private A[] a;
	private B[] b;
	private C[] c;
	private D[] d;

	private int[] needs;

	public Customer(int a, int b, int c, int d) {
		this.a = new A[a];
		this.b = new B[b];
		this.c = new C[c];
		this.d = new D[d];
		this.needs = new int[]{a, b, c, d};
	}

	public void initResource(A[] init_a, B[] init_b, C[] init_c, D[] init_d) {
		addResource(init_a, init_b, init_c, init_d);
	}

	private boolean check() {
		for (int i = 0; i < a.length; i++)
			if (null == a[i])
				return false;
		for (int i = 0; i < b.length; i++)
			if (null == b[i])
				return false;
		for (int i = 0; i < c.length; i++)
			if (null == c[i])
				return false;
		for (int i = 0; i < d.length; i++)
			if (null == d[i])
				return false;
		return true;
	}

	private void addResource(Resource[] init_a, Resource[] init_b, Resource[] init_c,
			Resource[] init_d) {
		System.out.println(Thread.currentThread().getName() + " got : " + init_a.length + ","
				+ init_b.length + "," + init_c.length + "," + init_d.length);
		if (init_a.length > 0) {
			System.arraycopy(init_a, 0, a, a.length - needs[0], init_a.length);
			this.needs[0] = a.length - init_a.length;
		}
		if (init_b.length > 0) {
			System.arraycopy(init_b, 0, b, b.length - needs[1], init_b.length);
			this.needs[1] = b.length - init_b.length;
		}
		if (init_c.length > 0) {
			System.arraycopy(init_c, 0, c, c.length - needs[2], init_c.length);
			this.needs[2] = c.length - init_c.length;
		}
		if (init_d.length > 0) {
			System.arraycopy(init_d, 0, d, d.length - needs[3], init_d.length);
			this.needs[3] = d.length - init_d.length;
		}
	}

	private void requireResource(Resource[][] resources) {
		if (null != resources) {
			addResource(resources[0], resources[1], resources[2], resources[3]);
		}
	}

	private void printerResource(String threadName) {
		for (int i = 0; i < a.length; i++)
			a[i].used(threadName);
		for (int i = 0; i < b.length; i++)
			b[i].used(threadName);
		for (int i = 0; i < c.length; i++)
			c[i].used(threadName);
		for (int i = 0; i < d.length; i++)
			d[i].used(threadName);
	}

	@Override
	public void run() {
		boolean flag = true;
		try {
			while (flag) {
				Thread.sleep(1000);
				// require resource
				requireResource(Banker.allocateResources(needs));
				// check
				flag = (!check());
			}
			printerResource(Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Banker.backResource(new Resource[][] { this.a, this.b, this.c, this.d });
		System.out.println(Thread.currentThread().getName() + " Exit.");
	}
}
