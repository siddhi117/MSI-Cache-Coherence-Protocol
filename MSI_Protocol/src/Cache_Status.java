public class Cache_Status {
	
	private boolean Modified;
	private boolean Shared;
	private boolean Invalid;
	
	public boolean isModified() {
		return Modified;
	}
	public void setModified(boolean modified) {
		Modified = modified;
		Invalid = false;
		Shared = false;
	}
	public boolean isShared() {
		return Shared;
	}
	public void setShared(boolean shared) {
		Shared = shared;
		Invalid = false;
		Modified = false;
	}
	public boolean isInvalid() {
		return Invalid;
	}
	public void setInvalid(boolean invalid) {
		Invalid = invalid;
		Shared = false;
		Modified = false;
	}
	@Override
	public String toString() {
		return "\n\t\t\t\t\t\t Cache_Status [Modified=" + Modified + ", Shared=" + Shared
				+ ", Invalid=" + Invalid + "]";
	}
	
	

}
