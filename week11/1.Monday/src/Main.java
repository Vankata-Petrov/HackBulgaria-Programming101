import java.io.IOException;
import java.net.URL;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//	try {
		//	PictureDownloader.download
			//(new URL("http://media.creativebloq.futurecdn.net/sites/creativebloq.com/files/images/2015/09/google_logo.jpg"),
			//		"./image.jpg");
		//} catch (IOException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//}needle
		
		try {
			WebsiteCrawler2.findNeedle(new URL("http://ebusiness.free.bg/"), "����");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
