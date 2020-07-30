/*
 ** Program Name: Lab05
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         June 10, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

import java.util.Scanner;
public class Lab05 {
	public static void main(String args[])
	{
		Scanner inputScan = new Scanner(System.in);
		int inputNumber;
		
		System.out.println("Please enter a value for us to check find all prime palindrome numbers that are before that number.");
		inputNumber = inputScan.nextInt();
		
		for(int i = 0; i < inputNumber; i += 1)
		{
			if(isPrime(i) && isPalindrome(i))
				System.out.print(i + " ");
		}

		inputScan.close();
	}
	
	/**Takes number n and returns true if it is a prime number (divisible by 1 and itself)
	 * Otherwise it returns false
	 * 
	 * To check if the number is a prime number, start by dividing by 2 up to half of the original
	 * 
	 * @param n for number to check
	 */
	public static boolean isPrime(int n)
	{
		if(n == 0 || n == 1)
			return false;
		
		int primeCheck;
		for(int i = 2; i <= n/2; i++)
		{
			primeCheck = n%i;
			if(primeCheck == 0)
				return false;
		}
		return true;
	}
	
	/**Takes number n and returns true if it is a palindrome (reads the same forwards and backwards)
	 * Otherwise it returns false
	 * 
	 * To check if a number is a palindrome, reverse the number and check with the original.
	 *
	 * @param n for number to check
	 */
	public static boolean isPalindrome(int n)
	{
		if(n == reverse(n))
			return true;
		else
			return false;
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
}
