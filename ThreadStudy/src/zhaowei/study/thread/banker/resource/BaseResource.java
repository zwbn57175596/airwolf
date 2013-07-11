package zhaowei.study.thread.banker.resource;

public abstract class BaseResource implements Resource {

	protected String name;

	@Override
	public void used(String threadName) {
		// synchronized (this) {
		System.out.println("Thread " + threadName + " used : " + getName());
		// }
	}

	public String getName() {
		return name;
	}
}
