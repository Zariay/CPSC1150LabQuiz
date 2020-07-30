/*
 ** Program Name: Lab09
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         July 8th, 2020
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

import java.util.Scanner;

public class Lab09 {
	
	//pre-determined strings to keep track of the translated words.
	static final String[] unitsDigit = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", 
			"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
	static final String[] tensDigit = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	static final String[] tensPower = {"", "thousand", "million", "billion", "trillion", "quadrillion"};
	
	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		
		long inputNum;
		String translatedNumber = "";
		System.out.println("Please enter a number to translate to its word form: ");
		inputNum = inputScan.nextLong();
		
		translatedNumber = convertNumToWord(inputNum);
		
		System.out.println("The translated number is " + translatedNumber + ".");
		inputScan.close();
	}
	
	/**Converts the number to word as long as they're less than one thousand (3 digits, ie, 0-999)
	 * 
	 * Return result = "zero" immediately if number == 0;
	 * otherwise do the rest of the calculation
	 * @param number
	 * @return
	 */
	public static String numToWordLessThanOneThousand(long number)
	{
		String result = "";
		
		//check if number inputted is equal to zero
		//if it is equal to zero, return result immediately
		if(number == 0)
			return result = "zero";
		
		//otherwise if number is greater than 0 proceed here
		int num = (int) number % 100;
		
		//check if number is less than 20
		//if it is, set result to the correct number
		if(num < 20)
			result = result + unitsDigit[num];
		//otherwise, do the tens digit and ones digit.
		else
			result += tensDigit[num / 10] + " "+ unitsDigit[num % 10];
		
		//if the inputted number is greater than 100, add the number in the hundreds place to the string and add " hundred ".
		if(number >= 100)
			result = unitsDigit[(int) number / 100] + " hundred " + result;
		
		result = result.trim(); //remove any trailing or leading whitespaces that may show up.
		
		return result;
	}
	
	/**Initial function call to start the process of converting a number to it's word form
	 * 
	 * Takes a long number and takes its on a three number basis from right to left.
	 * @param number
	 * @return result
	 */
	public static String convertNumToWord(long number)
	{
		String result = "";
		
		//keep track of the tens power (not including hundred (10 ^ 2)
		int tensPowerIndex = 0;
		
		//do while loop to translate the full number in sets of 3 digits at a time from right to left.
		do
		{
			//grab the last 3 digits
			int num = (int) (number % 1000);
			
			//if the tens power index is greater than 1, add " , and "  to the string.
			if(tensPowerIndex > 0)
				result = ", and " + result;
			
			//create the string for the three digits translated to words
			String str = numToWordLessThanOneThousand(num);
			//add the tens power (thousand, million, etc)
			result = str + " " + tensPower[tensPowerIndex] + result;
			
			//increment tens power index
			tensPowerIndex += 1;
			
			//remove the last three digits that were calculated.
			number = number / 1000;
		}while(number > 0);
		
		result = result.trim(); //remove any trailing or leading whitespaces
		
		return result;
	}
}
