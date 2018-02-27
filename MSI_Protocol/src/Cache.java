import java.util.ArrayList;

public class Cache {

	private ArrayList<Integer> CacheData = new ArrayList<Integer>();
	
	
	private Cache_Status Cache_Status;

	public ArrayList<Integer> getCacheData() {
		return CacheData;
	}

	public void setCacheData(ArrayList<Integer> cacheData) {
		CacheData = cacheData;
	}

	public Cache_Status getCache_Status() {
		return Cache_Status;
	}

	public void setCache_Status(Cache_Status cache_Status) {
		Cache_Status = cache_Status;
	}

	@Override
	public String toString() {
		return "\n\t\t\t\t Cache [CacheData=" + CacheData + ",\n\t\t\t\t\t Cache_Status="
				+ Cache_Status + "]";
	}

	
	
	
}
