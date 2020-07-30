/*
 ** Program Name: Lab04
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         June 03, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */
import java.util.Scanner;

public class Lab04 {
	//EPSILON value used to check if points are in a line
	final static double EPSILON = 0.00001; // very small number
	
	public static void main(String args[])
	{
		Scanner inputScan = new Scanner(System.in);
		int aX, aY, bX, bY, cX, cY;
		int runLoop = 1;
		
		while(runLoop == 1)
		{
			//first ask user to input all the coordinates for the points, then check whether or not they are valid inputs.
			System.out.println("Please enter a value for Point A's x-coordinate: ");
			aX = inputScan.nextInt();
			
			System.out.println("Please enter a value for Point A's y-coordinate: ");
			aY = inputScan.nextInt();
			
			System.out.println("Please enter a value for Point B's x-coordinate: ");
			bX = inputScan.nextInt();
			
			System.out.println("Please enter a value for Point B's y-coordinate: ");
			bY = inputScan.nextInt();
			
			System.out.println("Please enter a value for Point C's x-coordinate: ");
			cX = inputScan.nextInt();
			
			System.out.println("Please enter a value for Point C's y-coordinate: ");
			cY = inputScan.nextInt();
			
			//check if the inputs are valid
			if(!verify_input(aX,aY))
				System.out.println("Coordinate (" + aX + "," + aY + ") is not in the accepted range.");
			if(!verify_input(bX,bY))
				System.out.println("Coordinate (" + bX + "," + bY + ") is not in the accepted range.");
			if(!verify_input(cX,cY))
				System.out.println("Coordinate (" + cX + "," + cY + ") is not in the accepted range.");
			
			//if some or all are invalid, ask the user if they want to try again if there is even a single invalid input
			if(!verify_input(aX,aY) || !verify_input(bX,bY) || !verify_input(cX,cY))
			{
				System.out.println("One of the inputs is invalid. Would you like to try again? Press 1 for yes and 2 for no.");
				runLoop = inputScan.nextInt();
			}
			//first double check if the inputed values are on a line
			else if(isLine(aX, aY, bX, bY, cX, cY))
			{
				if(aX == bX && bX == cX)
				{
					System.out.println("This is a vertical line! Would you like to try again? Press 1 for yes and 2 for no.");
					runLoop = inputScan.nextInt();
				}
				else 
				{
					System.out.println("This is a horizontal line! Would you like to try again? Press 1 for yes and 2 for no.");
					runLoop = inputScan.nextInt();
				}
					
			}
			//calculate the perimeter and area of the triangle, as well as
			//the coordinates of the points
			else
			{
				System.out.println("Triangle: A(" + aX + "," + aY + "), B(" + bX + "," + bY + "), C(" + cX + "," + cY + ")");
				System.out.println("Perimeter = " + perimeter(aX, aY, bX, bY, cX, cY));
				System.out.println("Area = " + area(aX, aY, bX, bY, cX, cY));
				
				//once the program is done, prompt the user if they want to do another
				System.out.println("Would you like to do another? Press 1 for yes and 2 for no.");
				runLoop = inputScan.nextInt();
			}
		}
		inputScan.close();
	}
	
	/**Takes coordinates of (x,y) and returns true, if they are positive, and they are in range [0 – 40], otherwise it returns false
	* @param x for x coordinate
	* @param y for y coordinate
	* @return boolean result
	*/
	public static boolean verify_input (int x, int y)
	{
		boolean input;
		
		if(x < 0 || x > 40 || y < 0 || y > 40)
			input = false;
		else 
			input = true;
			
		return input;
	}
	
	/**Takes coordinates of two points (x1,y1), (x2,y2), then calculates and returns their distance
	 * 
	 * The distance is calculated taking the square root of (x2-x1)^2 + y2-y1)^2
	 * 
	 * @param x1 for x coordinate of first point
	 * @param y1 for y coordinate of first point
	 * @param x2 for x coordinate of second point
	 * @param y2 for y coordinate of second point
	 * @return double distance.
	 */
	public static double distance (int x1, int y1, int x2, int y2)
	{
		double dist;
		
		dist = Math.sqrt(Math.pow((x2-x1), 2)+Math.pow((y2-y1), 2));
		
		return dist;
	}
	
	/**Takes the three coordinates of the triangle, (xA, yA), (xB, yB), (xC, yC), and returns its perimeter
	 * 
	 * Takes the distance of the three different lines (AB, AC, and BC) and adds them together 
	 * 
	 * @param xA for x coordinate of first point
	 * @param yA for y coordinate of first point
	 * @param xB for x coordinate of second point
	 * @param yB for y coordinate of second point
	 * @param xC for x coordinate of third point
	 * @param yC for y coordinate of third point
	 * @return double perimeter
	 */
	public static double perimeter (int xA, int yA, int xB, int yB, int xC, int yC)
	{
		double peri;
		
		peri = distance(xA, yA, xB, yB) + distance(xB, yB, xC, yC) + distance(xA, yA, xC, yC);
		
		return peri;
	}
	
	/**Takes the three coordinates of the triangle, (xA, yA), (xB, yB), (xC, yC), and returns its area
	 * 
	 * Using Heron's Formula to find the area of a triangle
	 * s (or semi-perimeter) is 1/2(a+b+c)
	 * therefore the area is sqrt(s(s-a)(s-b)(s-c))
	 * 
	 * @param xA for x coordinate of first point
	 * @param yA for y coordinate of first point
	 * @param xB for x coordinate of second point
	 * @param yB for y coordinate of second point
	 * @param xC for x coordinate of third point
	 * @param yC for y coordinate of third point
	 * @return double area
	 */
	public static double area (int xA, int yA, int xB, int yB, int xC, int yC)
	{
		double area;
		
		double s = perimeter(xA, yA, xB, yB, xC, yC) / 2;
		
		area = Math.sqrt(s*(s-distance(xA, yA, xB, yB))*(s-distance(xB, yB, xC, yC))*(s-distance(xA, yA, xC, yC)));
		
		return area;
	} 
	
	/**Takes the three coordinates of the triangle, (xA, yA), (xB, yB), (xC, yC), and returns true if they are located on a single line, otherwise it returns false
	 * 
	 * The area of a triangle can be calculated using determinants with the formula 1/2 |(x2y3 - x3y2) - (x1y3 - x3y1) + (x1y2 - x2y1)|
	 * |(x2y3 - x3y2) - (x1y3 - x3y1) + (x1y2 - x2y1)| is the discriminant of the formula
	 * We will form a 3x3 matrix using these points with the last column being ones and calculate the formula based on that.
	 * xA  yA  1
	 * xB  yB  1
	 * xC  yC  1
	 * 
	 * This results in
	 * (xByC - xCyB) - (xAyC - xCyA) + (xAyB - xByA)
	 * We take the absolute value of this discriminant and if it is less than the Epsilon value determined (or basically equal to zero)
	 * then it is a line. Otherwise, if it is greater than 0 it is a triangle.
	 * 
	 * @param xA for x coordinate of first point
	 * @param yA for y coordinate of first point
	 * @param xB for x coordinate of second point
	 * @param yB for y coordinate of second point
	 * @param xC for x coordinate of third point
	 * @param yC for y coordinate of third point
	 * @return boolean
	 */
	public static boolean isLine (int xA, int yA, int xB, int yB, int xC, int yC)
	{
		boolean line;
		
		if(Math.abs((xB*yC-xC*yB) - (xA*yC-xC*yA) + (xA*yB-xB*yA)) <= EPSILON)
			line = true;
		else
			line = false;
		
		return line;
	} 
}
