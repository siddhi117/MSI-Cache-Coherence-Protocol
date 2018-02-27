public class Processor {

	private int processor_Id;
	
	private Request processor_request;
	
	private Cache processor_Cache;

	public int getProcessor_Id() {
		return processor_Id;
	}

	public void setProcessor_Id(int processor_Id) {
		this.processor_Id = processor_Id;
	}

	public Request getProcessor_request() {
		return processor_request;
	}

	public void setProcessor_request(Request processor_request) {
		this.processor_request = processor_request;
	}

	public Cache getProcessor_Cache() {
		return processor_Cache;
	}

	public void setProcessor_Cache(Cache processor_Cache) {
		this.processor_Cache = processor_Cache;
	}

	@Override
	public String toString() {
		return "\n\t Processor [processor_Id=" + processor_Id
				+ ", \n\t\t processor_request=" + processor_request
				+ ", \n\t\t\t processor_Cache=" + processor_Cache + "]";
	}
	
	
	
}
