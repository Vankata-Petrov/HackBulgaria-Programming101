import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebsiteCrawler {
	static ArrayBlockingQueue<String> resultList =new ArrayBlockingQueue<String>(100000);
	static LinkedList<String> used = new LinkedList<String>();
	static String result;

	private static void getAllLinks(String content, String url) {
		String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(content);
		while (matcher.find()) {
			// System.out.println(url+"/"+matcher.group(1));
			if(!matcher.group(1).contains("..")){
				resultList.add(url + matcher.group(1));
			}
		}
	}

	public static void search(URL url, String needle) throws Exception {
		URL newUrl = url;
		FutureTask futureTask = new FutureTask(
				new Finder(resultList,url,needle);
		Thread t=new Thread(futureTask);
		t.start();
		// …
		Boolean result = (Boolean) futureTask.get(); 
		while (true) {
			Thread thread1=new Thread(futureTask);
			used.add(newUrl.toString());
			while (true) {
				if (!used.contains(resultList.peek())) {
					newUrl = new URL(resultList.poll());
					System.out.println(newUrl.toString());
					break;
				}else{
					resultList.poll();
				}
			}
		}
		System.out.println(result);
	}

	public static boolean searchIndividual(URL url, String needle) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		String inputLine;
		//System.out.println(url.toString());
		while ((inputLine = in.readLine()) != null) {
			if (inputLine.contains(needle)) {
				result = url.toString();
				return true;
			}
			if (inputLine.contains("google") == false) {
				getAllLinks(inputLine, url.toString());
			}
		}
		in.close();
		return false;
	}
	
	private static class Finder implements Callable{
		static ArrayBlockingQueue<String> resultList;
		static URL url;
		static String needle;
		public Finder(ArrayBlockingQueue<String> list,URL url,String needle){
			resultList=list;
			this.url=url;
			this.needle=needle;
		}
		
		@Override
		public Object call() throws Exception {
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			String inputLine;
			//System.out.println(url.toString());
			while ((inputLine = in.readLine()) != null) {
				if (inputLine.contains(needle)) {
					result = url.toString();
					return true;
				}
				if (inputLine.contains("google") == false) {
					getAllLinks(inputLine, url.toString());
				}
			}
			in.close();
			return false;
		}
		
	}
}
