import java.util.Scanner;

public class Question1 {
	final static int HOUR_IN_SEC = 3600;
	final static int MIN_IN_SEC = 60;
	public static void main (String args[])
	{
		int time, hour, sec, min;
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Please enter time in seconds: ");
		time = inputScan.nextInt();
		
		if(time < HOUR_IN_SEC)
		{
			hour = time / HOUR_IN_SEC;
			min = time / MIN_IN_SEC;
			sec = time % MIN_IN_SEC;
			
			System.out.println("Hour: " + hour);
			System.out.println("Minute: " + min);
			System.out.println("Second: " + sec);
		}
		else
		{
			hour = time / HOUR_IN_SEC;
			min = (time - (hour * HOUR_IN_SEC)) / MIN_IN_SEC;
			sec = (time - (hour * HOUR_IN_SEC)) % MIN_IN_SEC;
			
			System.out.println("Hour: " + hour);
			System.out.println("Minute: " + min);
			System.out.println("Second: " + sec);
		}
		

		System.out.println("The smallest number greater than 11 that is divisible by 2 and not divisible by 3 is " + theValue(2, 3, 11));
		System.out.println("The smallest number greater than 11 that is divisible by 4 and not divisible by 6 is " + theValue(4, 6, 34));
		inputScan.close();
	}
	
	public static double series(int n)
	{
		double x = 0;
		
		for(int i = 1; i <= n; i ++)
		{
			x += i/(Math.sqrt(i) + Math.sqrt(i+1));
		}
		
		return x;
	}
	
	public static int theValue(int a, int b, int n)
	{
		int ans = n;
		boolean found = false;
		while(!found)
		{
			n += 1;
			if(n % a == 0 && (n % b != 0))
			{
				ans = n;
				found = true;
			}
		}
		return ans;
	}
}
