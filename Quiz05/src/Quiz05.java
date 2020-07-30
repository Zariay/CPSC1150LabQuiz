/*
 ** Program Name: Quiz05
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         June 09, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */
public class Quiz05 {
	public static void main (String[] args)
	{
		double x = 1.89;
		double sinX=0;
		int n = 23;
		
		//sinX = Math.pow(x, 1)/factorial(1);
		for(int i = 0; i < n; i+=1)
		{
			if(i%2 == 1)
				sinX -= (Math.pow(x, (2*i + 1)))/factorial((2*i+1));
			else 
				sinX += (Math.pow(x, (2*i + 1)))/factorial((2*i+1));
		}

		//using Math.sin() to double check correct values.
		System.out.println("SinX using Math.sin(x) = " + Math.sin(x));
		System.out.println("SinX = " + sinX);
	}

	/** calculates and returns n! 
	@param n : a positive integer number
	@return n!
	*/
	public static double factorial(int n)
	{
		double newValue = 1.0;
		
		if(n == 0)
			return newValue;
		else
		{
			for(int i = 1; i <= n; i+=1)
			{
				newValue *= i;
			}
			return newValue;
		}
	}
}
