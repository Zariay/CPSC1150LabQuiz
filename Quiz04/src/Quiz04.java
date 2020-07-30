/*
 ** Program Name: Quiz04 
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         June 02, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */
public class Quiz04 {
	public static void main (String[] args){
		   int n = 99;
		   double y=0;
		   
//		   for(int i = 3; i <= n; i += 2)
//		   {
//			   y += (i-2.0)/i;
//		   }
//		   
//		   while(n >= 3)
//		   {
//			   System.out.println("N = " + n + " and y = " + y);
//			   y -= (n-2.0)/n;
//			   n -= 2;
//		   }
		   for(int i = n; i >= 3; i -= 2)
		   {
			  for(int j = 3; j <= i; j += 2)
			  {
				  y += (j-2.0)/j;
			  }
			  System.out.println("N = " + i + " and y = " + y);
			  y = 0;
		   }
	}
}
