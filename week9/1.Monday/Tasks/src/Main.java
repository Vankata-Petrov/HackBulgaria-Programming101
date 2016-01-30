
public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BlockingQueue<Integer> queue=new BlockingQueue<>();
		Thread thread1=new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					queue.poll();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			};
		});
		Thread thread2=new Thread(new Runnable(){

			@Override
			public void run() {
				queue.add(5);
			}
			
		});
		thread1.start();
		thread2.start();
	}

}
