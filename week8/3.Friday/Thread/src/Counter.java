import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
	public static AtomicInteger c=new AtomicInteger(0);
	
	public static void increment(){
		c.incrementAndGet();
	}
	public static void decrement(){
		c.decrementAndGet();
	}
	public static  int getCounter(){
		return c.get();
	}
}
