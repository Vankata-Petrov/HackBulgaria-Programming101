import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class GenericCollectionsOperations {

	public static <T> void  reverse (Collection<T> collection){
	
		List<T> reversed=new LinkedList<>();
		
		for(T element:collection){
			((LinkedList<T>) reversed).addFirst(element);
		}
		collection.clear();
		collection.addAll(reversed);
		
	}
	
	public static <T> void rotate(Collection<T> collection, int rotateStep){
	
		List<T> rotated=new LinkedList<>(collection);
		
		if(rotateStep>0){
			for(int i=0;i<rotateStep;i++){
				((LinkedList<T>) rotated).addFirst(((LinkedList<T>) rotated).getLast());
				((LinkedList<T>) rotated).pollLast();
			}
		}
		
		else if(rotateStep<0){
			for(int i=rotateStep;i<0;i++){
				((LinkedList<T>) rotated).addLast(((LinkedList<T>) rotated).getFirst());
				((LinkedList<T>) rotated).pollFirst();
			}
		}
		
		collection.clear();
		collection.addAll(rotated);
		System.out.println(collection);
		
	}
	
}
