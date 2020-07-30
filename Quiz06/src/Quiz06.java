/*
 ** Program Name: Quiz06
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         June 16th, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

public class Quiz06{
	public static void main (String[] args){
		int test1 = 36498;
		int test2 = 473;
		int test3 = 81;
		int test4 = 1;
		int test5 = 23424234;
		
		System.out.println("Number of Digits: " + test1 + " is " + numberOfDigits(test1));
		System.out.println("Number of Digits: " + test2 + " is " + numberOfDigits(test2));
		System.out.println("Number of Digits: " + test3 + " is " + numberOfDigits(test3));
		System.out.println("Number of Digits: " + test4 + " is " + numberOfDigits(test4));
		System.out.println("Number of Digits: " + test5 + " is " + numberOfDigits(test5));
		// test cases 
		System.out.println("Test 1:  leftRotate ( "+test1+ " )= "+ leftRotate(test1));
		System.out.println("Test 2:  leftRotate ( "+test2+ " )= "+ leftRotate(test2));
		System.out.println("Test 3:  leftRotate ( "+test3+ " )= "+ leftRotate(test3));
		System.out.println("Test 4:  leftRotate ( "+test4+ " )= "+ leftRotate(test4));
		System.out.println("Test 4:  leftRotate ( "+test5+ " )= "+ leftRotate(test5));
	}

	/** Takes a positive integer number, n, as argument, and returns numer of digits of n*/
	public static int numberOfDigits(int n){

		// your code goes here
      int count = 0, temp;
      while(n > 0)
      {
    	  temp = n % 10;
    	  count += 1;
    	  n /= 10;
      }
     
       return count;
	}
    
	/** use numberOfDigitsI( int n), and right-rotate the given positive integer n, and returns the result. */

	public static int leftRotate(int n){
		

		// your code goes here
		if(numberOfDigits(n) > 1)
		{
			int firstDigit = n / (int) (Math.pow(10, (numberOfDigits(n)-1)));
			n -= firstDigit * (int) (Math.pow(10, (numberOfDigits(n)-1)));
			n *= 10;
			n += firstDigit;
		}
		
		return n;
	}
	    
}    