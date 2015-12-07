import java.util.Collection;

public class UniqueElement {

	public static <T> T getFirstUniqueElement(Collection<T> collection){
	
		boolean check=true;
		int i=0;
		int j=0;
		
		for(T item1:collection){
			i++;
			
			for(T item2:collection){
				j++;
				if(j>i && item1.equals(item2)){
					check=false;
					break;
				}
			}
			
			if(check==true){
				return item1;
			}
			check=true;
			j=0;
		}
		
		return null;
	}
}
