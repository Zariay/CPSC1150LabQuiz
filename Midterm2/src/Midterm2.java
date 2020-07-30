
public class Midterm2 {
	public static void main(String args[])
	{
		String password = "Xx_&9x2Yc";
		
		if(validate(password))
			System.out.println("It works!");
		else
			System.out.println("It doesn't work.");
	}
	
	public static boolean validate(String password)
	{
		if(password.length() < 8)
			return false;
		
		int upperCaseCount = 0;
		int numberCount = 0;
		
		for(int i = 0; i < password.length(); i++)
		{
			if(validateUppercase(password.charAt(i)))
				upperCaseCount += 1;
			
			if(validateNumber(password.charAt(i)))
				numberCount += 1;
		}
		
		if(upperCaseCount == 1 && numberCount == 2)
			return true;
		else
			return false;
	}
	
	public static boolean validateUppercase(char letter)
	{
		if((int) letter >= 65 && (int) letter <= 90)
			return true;
		else
			return false;
	}
	
	public static boolean validateNumber(char number)
	{
		if((int) number >= 48 && (int) number <= 57)
			return true;
		else 
			return false;
	}
	
	public static int remove(int[] arr, int n)
	{
		int count = 0;
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == n)
			{
				count += 1;
				for(int j = i; j < arr.length; j++)
					arr[j] = arr[j + 1];
			}
		}
		int remove = 1;
		while(remove < count)
		{
			arr[arr.length-remove] = -1;
			remove += 1;
		}
		
		return count;
	}
	
	public static double myParseDouble(String str)
	{
		double myDouble = 0.0;
		
		for(int i = 0; i < str.length(); i++)
		{
			myDouble = (int) (str.charAt(i) - '0') + myDouble;
		}
		
		return myDouble;
	}
}
