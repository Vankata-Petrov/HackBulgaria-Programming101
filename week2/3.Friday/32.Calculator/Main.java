import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Calculator calculator=new Calculator();
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		
		while(!input.equals("exit"))
		{
			System.out.println(calculator.calculate(input));
			input=sc.nextLine();
		}
		
		sc.close();
	}
}
