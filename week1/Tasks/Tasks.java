import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// int n;
		// n = sc.nextInt();
		// System.out.println(getLargestPalindrome(n));
		/*
		 * if (isPrime(n)) System.out.println("Prime"); else
		 * System.out.println("Not"); int[] arr=new int[n];
		 * 
		 * for(int i=0;i<n;i++) { arr[i]=sc.nextInt(); }
		 * 
		 * System.out.println(getOddOccurrence(arr));
		 */
		// int a[]={1,4,2,1,4,4,4};
		String a = "daadva";
		String b="ppadppdappapp";
		System.out.println(hasAnagramOf(a, b));
		sc.close();
	}

	static int getAverage(int[] array) {
		int average = 0;
		for (int i = 0; i < array.length; i++)
			average += array[i];
		return average / array.length;

	}

	static int partition(int arr[], int left, int right) {
		int i = left, j = right;
		int tmp;
		int pivot = arr[(left + right) / 2];
		while (i <= j) {
			while (arr[i] < pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i <= j) {
				tmp = arr[i];
				arr[i] = arr[j];
				arr[j] = tmp;
				i++;
				j--;
			}
		}
		;
		return i;
	}

	static void quickSort(int arr[], int left, int right) {
		int index = partition(arr, left, right);
		if (left < index - 1)
			quickSort(arr, left, index - 1);
		if (index < right)
			quickSort(arr, index, right);
	}

	static int kthMin(int k, int[] array) {
		quickSort(array, 0, array.length - 1);
		return array[k - 1];
	}

	static boolean isPrime(int n) {
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return n > 1;
	}

	static long getSmallestMultiple(int upperBound) {
		/*
		 * while(true) { for(int j=1;j<=upperBound;j++) if(i%j!=0)
		 * {check=false;break;} if(check==Boolean.TRUE) return i; else
		 * {check=true;i++;} }
		 */
		long nok = 1;
		long a, b;
		for (int i = 2; i <= upperBound; i++) {
			a = nok;
			b = i;
			while (a != b) {
				if (a < b)
					b -= a;
				else
					a -= b;
			}
			nok *= i / a;
		}
		return nok;
	}

	static boolean isOdd(int n) {
		return n % 2 != 0;
	}

	static long factoriel(long n) {
		if (n == 2)
			return 2;
		return factoriel(n - 1) * n;
	}

	static long doubleFac(int n) {
		return factoriel(factoriel(n));
	}

	static long getLargestPalindrome(long n) {
		if (n >= 0 && n <= 9)
			return n;
		else if (n == 10)
			return 9;
		long temp, newN = 0;
		for (long i = n; i > 10; i--) {
			temp = i;
			while (temp != 0) {
				newN *= 10;
				newN += temp % 10;
				temp /= 10;
			}
			if (newN == i)
				return newN;
			newN = 0;
		}
		return 0;
	}

	static int getOddOccurrence(int[] array) {
		int[] used = new int[array.length];
		int occurrence;
		for (int i = 0; i < array.length; i++) {
			occurrence = 0;
			if (used[i] != 0)
				continue;
			for (int j = i; j < array.length; j++) {
				if (array[i] == array[j]) {
					used[i] = used[j] = 1;
					occurrence++;
				}
			}
			if (occurrence % 2 != 0)
				return array[i];
		}
		return 0;
	}

	static long maximalScalarSum(int[] a, int[] b) {
		quickSort(a, 0, a.length - 1);
		quickSort(b, 0, b.length - 1);
		long scalar = 0;
		for (int i = 0; i < a.length; i++) {
			scalar += a[i] * b[i];
		}
		return scalar;
	}

	static int maxSpan(int[] numbers) {
		boolean[] used = new boolean[numbers.length];
		int maxValue = 0;
		for (int i = 0; i < numbers.length; i++) {
			if (used[i] == true)
				continue;
			used[i] = true;
			for (int j = i; j < numbers.length; j++) {
				if (numbers[i] == numbers[j]) {
					used[j] = true;
					if (maxValue < j - i + 1)
						maxValue = j - i + 1;
				}
			}
		}
		return maxValue;
	}

	static String copyEveryChar(String input, int k) {
		String newString = "";
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j < k; j++) {
				newString += input.charAt(i);
			}
		}
		return newString;
	}

	// asd*dsaa size 0-14 12 11-13 10-14
	static int getPalindromeLength(String input) {
		int pLength = 0, maxLength = 0;
		for (int j = 0; j < input.length(); j++) {
			if (input.charAt(j) == '*') {
				int i = j - 1;
				pLength = 0;
				while (i >= 0 && j + (j - i) < input.length()) {
					if (input.charAt(i) == input.charAt(j + j - i)) {
						pLength++;
					} else {
						break;
					}
					i--;
				}
				if (maxLength < pLength)
					maxLength = pLength;
			}
		}
		return maxLength;
	}

	static String reverseEveryChar(String arg) {
		String word = "", result = "";
		for (int i = 0; i < arg.length(); i++)
			if ((arg.charAt(i) >= 'A' && arg.charAt(i) <= 'Z') || (arg.charAt(i) >= 'a' && arg.charAt(i) <= 'z')
					|| (arg.charAt(i) >= '0' && arg.charAt(i) <= '9')) {
				word = arg.charAt(i) + word;
			} 
			else {
				result += word + arg.charAt(i);
				word = "";
			}

		result += word;
		return result;
	}
	
	static int countOccurrences(String needle, String haystack){
		int index=0,occurrence=0;
		index=haystack.indexOf(needle,index);
		while(index!=-1){
			if(index!=-1) occurrence++;
			index+=1;
			index=haystack.indexOf(needle,index);
		}
		return occurrence;
	}
	
	static boolean hasAnagramOf(String a, String b){
		int number=0,index=0;
		for(int i=0;i<a.length();i++){
			index=b.indexOf(a.charAt(i));
				if(index!=-1) {
					number++;
					if(index>0 && index<b.length()-1) {
						
						b=(b.substring(0, index)+b.substring(index+1,b.length()));
					}
						else if(index==0) b=b.substring(index+1,b.length());
						else if(index==b.length()-1) b=b.substring(0,index);
				}
		}
		if(number==a.length()) return true;
		//if(number==a.length() && b.empty=true)
		else return false;
	}
}
