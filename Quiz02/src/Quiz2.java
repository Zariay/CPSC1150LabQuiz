/*
 ** Program Name: Quiz2 
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         May 19, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

import java.util.Scanner;

public class Quiz2
{
	public static void main(String[] args){
		int n; 
		Scanner in = new Scanner(System.in);
		System.out.print("Input a positive integer number: ");
		n = in.nextInt();
		// Your code goes here
		//check if n is divisible by both 3 and 7
		if(n%3 == 0 && n%7 == 0)
			System.out.println("n is divisible by both 3 and 7.");
		//only divisible by 3
		else if(n%3 == 0 && !(n%7==0))
			System.out.println("n is divisible only by 3.");
		//only divisible by 7
		else if(!(n%3==0) && n%7==0)
			System.out.println("n is divisible only by 7");
		//divisible by neither
		else
			System.out.println("n is not divisible by either 3 or 7.");
		
		in.close();
	}	
}