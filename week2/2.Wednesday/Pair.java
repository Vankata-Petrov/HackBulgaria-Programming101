import java.util.Objects;

public class Pair<F,S> {
	final F first;
	final S second;
	
	Pair(){
		first=null;
		second=null;
	}
	
	Pair(F first, S second){
		this.first=first;
		this.second=second;
	}
	
	public F getFirst() {
		return first;
	}
	
	public S getSecond() {
		return second;
	}
	
	public String toString(){
		return String.format(this.first+" "+this.second);
	}
	
	public boolean equals(Object o){
		if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }
}
