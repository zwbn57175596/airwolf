package zhaowei.study.thread.banker.resource;

public class B extends BaseResource {

	@Override
	public B setName(String name) {
		this.name = B.class.getName() + name;
		return this;
	}
	
}
