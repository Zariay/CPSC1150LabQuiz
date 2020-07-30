/*
 ** Program Name: Lab06
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         June 16th, 2020
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

import java.util.Scanner;
public class Lab06 {
	final static int asciiNum = 10;
	final static int asciiLetter = 26;
	
	public static void main(String args[])
	{
		int cipherKey = 0;
		char[] msg;
		msg = getMsg();
		cipherKey = getKey();
		String ans = "";
		
		for (int i=0; i<msg.length; i++)
		{
			ans += cipher(msg[i],cipherKey);
		}
		System.out.println(ans);
	}
	
	/** Converts ascii values to binary
	 * @param n
	 * @return
	 */
	public static String asciiToBinary(int n)
	{
		String binary = ""; //initialize as blank string
		int binCount = 0, temp; //binary numbers are 8 digits so this allows for each binary representation to be in the form of xxxxxxxx
		while(binCount < 8)
		{
			temp = n % 2;
			binary = temp + binary;
			n /= 2;
			binCount += 1;
		}
		
		return binary;
	}
	
	/**Takes inputted character and determines it's ciphering by the given key if applicable
	 * @param c
	 * @param key
	 * @return cipher
	 */
	public static String cipher(char c, int key)
	{
		String cipher = "";

		if((int) c >= 48 && (int) c <= 57) //if char c's ascii value is in the range of 48-57 for numbers
			return cipher = cipherNum(c,key) + cipher;
		else if ((int) c >= 65 && (int) c <= 90) //if char c's ascii value is in the range of 65-90 for Uppercase letters
			return cipher = cipherUpper(c,key) + cipher;
		else if((int)c >= 97 && (int) c <= 122) //if char c's ascii value is in the range of 97-122 for lowercase letters
			return cipher = cipherLower(c,key) + cipher;
		else
			return cipher = asciiToBinary((int) c) + cipher;
	}
	
	/**Takes the character whose ascii values fall within 48-57, meaning they're numbers on the ascii table
	 * @param c
	 * @param key
	 * @return cipherNum
	 */
	public static String cipherNum(char c, int key)
	{
		int ascii = (int) c;
		String cipherNum = "";
		
		if(ascii + key > 57)
		{
			ascii = ascii - (asciiNum - key);
			return cipherNum = asciiToBinary(ascii) + cipherNum;
		}
		else
		{
			ascii += key;
			return cipherNum = asciiToBinary(ascii) + cipherNum;
		}
	}
	
	/**Takes the character whose ascii values fall within 65-90, meaning they're uppercase letters
	 * @param c
	 * @param key
	 * @return cipherUpper
	 */
	public static String cipherUpper(char c, int key)
	{
		int ascii = (int) c;
		String cipherNum = "";
		
		if(ascii + key > 90)
		{
			ascii = ascii - (asciiLetter - key);
			return cipherNum = asciiToBinary(ascii) + cipherNum;
		}
		else
		{
			ascii += key;
			return cipherNum = asciiToBinary(ascii) + cipherNum;
		}
	}
	
	/**Takes the character whose ascii values fall within 97-122, meaning tey're lowercase latters
	 * @param c
	 * @param key
	 * @return cipherLower
	 */
	public static String cipherLower(char c, int key)
	{
		int ascii = (int) c;
		String cipherNum = "";
		
		if(ascii + key > 122)
		{
			ascii = ascii - (asciiLetter - key);
			return cipherNum = asciiToBinary(ascii) + cipherNum;
		}
		else
		{
			ascii += key;
			return cipherNum = asciiToBinary(ascii) + cipherNum;
		}
	}
	
	/** Read a line of message from keyboard and return it as an array of char
    @return: Array of characters 
   */
	public static char[] getMsg()
	{
		System.out.println("Please provide a message to scramble: ");
		Scanner inputScan = new Scanner(System.in);
		String msg = inputScan.nextLine();
		return msg.toCharArray();
	}
	
	/** Read an integer from keyboard and return it 
    @return: code
   */
	public static int getKey()
	{
		System.out.println("How many spaces would you like the key to be?");
		Scanner inputScan = new Scanner(System.in);
		int key = inputScan.nextInt();
		return key;
	}
}
