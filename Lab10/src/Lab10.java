/*
 ** Program Name: Lab10
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         July 18th, 2020
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

import java.util.*;
import java.io.*;

public class Lab10 {
	public static void main (String[] args) throws FileNotFoundException
	{
		String inputFile = "";
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Please enter the file to search.");
		inputFile = inputScan.nextLine();
		inputScan.close();
		
		File myInputFile = new File(inputFile);
		if(!myInputFile.exists())
		{
			System.out.println("File not found.");
			return;
		}
		
		//count words in file.
		Scanner readFile = new Scanner(myInputFile);
		int wordCount = countWordsInFile(readFile);
		System.out.println(wordCount + " words in the text file.");
		readFile.close();
		
		//create string array for file.
		Scanner fillArray = new Scanner(myInputFile);
		String[] wordArray = new String[wordCount];
		wordArray = fillArrayFromFile(fillArray, wordCount);
		System.out.println("All words in the text file.");
		printFile(wordArray);
		
		//count letter occurances
		System.out.println("Counting all letter occurances.");
		countLetter(wordArray);
		
		//place all words in array to lower case
		System.out.println("Making all words lower case.");
		wordArray = toLower(wordArray);
		printFile(wordArray);
		
		System.out.println("Removing non-letter characters in the front and back of the words.");
		//clean array of words with non letter chars in front and back
		wordArray = removeFrontBackNonLetterChars(wordArray);
		printFile(wordArray);
		
		System.out.println("Removing words that contain other symbols.");
		//remove all words that contain non letter chars
		wordArray = removeWordsWithNonLetterCharsInside(wordArray);
		printFile(wordArray);
		
		//sort array
		sortArray(wordArray);
		printFile(wordArray);
		
		saveUniqueToFile(wordArray);
	}
	
	/**Count all the words in the file to use for string array creation
	 * @param input
	 * @return count
	 * @throws FileNotFoundException
	 */
	public static int countWordsInFile(Scanner input) throws FileNotFoundException
	{
		int count = 0;
		
		while(input.hasNext())
		{
			input.next();
			count+=1;
		}
		
		return count;
	}
	
	/**Fill the string array with the words from the file
	 * @param input
	 * @param size
	 * @return buildArray
	 * @throws FileNotFoundException
	 */
	public static String[] fillArrayFromFile(Scanner input, int size) throws FileNotFoundException
	{
		String[] buildArray = new String[size];
		int index = 0;
		while(input.hasNext())
		{
			buildArray[index] = input.next();
			index += 1;
		}
		return buildArray;
	}
	
	/**Convert each element in the string array to lowercase using the toLowerCase() function 
	 * @param strArr
	 * @return tempArray
	 */
	public static String[] toLower(String[] strArr)
	{
		String[] tempArray = new String[strArr.length];
		for(int i = 0; i < strArr.length; i++)
		{
			tempArray[i] = strArr[i].toLowerCase();
		}
		return tempArray;
	}
	
	/**Simply print out the contents of the array
	 * @param strArr
	 */
	public static void printFile(String[] strArr)
	{
		for(int i = 0; i < strArr.length; i++)
		{
			System.out.print(strArr[i] + " ");
		}
		System.out.println("");
	}
	
	/**Count all occurances of each letter
	 * @param strArr
	 */
	public static void countLetter(String[] strArr)
	{
		char[] alphabetArray = {'a', 'b', 'c', 'd', 'e', 'f' ,'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
		int count = 0;
		int charCount = 0;
		
		while(charCount != alphabetArray.length)
		{
			for(int i = 0; i < strArr.length; i++)
			{
				for(int j = 0; j < strArr[i].length(); j++) 
				{
					if(alphabetArray[charCount] == strArr[i].charAt(j))
						count+=1;
				}
			}
			System.out.println(alphabetArray[charCount] + " occurs " + count + " times.");
			charCount += 1;
		}
	}
	
	/**Remove non-Letter characters at the front and back of each string, if they exists
	 * @param strArr
	 * @return tempArr
	 */
	public static String[] removeFrontBackNonLetterChars(String[] strArr)
	{
		String[] tempArr = new String[strArr.length];
		
		for(int i = 0; i < strArr.length; i++)
		{
			if(strArr[i].length() == 1 && !isValidLetter(strArr[i].charAt(0))) //if only one character long and is not a letter.
				tempArr[i] = "";
			else if(!isValidLetter(strArr[i].charAt(0)) && !isValidLetter(strArr[i].charAt(strArr[i].length()-1))) //if both front and back of string have non-letter characters
				tempArr[i] = strArr[i].substring(1, strArr[i].length()-1);
			else if(isValidLetter(strArr[i].charAt(0)) && !isValidLetter(strArr[i].charAt(strArr[i].length()-1))) //if only back of string is a non-letter character
				tempArr[i] = strArr[i].substring(0, strArr[i].length()-1);
			else if(!isValidLetter(strArr[i].charAt(0)) && isValidLetter(strArr[i].charAt(strArr[i].length()-1))) //if only front of string is non-letter character
				tempArr[i] = strArr[i].substring(1);
			else
				tempArr[i] = strArr[i];
		}
		
		return tempArr;
	}
	
	/**Remove all words that contain non-letter Characters except for those with a hyphen
	 * @param strArr
	 * @return strArr
	 */
	public static String[] removeWordsWithNonLetterCharsInside(String[] strArr)
	{
		//int removedCount = 0;
		for(int i = 0; i < strArr.length; i++)
		{
			if(!isValidWord(strArr[i]))
			{
				for(int j = i; j < strArr.length-1; j++)
					strArr[j] = strArr[j+1];
			//	removedCount += 1;
			}
		}
//		
//		String[] tempArr = new String[strArr.length - removedCount];
//		
//		for(int i = 0; i < tempArr.length; i++)
//		{
//			tempArr[i] = strArr[i];
//		}
//		
//		return tempArr;
		
		return strArr;
	}
	
	/**Check if the character is valid
	 * @param letter
	 * @return true/false
	 */
	public static boolean isValidLetter(char letter)
	{
		if(letter >= 'A' && letter <= 'Z' || letter >= 'a' && letter <= 'z')
			return true;
		else
			return false;
	}
	
	/**Check if the character is a hyphen
	 * @param letter
	 * @return true/false
	 */
	public static boolean isHyphen(char letter)
	{
		if(letter == '-')
			return true;
		else
			return false;
	}
	
	/**Check if the entire string is a valid word
	 * @param str
	 * @return true/false
	 */
	public static boolean isValidWord(String str)
	{
		if(str.length() == 1 && isValidLetter(str.charAt(0)))
			return true;
		else
		{
			for(int i = 0; i < str.length(); i++)
			{
				if(!(isValidLetter(str.charAt(i)) || isHyphen(str.charAt(i))))
					return false;
			}
		}
		return true;
	}
	
	/**Sort the array alphabetically
	 * @param strArr
	 */
	public static void sortArray(String[] strArr)
	{
		for(int i = 0; i < strArr.length; i++)
		{
			for(int j = i + 1; j < strArr.length; j++)
			{
				if(strArr[i].compareTo(strArr[j]) > 0)
				{
					String temp = strArr[i];
					strArr[i] = strArr[j];
					strArr[j] = temp;
				}
			}
		}
	}
	
	/**Save all unique words to a file.
	 * @param strArr
	 * @throws FileNotFoundException
	 */
	public static void saveUniqueToFile(String[] strArr)throws FileNotFoundException
	{
		File outputFile = new File("output.txt");
		if(outputFile.exists())
		{
			System.out.println("File already exists! Please remove the old one for creation.");
			return;
		}
		
		PrintWriter output = new PrintWriter(outputFile);
		
		for(int i = 0; i < strArr.length; i++)
		{
			if(i == 0)
			{
				output.println(strArr[i]);
				continue;
			}
			else if(strArr[i - 1].compareTo(strArr[i]) == 0)
				continue;
			else
				output.println(strArr[i]);
		}
		
		output.close();
	}
}
