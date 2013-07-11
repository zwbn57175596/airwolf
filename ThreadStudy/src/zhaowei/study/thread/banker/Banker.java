package zhaowei.study.thread.banker;

import java.util.Vector;

import zhaowei.study.thread.banker.resource.A;
import zhaowei.study.thread.banker.resource.B;
import zhaowei.study.thread.banker.resource.C;
import zhaowei.study.thread.banker.resource.D;
import zhaowei.study.thread.banker.resource.Resource;

public class Banker {

	// 资源请求锁
	public static Object allocatorLocker = new Object();
	// 资源释放锁
	public static Object releaseLocker = new Object();

	//资源池
	private static Vector<A> a = new Vector<A>();
	private static Vector<B> b = new Vector<B>();
	private static Vector<C> c = new Vector<C>();
	private static Vector<D> d = new Vector<D>();

	/**
	 * 打印资源池的状态
	 */
	public static void printResourcePool() {
		System.out.println("Resource size=" + a.size() + "," + b.size() + "," + c.size() + ","
				+ d.size());
	}

	/**
	 * 响应线程的资源请求
	 * @param needs 请求资源数
	 * @return
	 */
	public static Resource[][] allocateResources(int[] needs) {
		synchronized (allocatorLocker) {
			printResourcePool();
			System.out.print(Thread.currentThread().getName() + "Thread needs:");
			for (int i = 0; i < needs.length; i++) {
				System.out.print(needs[i] + ",");
			}
			System.out.println();

			if (a.size() >= needs[0] && b.size() >= needs[1] && c.size() >= needs[2]
					&& d.size() >= needs[3]) {
				Resource[][] resources = new Resource[4][];
				// ALLOCATE A
				resources[0] = new Resource[needs[0]];
				for (int i = 0; i < needs[0]; i++) {
					resources[0][i] = a.remove(a.size() - 1); // 分配的资源要从池中去掉，表示给线程独享
				}
				// ALLOCATE B
				resources[1] = new Resource[needs[1]];
				for (int i = 0; i < needs[1]; i++) {
					resources[1][i] = b.remove(b.size() - 1);
				}
				resources[2] = new Resource[needs[2]];
				for (int i = 0; i < needs[2]; i++) {
					resources[2][i] = c.remove(c.size() - 1);
				}
				resources[3] = new Resource[needs[3]];
				for (int i = 0; i < needs[3]; i++) {
					resources[3][i] = d.remove(d.size() - 1);
				}
				return resources;
			} else {
				return null;
			}
		}
	}

	/**
	 * 线程用户归还资源的方法
	 * @param resources 归还的资源
	 */
	public static void backResource(Resource[][] resources) {
		synchronized (releaseLocker) {
			for (int i = 0; i < resources[0].length; i++)
				a.add((A) resources[0][i]);
			for (int i = 0; i < resources[1].length; i++)
				b.add((B) resources[1][i]);
			for (int i = 0; i < resources[2].length; i++)
				c.add((C) resources[2][i]);
			for (int i = 0; i < resources[3].length; i++)
				d.add((D) resources[3][i]);
			System.out.println("after back .");
			printResourcePool();
		}
	}

	public static void main(String[] args) {
		// 初始化资源池
		a.add(new A().setName("inital A"));
		for (int i = 0; i < 5; i++) {
			b.add(new B().setName("initial B" + i));
		}
		c.add(new C().setName("initial C" + 0));
		c.add(new C().setName("initial C" + 1));

		// 初始化客户作业信息
		Customer p1 = new Customer(0, 6, 5, 6);
		// init 0,0,1,4
		p1.initResource(new A[] {}, new B[] {}, new C[] { new C().setName("p1 C") }, new D[] {
				new D().setName("p1 D1"), new D().setName("p1 D2"), new D().setName("p1 D3"),
				new D().setName("p1 D4") });
		
		Customer p2 = new Customer(1, 9, 4, 2);
		// init 1,4,3,2
		p2.initResource(
				new A[] { new A().setName("p2 A") },
				new B[] { new B().setName("p2 B1"), new B().setName("p2 B2"),
						new B().setName("p2 B3"), new B().setName("p2 B4") },
				new C[] { new C().setName("p2 C1"), new C().setName("p2 C2"),
						new C().setName("p2 C3") },
				new D[] { new D().setName("p2 D1"), new D().setName("p2 D2") });
		
		Customer p3 = new Customer(1, 3, 5, 6);
		// init 1,3,5,4
		p3.initResource(
				new A[] { new A().setName("p3 A") },
				new B[] { new B().setName("p3 B1"), new B().setName("p3 B2"),
						new B().setName("p3 B3") },
				new C[] { new C().setName("p3 C1"), new C().setName("p3 C2"),
						new C().setName("p3 C3"), new C().setName("p3 C4"),
						new C().setName("p3 C5") },
				new D[] { new D().setName("p3 D1"), new D().setName("p3 D2"),
						new D().setName("p3 D3"), new D().setName("p3 D4") });
		
		Customer p4 = new Customer(1, 7, 5, 0);
		// init 1,0,0,0
		p4.initResource(new A[] { new A().setName("p4 A") }, new B[] {}, new C[] {}, new D[] {});
		
		Thread t1 = new Thread(p1, "p1");
		Thread t2 = new Thread(p2, "p2");
		Thread t3 = new Thread(p3, "p3");
		Thread t4 = new Thread(p4, "p4");
		t4.setPriority(Thread.MAX_PRIORITY);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		
	}

}
