import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File file=new File("/media/vankata/ARHIVE/Downloads/TestJavaTask/testData/B/b");
		File file2=new File("subtitle.srt");
		WordCountResult rs=FileUtils.wordCount(file);
		//rs.print();
		//Properties.parseProperties(file);
		FileUtils.fixEncoding(file2.toPath());
		//System.out.println("");;
	}

}
