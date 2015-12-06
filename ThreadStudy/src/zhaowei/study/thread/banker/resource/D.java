package zhaowei.study.thread.banker.resource;

public class D extends BaseResource {

	@Override
	public D setName(String name) {
		this.name = D.class.getName() + name;
		return this;
	}

}
