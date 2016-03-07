import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Path;

public class FileUtils {

	private FileUtils() {

	}

	private static FileUtils mInstance;

	public static FileUtils getInstance() {
		if (mInstance == null) {
			mInstance = new FileUtils();
		}
		return mInstance;
	}

	static String readFrom(File file) throws IOException {
		StringBuilder input = new StringBuilder();
		BufferedReader inputStream = null;
		try {
			inputStream = new BufferedReader(new FileReader(file));
			String line;
			while ((line = inputStream.readLine()) != null) {
				input.append(line);
				input.append(System.lineSeparator());
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return input.toString();
	}

	static String readFrom(Path path) throws IOException {
		return readFrom(path.toFile());
	}

	static WordCountResult wordCount(File file) throws IOException {
		BufferedReader inputStream = null;
		int words = 0;
		int lines = 0;
		int characters = 0;
		try {
			inputStream = new BufferedReader(new FileReader(file));
			String line;
			while ((line = inputStream.readLine()) != null) {
				lines++;
				line.replaceAll("\\t", "");
				String[] myWords = line.replaceAll("\\s+", " ").split(" ");
				words += myWords.length;

				for (String word : myWords) {
					characters += word.length();
				}
			}
		} finally {
			if (inputStream != null) {
				inputStream.close();
			}
		}
		return new WordCountResult(words, lines, characters);
	}

	static WordCountResult wordCount(Path path) throws IOException {
		return wordCount(path.toFile());
	}

	static void fixEncoding(Path path) throws IOException {
		BufferedReader reader=null;
		BufferedWriter writer=null;
		try {
			reader = new BufferedReader(new FileReader(path.toFile()));
			writer = new BufferedWriter(new FileWriter("text2.txt"));
			String value;
			String retValue;
			ByteBuffer convertedBytes = null;
			String convertValue2;
			CharsetEncoder encoder2 = Charset.forName("Windows-1252").newEncoder();
			CharsetEncoder encoder3 = Charset.forName("UTF-8").newEncoder();
			ByteBuffer conv1Bytes;
			while ((value = reader.readLine()) != null) {
				assert encoder2.canEncode(value);
				assert encoder3.canEncode(value);
				//conv1Bytes= encoder2.encode(CharBuffer.wrap(value.toCharArray()));

				//retValue = new String(conv1Bytes.array(), Charset.forName("Windows-1252"));

				convertedBytes = encoder3.encode(CharBuffer.wrap(value.toCharArray()));
				convertValue2 = new String(convertedBytes.array(), Charset.forName("UTF-8"));
				System.out.println(convertValue2);
				writer.write(convertValue2);
				writer.write(System.lineSeparator());
			}
		} finally {
			if(reader!=null){
				reader.close();
			}
			if(writer!=null){
				writer.close();
			}
		}
	}
}