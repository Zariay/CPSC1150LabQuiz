/*
 ** Program Name: Quiz12
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         July 28th, 2020
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */
public class Quiz12 {
	public static void main(String[] args)
	{
		System.out.println(myRecursion(5));
		System.out.println(myRecursion(10));
		System.out.println(myRecursion(20));
		
	}
	
	public static double myRecursion(int n)
	{
		if(n == 0)
			return n;
		
		return ((1/(double) n) + myRecursion(n-1));
	}
}
