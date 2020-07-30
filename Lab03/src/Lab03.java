/*
 ** Program Name: Lab03
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         May 27, 2020 
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */
import java.util.Scanner;

public class Lab03 {
	
	final static double withdraw = 500;
	final static double interestPerMonth = 0.06/12;
	
	public static void main(String[] args)
	{
		double bankBalance;
		Scanner inputScan = new Scanner(System.in);
		
		System.out.println("Please enter your bank balance:");
		bankBalance = inputScan.nextDouble();
		
		int months = 0;
		int years = 0;
		
		//check if the value entered in the bank balance is too large for the program to handle
		while(bankBalance >= 100000)
		{
			System.out.println("This amount in the account would take far too long to deplete!");
			System.out.println("Please enter a new bank balance.");
			bankBalance = inputScan.nextDouble();
		}
			
		//math ceiling check update
		//While the bank balance is above 0, we count how many months it'll take overall to deplete it. 
		//the counter for months gets incremented, the interest rate is applied to the current balance
		//the amount to withdraw is then withdrawn at the end of the function. 
		while(bankBalance >= 0 && bankBalance <= 100000)
		{
			months += 1;
			bankBalance *= (1 + interestPerMonth);
			bankBalance -= withdraw;
		}
		
		//if it'll only take months to deplete the account go here
		if(months < 12)
		{
			String monthMessage = "";
			monthMessage = months + " month";
			if(months > 1)
				monthMessage = monthMessage + "s";
			
			System.out.println("It'll take " + monthMessage + " to empty out the account.");
		}
		//otherwise go here to calculate how many years AND months
		else 
		{
			years = months / 12;
			months = months % 12;
			
			String yearsMessage = "";
			yearsMessage = years + " year";
			if(years > 1) 
				yearsMessage = yearsMessage + "s";
			
			String monthMessage = "";
			monthMessage = months + " month";
			if(months > 1)
				monthMessage = monthMessage + "s";
			
			if(months == 0)
				System.out.println("It'll take " + yearsMessage + " to empty out the account.");
			else 
				System.out.println("It'll take " + yearsMessage + " and " + monthMessage +" to empty out the account.");
		}
		
		inputScan.close();
	}
}
