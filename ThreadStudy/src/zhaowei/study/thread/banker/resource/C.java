package zhaowei.study.thread.banker.resource;

public class C extends BaseResource {

	@Override
	public C setName(String name) {
		this.name = C.class.getName() + name;
		return this;
	}

}
