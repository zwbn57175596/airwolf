package zhaowei.study.thread.banker;

import zhaowei.study.thread.banker.resource.A;
import zhaowei.study.thread.banker.resource.B;
import zhaowei.study.thread.banker.resource.C;
import zhaowei.study.thread.banker.resource.D;

public class Customer implements Runnable {
	
	private A[] a;
	private B[] b;
	private C[] c;
	private D[] d;
	
	public Customer (int a, int b, int c, int d) {
		this.a = new A[a];
		this.b = new B[b];
		this.c = new C[c];
		this.d = new D[d];
	}
	
	public void initResource(A[] init_a, B[] init_b, C[] init_c, D[] init_d) {
		System.arraycopy(init_a, 0, a, 0, init_a.length);
		System.arraycopy(init_b, 0, b, 0, init_b.length);
		System.arraycopy(init_c, 0, c, 0, init_c.length);
		System.arraycopy(init_d, 0, d, 0, init_d.length);
	}
		
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
