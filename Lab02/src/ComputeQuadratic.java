/*
 ** Program Name: Quiz2 
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         May 20, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

/*
 *  This program calculates the quadratic formula ax^2 + bx + c = 0 where a and b are not 0
 *  This determines the value or values of x for the formula, assuming it exists.  
 *  Variables a, b and c are first taken in by user input, and determined first to be valid inputs.
 *  
 *  Once determined to be valid inputs, the program calculates the discriminant of the equation to determine the number of solutions.
 */

import java.util.Scanner;

public class ComputeQuadratic {
	public static void main(String[] args)
	{
		int a, b, c;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program is used to calculate the quadratic formula");
		System.out.println("Please enter the value for a: ");
		a = input.nextInt();
		
		System.out.println("Please enter the value for b: ");
		b = input.nextInt();
		
		System.out.println("Please enter the value for c: ");
		c = input.nextInt();
		
		//check whether or not both a and b are both 0's
		if(a == 0 && b == 0)
			System.out.println("Sorry, these are not valid inputs as a and b both cannot be 0.");
		
		//check if only a is 0, then the program is a linear equation
		else if(a == 0 && !(b == 0))
		{
			System.out.println("This is a linear equation, not a quadratic equation.");
			double x;
			x =  ((double)c/b) * -1;
			
			System.out.println("The value of x is: " + x);
		}
		
		//both a and b are not 0, and therefore it's a quadratic formula
		else
		{
			double discriminant;
			double x1, x2;
			discriminant = (Math.pow(b, 2)) - (4 * a * c);
			
			// The discriminant of the quadratic formula is described as b^2 - 4ac, and it's result determines the number of solutions
			if(discriminant < 0)
				System.out.println("There are no real roots possible.");
			else if(discriminant == 0)
			{
				System.out.println("This equation has double roots, meaning both x1 and x2 are the same.");
				x1 = (double) (((-1 * b) + Math.sqrt(discriminant)) / (2*a));
				System.out.println("The value of x is " + x1);
			}
			else
			{
				System.out.println("This quadradic equation has 2 real roots.");
				x1 = (double) (((-1 * b) + Math.sqrt(discriminant)) / (2*a));
				x2 = (double) (((-1 * b) - Math.sqrt(discriminant)) / (2*a));
				
				System.out.println("The roots are x1: " + x1 + ", and x2: " + x2);
			}
		}
		
		input.close();
	}
}
