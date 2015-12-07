package zhaowei.study.thread.banker.resource;

public class A extends BaseResource {

	@Override
	public A setName(String name) {
		this.name = A.class.getName() + name;
		return this;
	}

}
