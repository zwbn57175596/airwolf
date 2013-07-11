package zhaowei.study.thread.banker.resource;

public interface Resource {
	
	public void used (String threadName) ;
	
	public String getName();
	
	public Resource setName(String name);

}
