/*
 ** Program Name: Quiz09
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         July 7th, 2020
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

public class Quiz09 {
	public static void main(String[] args)
	{
		String stringCount = "This is a test.";
		System.out.println("The letter t occurs " + countSymbol(stringCount, 't') + " times in the string: " + stringCount);
		
		String stringSum = "CPSC 1150 sec 2.";
		System.out.println("The sum of the digits in the string " + stringSum + " is " + sumOfDigits(stringSum) + ".");
		
		String[] stringArr = {"This is a test", "This is another one", "is this a quiz?"};
		System.out.println("The letter i occurs " + countSymbol(stringArr, 'i') + " times.");
	}
	
	//Part A
	public static int countSymbol(String str, char x)
	{
		int count = 0;
		
		for(int i = 0; i < str.length(); i++) 
		{
			if(str.charAt(i) == x)
				count += 1;
		}
		
		return count;
	}
	
	//Part B
	public static int sumOfDigits(String str)
	{
		int sum = 0;
		
		for(int i = 0; i < str.length(); i++)
		{
			if((int) (str.charAt(i) - '0') >= 0 && (int) (str.charAt(i) - '0') <= 9)
			{
				sum += (int) (str.charAt(i) - '0');
			}
		}
		
		return sum;
	}
	
	//Part C
	public static int countSymbol(String[] arr, char x)
	{
		int count = 0;
		
		for(int i = 0; i < arr.length; i++)
		{
			count += countSymbol(arr[i], x);
		}
		
		return count;
	}
}
