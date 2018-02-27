public class Request {
	private boolean Read;
	private boolean ReadMiss;
	private boolean write;
	private boolean writeMiss;
	private boolean invalidate;
	
	public boolean isRead() {
		return Read;
	}
	public void setRead(boolean read) {
		Read = read;
		ReadMiss = false;
		write = false;
		writeMiss = false;
		invalidate = false;
	}
	public boolean isReadMiss() {
		return ReadMiss;
	}
	public void setReadMiss(boolean readMiss) {
		ReadMiss = readMiss;
		Read = false;
		write = false;
		writeMiss = false;
		invalidate = false;
	}
	public boolean isWrite() {
		return write;
	}
	public void setWrite(boolean write) {
		this.write = write;
		writeMiss = false;
		ReadMiss = false;
		invalidate = false;
		Read = false;
	}
	public boolean isWriteMiss() {
		return writeMiss;
	}
	public void setWriteMiss(boolean writeMiss) {
		this.writeMiss = writeMiss;
		write = false;
		Read = false;
		invalidate = false;
		ReadMiss = false;
	}
	public boolean isInvalidate() {
		return invalidate;
	}
	public void setInvalidate(boolean invalidate) {
		this.invalidate = invalidate;
		Read = false;
		ReadMiss = false;
		write = false;
		writeMiss = false;
	}
	@Override
	public String toString() {
		return "\n\t\t\t Request [Read=" + Read + ", ReadMiss=" + ReadMiss + ", write="
				+ write + ", writeMiss=" + writeMiss + ", invalidate="
				+ invalidate + "]";
	}
	
	
	

}
