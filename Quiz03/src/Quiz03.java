/*
 ** Program Name: Quiz3 
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         May 27, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */
public class Quiz03{
	public static void main(String[] args){
		int n=50;
		double x = 10;
		double y=0, z=0;
		
		// your code 
		for(int i = 1; i <= n; ++i)
		{
			y += i/(i+1.0);
			z += (x+i)/(Math.pow(x, i));
		}

		System.out.println("y = "+y);
		System.out.println("z = "+z);
	}
}