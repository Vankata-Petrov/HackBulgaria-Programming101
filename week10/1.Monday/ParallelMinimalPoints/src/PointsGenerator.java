import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PointsGenerator {
	public static List<Point> generatePoints(){
		List<Point> answer=new ArrayList<>();
		Point x=new Point();
		Random rand=new Random();
		for(int i=0;i<100000;i++){
			x.setA(rand.nextDouble()+rand.nextInt(10000));
			x.setB(rand.nextDouble()+rand.nextInt(10000));
			answer.add(x);
		}
		return answer;
	}
}