import java.io.File;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static void main(String[] args) throws InterruptedException {

		ArrayBlockingQueue<File> textFiles = new ArrayBlockingQueue<File>(1000);
		
		Thread thread1 = new Thread(new TxtFileFinder(textFiles));
		Thread thread2 = new Thread(new WordFinder("asd", textFiles));
		Thread thread3 = new Thread(new WordFinder("asd", textFiles));
		thread1.start();
		// thread2.start();
		// thread3.start();

		/*
		 * ExecutorService executor = Executors.newFixedThreadPool(5); for (int
		 * i = 0; i < 10; i++) { Runnable worker = new
		 * WordFinder("asd",textFiles); executor.execute(worker); }
		 * executor.shutdown(); while (!executor.isTerminated()) { }
		 */
		Thread[] threads = new Thread[10];
		for (int i = 0; i < 10; i++) {
			threads[i] = new Thread(new WordFinder("asd", textFiles));
			threads[i].start();
		}
		for(Thread thread:threads){
			thread.join();
		}
		// thread2.join();
		// thread3.join();
		// thread1.join();
		for (String founded : WordFinder.findedWords) {
			System.out.println(founded);
		}
	}
}
