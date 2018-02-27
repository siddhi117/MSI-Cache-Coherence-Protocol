import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class MSI {

	public static int processor_size = 4;
	//public static int[] shared_memory = { 10, 20, 30, 40 };
	//Thread-safe arraylist of Shared Memory
	public static CopyOnWriteArrayList<Integer> shared_memory = new CopyOnWriteArrayList<Integer>();
	public static HashMap<Integer, Processor> processorCache = new HashMap<Integer, Processor>();

	public static void main(String args[]) {
		InitializeCache(processor_size);
		Scanner reader = new Scanner(System.in);
		int processor_Id;
		
/**** Operation:1 ------ Perform Read Operation */
		
		System.out.println("To Read the Data 20 from the Cache of processor 1 ");
		System.out.println("----------------------------------- Read( p1, 20) -------------------------------------------");
		
		System.out.println("Enter the processor on which read opearation peroform");  
		processor_Id = reader.nextInt();
		
		processorCache.get(processor_Id).getProcessor_request().setReadMiss(true);                       /** Read Miss */
		
		for (int j=0; j < shared_memory.size(); j++){
			processorCache.get(processor_Id).getProcessor_Cache().getCacheData().add(shared_memory.get(j));
		}
		
		processorCache.get(processor_Id).getProcessor_Cache().getCache_Status().setModified(true);             /** Status Changed to Modified */
		
		System.out.println("Processor Cache" +processorCache);
		
		
/** Operation: 2 ------- Perform Write operation: */
		
		System.out.println("To Write the data 70 on memory location 1 on cache of processor - 1");
		System.out.println("------------------------------------  write(p1, 70) ---------------------------------------");
		
		System.out.println("Enter the proessor on which write operation perform");
		processor_Id = reader.nextInt();
		
		
		processorCache.get(processor_Id).getProcessor_Cache().getCacheData().set(1, 70);  
		
		processorCache.get(processor_Id).getProcessor_request().setRead(true); /** Write on cache */
		
		
		System.out.println("Processor Cache" +processorCache);
		
		
		
/** operation:3 -------- Perform Read operation with processor 2 */
		
		System.out.println("To Read the data 30 by processor - 2 on location 2 of cache");
		System.out.println("--------------------------------------- read(p2, 30) -----------------------------------");
		System.out.println("Initially cache of p-2 has no data so it will be Read Miss and request go to Bus");
		
		
		
/** Data copy from cache of processor 1 to Shared Memory */
		System.out.println("Enter processor Id");
		processor_Id = reader.nextInt();
		
		shared_memory.clear();
	    shared_memory.addAll(processorCache.get(processor_Id).getProcessor_Cache().getCacheData());

		
	    
	    System.out.println("Copy Data From shared memory to cache of processor - 2");
	    System.out.println("------------------------------ Data read by processor 2-----------------------------------");
	    /* Copy from memory to cache */
	    
	    System.out.println("Enter the cache id of processor in which data should be copy from shared memory");
		processor_Id = reader.nextInt();
		
		processorCache.get(processor_Id).getProcessor_request().setReadMiss(true);                            /** Read Miss */
		
		for ( int n=0; n < shared_memory.size(); n++) {
		processorCache.get(processor_Id).getProcessor_Cache().getCacheData().add(shared_memory.get(n));
		}
		
		processorCache.get(processor_Id).getProcessor_Cache().getCache_Status().setModified(true);            /** set to Modified */
		
		System.out.println("Processor Cache" +processorCache); 

		
/** Operation: 4 ------- Perform Write operation on processor 2: */
		
		System.out.println("To Write the data 50 on memory location 2 on cache of processor - 2");
		System.out.println("------------------------------------  write(p2, 50) ---------------------------------------");
		
		System.out.println("Enter the processor on which write operation perform");
		processor_Id = reader.nextInt(); 
	
		processorCache.get(processor_Id).getProcessor_Cache().getCacheData().set(2, 50);
		
		processorCache.get(processor_Id).getProcessor_request().setWrite(true);                                 /** Write on cache */                              
		
		System.out.println("Processor Cache" +processorCache);  
		
		}

	
	private static void InitializeCache(int processor_size) {
		shared_memory.add(10);
		shared_memory.add(20);
		shared_memory.add(30);
		shared_memory.add(40);
		
		for (int i = 0; i < processor_size; i++) {
			Cache cache = new Cache();

			Cache_Status cache_Status = new Cache_Status();
			cache_Status.setInvalid(true);
			cache.setCache_Status(cache_Status);

			Processor processor = new Processor();
			processor.setProcessor_Id(i);

			Request processor_request = new Request();
			processor_request.setInvalidate(true);
			processor.setProcessor_request(processor_request);

			processor.setProcessor_Cache(cache);

			processorCache.put(i, processor);

		}
	}
}
