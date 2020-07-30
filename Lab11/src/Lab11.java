/*
 ** Program Name: Lab11
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         July 22th, 2020
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

import java.util.*;
import java.io.*;

public class Lab11 {
	public static void main(String[] args) throws FileNotFoundException
	{
		File telephoneNumbersFile = new File("telephone.txt");
		if(!telephoneNumbersFile.exists())
		{
			System.out.println("File not found.");
			return;
		}
		
		Scanner countNumberScan = new Scanner(telephoneNumbersFile);
		int telephoneNumberCount = countWordsInFileWithLength(countNumberScan, 7);
		countNumberScan.close();
		
		String[] telephoneNumbersArray = new String[telephoneNumberCount];
		
		Scanner fillTelephoneNumberArrayScan = new Scanner(telephoneNumbersFile);
		telephoneNumbersArray = fillArrayFromFileWithLength(fillTelephoneNumberArrayScan, telephoneNumberCount, 7);
		fillTelephoneNumberArrayScan.close();
		
		File wordFile = new File("word_list.txt");
		if(!telephoneNumbersFile.exists())
		{
			System.out.println("File not found.");
			return;
		}
		
		Scanner sevenLetterWordScan = new Scanner(wordFile);
		int sevenLetterWordCount = countWordsInFileWithLength(sevenLetterWordScan, 7);
		sevenLetterWordScan.close();
		
		String[] sevenLetterWordArray = new String[sevenLetterWordCount];
		
		Scanner fillSevenLetterWordArrayScan = new Scanner(wordFile);
		sevenLetterWordArray = fillArrayFromFileWithLength(fillSevenLetterWordArrayScan, sevenLetterWordCount, 7);
		fillSevenLetterWordArrayScan.close();
		
		Scanner threeLetterWordScan = new Scanner(wordFile);
		int threeLetterWordCount = countWordsInFileWithLength(threeLetterWordScan, 3);
		threeLetterWordScan.close();
		
		String[] threeLetterWordArray = new String[threeLetterWordCount];
		
		Scanner fillThreeLetterWordArrayScan = new Scanner(wordFile);
		threeLetterWordArray = fillArrayFromFileWithLength(fillThreeLetterWordArrayScan, threeLetterWordCount, 3);
		fillThreeLetterWordArrayScan.close();
		
		Scanner fourLetterWordScan = new Scanner(wordFile);
		int fourLetterWordCount = countWordsInFileWithLength(fourLetterWordScan, 4);
		fourLetterWordScan.close();
		
		String[] fourLetterWordArray = new String[fourLetterWordCount];
		
		Scanner fillfourLetterWordArrayScan = new Scanner(wordFile);
		fourLetterWordArray = fillArrayFromFileWithLength(fillfourLetterWordArrayScan, fourLetterWordCount, 4);
		fillfourLetterWordArrayScan.close();
		
		saveMatchingTranslatedWordsToFile(telephoneNumbersArray, sevenLetterWordArray, threeLetterWordArray, fourLetterWordArray);
	}
	
	/**Parse the input file to find words with specific lengths
	 * @param input
	 * @param lengthOfWord
	 * @return count
	 * @throws FileNotFoundException
	 */
	public static int countWordsInFileWithLength(Scanner input, int lengthOfWord) throws FileNotFoundException
	{
		int count = 0;
		
		while(input.hasNext())
		{
			String temp = input.next();
			if(temp.length() == lengthOfWord && isValidWord(temp))
				count+=1;
		}
		
		return count;
	}
	
	/**Fill an array of strings with words from the input file with a specific length
	 * @param input
	 * @param size
	 * @param lengthOfWord
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String[] fillArrayFromFileWithLength(Scanner input, int size, int lengthOfWord) throws FileNotFoundException
	{
		String[] buildArray = new String[size];
		int index = 0;
		while(input.hasNext())
		{
			String temp = input.next();
			if(temp.length() == lengthOfWord && isValidWord(temp))
			{
				buildArray[index] = temp;
				index += 1;
			}
		}
		return buildArray;
	}

	/**Check whether or not the character is a valid character, as phone numbers translated to words cannot have punctuation characters such as an apostrophe or hyphen
	 * @param letter
	 * @return true/false
	 */
	public static boolean isValidCharacter(char letter)
	{
		if(letter >= 'A' && letter <= 'Z' || letter >= 'a' && letter <= 'z' || letter >= '0' && letter <= '9')
			return true;
		else
			return false;
	}
	
	/**Check if the word that is translated or is to be translated and compared to is valid
	 * @param str
	 * @return true/false
	 */
	public static boolean isValidWord(String str)
	{
		if(str.length() == 1 && isValidCharacter(str.charAt(0)))
			return true;
		else
		{
			for(int i = 0; i < str.length(); i++)
			{
				if(!isValidCharacter(str.charAt(i)))
					return false;
			}
		}
		return true;
	}
	
	/**Translate the characters of each word in word_list or sampleword to a number
	 * @param c
	 * @return value
	 */
	public static String getNum(char c)
	{
		String value = "";
		switch(c)
		{
		case 'A': case 'B': case 'C': case 'a': case 'b': case 'c':
			value += 2;
			break;
		case 'D': case 'E': case 'F': case 'd': case 'e': case 'f':
			value += 3;
			break;
		case 'G': case 'H': case 'I': case 'g': case 'h': case 'i':
			value += 4;
			break;
		case 'J': case 'K': case 'L': case 'j': case 'k': case 'l':
			value += 5;
			break;
		case 'M': case 'N': case 'O': case 'm': case 'n': case 'o':
			value += 6;
			break;
		case 'P': case 'Q': case 'R': case 'S': case 'p': case 'q': case 'r': case 's':
			value += 7;
			break;
		case 'T': case 'U': case 'V': case 't': case 'u': case 'v':
			value += 8;
			break;
		case 'W': case 'X': case 'Y': case 'Z': case 'w': case 'x': case 'y': case 'z':
			value += 9;
			break;
		}
		return value;
	}
	
	/**Function that calls the getNum function, and completely translates the word to it's numerical form matching a phone number.
	 * @param str
	 * @return translated
	 */
	public static String translateWordToNum(String str)
	{
		String translated = "";
		
		for(int i = 0; i < str.length(); i++) 
		{
			translated += getNum(str.charAt(i));
		}
		
		return translated;
	}
	
	/**Checks all the found words, matches them up with their word/number combinations and saves them to result.txt
	 * @param matchSource
	 * @param sevenLetterArray
	 * @param threeWordArray
	 * @param fourWordArray
	 * @throws FileNotFoundException
	 */
	public static void saveMatchingTranslatedWordsToFile(String[] matchSource, String[] sevenLetterArray, String[] threeWordArray, String[] fourWordArray) throws FileNotFoundException
	{
		File outputFile = new File("result.txt");
		PrintWriter output = new PrintWriter(outputFile);
		
		for(int i = 0; i < matchSource.length; i++)
		{
			output.println("Tel: " + matchSource[i]);
			for(int j = 0; j < sevenLetterArray.length; j++)
			{
				String translatedString = translateWordToNum(sevenLetterArray[j]);
				if(matchSource[i].compareTo(translatedString) == 0)
					output.println(matchSource[i] + ": " + sevenLetterArray[j]);
			}
			
			String threeNum = matchSource[i].substring(0,3);
			
			for(int j= 0; j < threeWordArray.length; j++)
			{
				if(threeNum.compareTo(translateWordToNum(threeWordArray[j])) == 0)
					output.println(threeNum + ": " + threeWordArray[j]);
			}
			
			String fourNum = matchSource[i].substring(3,7);
			
			for(int j= 0; j < fourWordArray.length; j++)
			{
				if(fourNum.compareTo(translateWordToNum(fourWordArray[j])) == 0)
					output.println(fourNum + ": " + fourWordArray[j]);
			}
			
			output.println("-------");
		}
		
		output.close();
	}
}
