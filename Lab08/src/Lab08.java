/*
 ** Program Name: Lab08
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         July 2nd, 2020
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

import java.util.Scanner;
public class Lab08 {
	
	public static void main(String args[])
	{
		Scanner inputScan = new Scanner(System.in);
		String firstNum = "", secondNum = "";
		
		System.out.println("Please enter the first number: ");
		firstNum = inputScan.nextLine();
		
		System.out.println("Please enter the second number: ");
		secondNum = inputScan.nextLine();
		
		String finalSum = sum(firstNum, secondNum);
		finalSum = addComma(finalSum);
		
		System.out.println("Final sum = " + finalSum);
		
		inputScan.close();
	}
	
	/**Calculates the sum of the numbers between two strings
	 * @param str1
	 * @param str2
	 * @return sumStr
	 */
	public static String sum(String str1, String str2)
	{
		//check lengths for the strings and change 
		if(str1.length() > str2.length())
		{
			String temp = str1;
			str1 = str2;
			str2 = temp;
		}
		
		str1 = reverse(str1);
		str2 = reverse(str2);
		
		int carry = 0;
		
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		char[] finalCh = new char[ch1.length + ch2.length];
		
		for(int i = 0; i < ch1.length; i++)
		{
			int sum = (int)(ch1[i] - '0') + (int)(ch2[i] - '0') + carry;
			finalCh[i] = (char)(sum % 10 + '0');
			carry = sum/10;
		}
		
		for(int i = ch1.length; i < ch2.length; i++)
		{
			int sum = (int)(ch2[i] - '0') + carry;
			finalCh[i] = (char)(sum % 10 + '0');
			carry = sum/10;
		}
		
		String sumStr = String.copyValueOf(finalCh);
		sumStr = sumStr.trim();
		if(carry > 0)
			sumStr += (char)(carry + '0');
		sumStr = reverse(sumStr);
		return sumStr;
	}
	
	/**Reverses the contents of the string
	 * @param str
	 * @return rev
	 */
	public static String reverse(String str)
	{
		String rev = "";
		
		for(int i = 0; i < str.length(); i++)
			rev = str.charAt(i) + rev;
		
		return rev;
	}
	
	/**Adds commas where appropriate in the string to make reading large numbers easier6
	 * @param str
	 * @return result String with commas
	 */
	public static String addComma(String str)
	{
		String result = "";
		for(int i = 1; i <= str.length(); i++)
		{
			char ch = str.charAt(str.length() - i);
			if(i % 3 == 1 && i > 1)
				result = "," + result;
			result = ch + result;
		}
		
		return result;
	}
}
