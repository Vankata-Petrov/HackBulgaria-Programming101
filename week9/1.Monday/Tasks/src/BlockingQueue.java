import java.util.LinkedList;

public class BlockingQueue<T> {
	private LinkedList<T> queue=new LinkedList<T>();
	boolean isTrue=true;
	
	public synchronized boolean add(T key){
		queue.add(key);
		if(queue.size()==1) {
			isTrue=false;
			notifyAll();
		}
		System.out.println("added");
		return true;
	}
	
	public synchronized T poll() throws InterruptedException{
		while(isTrue){
			wait();
		}
		if(queue.size()==1){
			isTrue=true;
		}
		System.out.println("Polled");
		return queue.poll();
	}
}
