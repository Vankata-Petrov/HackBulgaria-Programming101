
public class Triple<F,S,T> {
	F first;
	S second;
	T third;
	
	Triple(){
		first=null;
		second=null;
		third=null;
	}
	
	public F getFirst() {
		return first;
	}
	public void setFirst(F first) {
		this.first = first;
	}
	
	public S getSecond() {
		return second;
	}
	public void setSecond(S second) {
		this.second = second;
	}
	
	public T getThird() {
		return third;
	}
	public void setThird(T third) {
		this.third = third;
	}
	
}
