import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class WordFinder implements Runnable {
	String word;
	private static ArrayBlockingQueue<File> textFiles;

	public WordFinder(String word, ArrayBlockingQueue<File> textFiles) {
		this.word = word;
		this.textFiles = textFiles;
	}

	static ConcurrentLinkedQueue<String> findedWords = new ConcurrentLinkedQueue<>();

	public static void checkInAllFiles(String word) throws InterruptedException {
		while (true) {
			checkForWord(textFiles.take(), word);
			if (TxtFileFinder.finished.get() == true && textFiles.isEmpty()) {
				break;
			}
		}
	}

	public static void checkForWord(File file, String word) {
		try {
			Scanner scanner = new Scanner(file);
			int lineNum = 0;
			while (scanner.hasNextLine()) {
				String line = scanner.nextLine();
				lineNum++;
				if (line.contains(word)) {
					findedWords.add("Word found in " + file.getName() + " at " + lineNum + " line");
				}
			}
		} catch (FileNotFoundException e) {
			// TODO:handle this
		}
	}

	@Override
	public void run() {
		System.out.println("runned");
		while (!(textFiles.size() == 0 && TxtFileFinder.finished.getAndSet(TxtFileFinder.finished.getAndSet(true))== true)) {
			try {
				File file = textFiles.take();
				Scanner scanner = new Scanner(file);
				int lineNum = 0;
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine();
					lineNum++;
					if (line.contains(word)) {
						findedWords.add("Word found in " + file.getName() + " at " + lineNum + " line");
					}
				}
			} catch (FileNotFoundException | InterruptedException e) {
				// TODO:handle this
			}
		}
		// TODO Auto-generated method stub

	}
}
