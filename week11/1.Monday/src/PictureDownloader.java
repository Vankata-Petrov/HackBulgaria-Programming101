import java.io.*;
import java.net.URL;

public class PictureDownloader {
	public static void download(URL url,String destinationFile) throws IOException{
		InputStream inStream = url.openStream();
		OutputStream outStream = new FileOutputStream(destinationFile);

		byte[] buffer = new byte[2048];
		int length;

		while ((length = inStream.read(buffer)) != -1) {
			outStream.write(buffer, 0, length);
		}

		inStream.close();
		outStream.close();
	}
}
