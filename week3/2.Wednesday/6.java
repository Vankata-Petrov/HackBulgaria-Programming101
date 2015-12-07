import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class DuplicatingElements {
	public static <T> Set<T> getDuplicatingElements(Collection<? extends Set<T>> collection) {

		int setCounter = 0;
		int check = 0;
		
		Set<T> result = new HashSet<>();

		for (Set<T> set1 : collection) {
			for (T item1 : set1) {
				for (Set<T> set2 : collection) {
				
					setCounter++;
					if (setCounter > 1) {

						for (T item2 : set2) {
							if (item1.equals(item2)) {
								check ++;
								break;
							}
						}
					}
				}
				
				setCounter=0;
				if (check ==collection.size()-1) {
					result.add(item1);
				}
				check = 0;
			}
			break;
		}
		return result;
	}
}
