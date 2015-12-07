import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class StatisticsImplement implements Statistics{
	private Set<Integer> storage=new TreeSet<>();
	private Map<Integer,Integer> counter=new HashMap<>();
	private long sum=0;
	private int min=Integer.MAX_VALUE;
	private int max=Integer.MIN_VALUE;
	private long capacity=0;
	
	public void add(int item){
	
		storage.add(item);
		capacity++;
		sum+=item;
		
		if(counter.get(item)==null){
			counter.put(item, 0);
		}
		
		counter.put(item, counter.get(item)+1);
		
		if(max<item){
			max=item;
		}
		
		if(min>item){
			min=item;
		}
	}
	
	@Override
	public int getMean() {
		return (int) (sum/capacity);
	}

	@Override
	public int getMedian() {
		int possition=0;
		
		for(Integer item:storage){
			possition+=counter.get(item);
			if((float)possition>=(float)capacity/2){
				return item;
			}
		}
		return 0;
	}

	@Override
	public int getMode() {
		int maxCount=0;
		int item=0;
		
		for(Map.Entry<Integer,Integer> currItem:counter.entrySet()){
				if(maxCount<currItem.getValue()){
					item=currItem.getKey();
					maxCount=currItem.getValue();
				}
			}
		return item;
	}

	@Override
	public int getRange() {
		return max-min;
	}

}
