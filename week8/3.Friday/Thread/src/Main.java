
public class Main {
	/*private static class MyThread extends Thread{
		public void run(){
			System.out.println("Thread");
		}
	}
*/
	private static class MyThread2 implements Runnable{
		public void run(){
			System.out.println("Im a Thread");
		}

		public void join() {
			// TODO Auto-generated method stub
			
		}
	}
	public static void main(String[] args) throws InterruptedException {
		/*MyThread thread=new MyThread();
		thread.start();
		
		MyThread2 thread2=new MyThread2();
		thread2.run();
		thread2.join();//izchakva da svurshi nishkata*/
		//Divisor divisor= new Divisor(5,5);
		//Thread tread=new Thread(divisor);
		//tread.start();
		//tread.join();
		//System.out.println("Im the main Thread");
		/*Example:*/
		//System.out.println(Example.valueOfLife);
		
		//Try Counter
		MyThread threadOne=new MyThread();
		MyThread threadTwo=new MyThread();
		threadOne.start();
		threadTwo.start();
		threadOne.join();
		threadTwo.join();
		System.out.println(Counter.getCounter());
	}

}