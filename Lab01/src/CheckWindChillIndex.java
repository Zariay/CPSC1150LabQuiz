/*
 ** Program Name: CheckWindChillIndex	 
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         May 13, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 *
 ** Purpose: Calculate the wind chill index to determine how cold it is outside. 
 *
 */

import java.util.Scanner;

public class CheckWindChillIndex {

	public static void main(String[] args)
	{
		Scanner inputScan = new Scanner(System.in);
		int windSpeed, temperature;
		
		System.out.println("What is the wind speed in km/h?");
		windSpeed = inputScan.nextInt();
		
		while(windSpeed > 100 || windSpeed < 0)
		{
			System.out.println("Sorry! I can only calculate wind speeds between 0km/h and 100km/h. Please enter the value again.");
			windSpeed = inputScan.nextInt();
		}
		
		System.out.println("What is the temperature in Celsius?");
		temperature = inputScan.nextInt();
		
		while(temperature > 5 || temperature < -50)
		{
			System.out.println("Sorry! I can only calculate temperatures between -50 C and 5 C. Please enter the value again.");
			temperature = inputScan.nextInt();
		}
		
		inputScan.close();
		
		System.out.println("This program calculates the Wind Chill Index");
		System.out.println("The wind speed you entered is: " + windSpeed + "km/h");
		System.out.println("The temperature you entered is: " + temperature + "C");
		System.out.println("The wind chill index is: " + CalculateWindChillIndex(windSpeed, temperature));
		
	}

	//Function to call that calculates the Wind-Chill Index
	public static double CalculateWindChillIndex(int windSpeed, int temperature)
	{
		double WCIndex = 0;
		
		WCIndex = 13.112 + (0.6215 * temperature) - (11.37 * Math.pow(windSpeed, 0.16)) + (0.3965 * temperature * Math.pow(windSpeed, 0.16));
		
		return WCIndex;
	}
}
