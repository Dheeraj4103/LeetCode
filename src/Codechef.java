import java.util.Scanner;

public class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		int t;
		Scanner in = new Scanner(System.in);
		t = in.nextInt();
		for (int i = 0; i < t; i++){
			int a, b, n;
			a = in.nextInt();
			b = in.nextInt();
			n = in.nextInt();
			System.out.println(Fibonacci(a, b, n));
		}
		
	}
	static int Fibonacci(int a, int b, int n){
	    if (n == 0){
	        return a;
	    }
	    if (n == 1){
	        return b;
	    }
	    
	    return Fibonacci(a, b, n-1) ^ Fibonacci(a, b, n-2);
	}
}