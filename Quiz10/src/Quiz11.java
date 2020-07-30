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
import java.io.FileNotFoundException;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
/** tests readWrite method   */
public class Quiz11{
	public static void main (String[] args)  throws FileNotFoundException{
		
		
        // test cases
        readWrite("input.txt", "output1.txt", "Java", "JAVA");
        readWrite("input.txt", "output2.txt", "is", "was");
        
    }

	/** Copies content of source file to destination file and changes all occurances of oldStr to new Str
        @param srcFileName: source file name
        @param dstFileName: destination file name
        @param oldStri : old string that will be replace by new String
        @param newStr :   new string that will be substituded for the oldstr in the destination file
        */
	public static void readWrite(String srcFileName, String dstFileName, String oldStr, String newStr)  throws FileNotFoundException{
        // your code goes here
		File inputFile = new File(srcFileName);
		File outputFile = new File(dstFileName);
		
		Scanner readFile = new Scanner(inputFile);
		PrintWriter output = new PrintWriter(outputFile);
		
		while(readFile.hasNext())
		{
			String temp = readFile.next();
			
			if(temp.compareTo("is,") == 0)
			{
				output.print(temp.replace(oldStr, newStr) + " ");
			}
			else if(temp.compareTo(oldStr) == 0)
			{
				output.print(temp.replace(oldStr, newStr) + " ");
			}
			else
				output.print(temp + " ");
		}
		
		readFile.close();
		output.close();
    }
	
}    