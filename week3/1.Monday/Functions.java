import java.util.ArrayList;

public class Functions {

	public static <T1 extends Number, T2 extends Number> double add(T1 first, T2 second) {
		return first.doubleValue() + second.doubleValue();
	}
	
	public static <T1 extends Number, T2 extends Number> double subtract(T1 first, T2 second) {
		return first.doubleValue() - second.doubleValue();
	}
	
	public static <T1 extends Number, T2 extends Number> double divise(T1 first, T2 second) {
		return first.doubleValue()/second.doubleValue();
	}
	
	public static <T1 extends Number, T2 extends Number> double multiply(T1 first, T2 second) {
		return first.doubleValue()*second.doubleValue();
	}
	
	public static <T1 extends Number, T2 extends Number> double pow(T1 first, T2 second) {
		return java.lang.Math.pow(first.doubleValue(),second.doubleValue());
	}
	
	public static <T extends Number> double factoriel(T n) {
		if (n.doubleValue() <=(double)2)
			return (double)n;
		return multiply(factoriel(subtract(n,1)) , n);
	}
	
	public static <T extends Comparable<T>> T minimumElement(ArrayList<T> array){
		T min=array.get(0);
		for(T x:array){
			if(min.compareTo(x)==1){
				min=x;
			}
		}
		return min;
	}
	
	public static <T> boolean isPalindrome(T palindrome){
		StringBuilder reversed=new StringBuilder(palindrome.toString());
		reversed.reverse();
		
		if(reversed.toString().compareTo(palindrome.toString())==0){
			return true;
		}
		else return false;
	}
}
