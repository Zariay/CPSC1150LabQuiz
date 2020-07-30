/*
 ** Program Name: Lab05 BONUS
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         June 11, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

import java.util.Scanner;

public class EvenToOdd {
	public static void main(String args[])
	{
		// Sample test case:
		int n=26540;
		System.out.println("n= " + n + ", ans= " + even2odd(n));
		n=9528;
		System.out.println("n= " + n + ", ans= " + even2odd(n)); 
		n=984196;
		System.out.println("n= " + n + ", ans= " + even2odd(n)); 
		
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Please enter a number to convert all even digits to odd: ");
		n = inputScan.nextInt();
		
		System.out.println("The new number is: " + even2odd(n));
		
		inputScan.close();
	}
	
	/**Takes number n reverses it
	 *
	 * @param n for number to check
	 */
	public static int reverse(int n)
	{
		int reversedNumb = 0, lastDigit;
		
		while(n > 0)
		{
			lastDigit = n % 10;
			reversedNumb = (reversedNumb * 10) + lastDigit;
			n /= 10;
		}
		
		return reversedNumb;
	}

	/**changes all even digits of argument to odd digits by adding 1 to each digits
	 * 
	 * @param n: a positive integer number
	 * @return the result as an integer number
	 */
	 public static int even2odd(int n)
	 {
		 int lastDigit;
		 int rev = 0;
		 
		 while(n > 0)
		 {
			 lastDigit = n % 10;
			 if(lastDigit % 2 == 0)
			 {
				 lastDigit += 1;
				 rev = (rev * 10) + lastDigit;
			 }
			 else
				 rev = (rev * 10) + lastDigit;
			 n /= 10;
		 }
		 
		 return reverse(rev);
	 }
}
