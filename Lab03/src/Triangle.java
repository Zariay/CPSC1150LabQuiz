/*
 ** Program Name: Triangle
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         May 27, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

import java.util.Scanner;

public class Triangle {
	public static void main(String[] args)
	{
		int triangleSize = 0;
				
		Scanner scanInput = new Scanner(System.in);	
		System.out.println("Please enter a value between 1 and 9 for the size of the Triangle.");
		triangleSize = scanInput.nextInt();
		
		for(int i = 1; i <= triangleSize; ++i)
		{
			for(int j = 1; j <= i; ++j)
			{
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
		scanInput.close();
	}
}
