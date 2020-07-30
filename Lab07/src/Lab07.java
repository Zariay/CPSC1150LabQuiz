/*
 ** Program Name: Lab07
 ** Author:       Alexander Fan
 ** Id:           100229106 
 ** Date:         June 24th, 2020
 ** Course:       CPSC 1150 
 ** Compiler:     JDK 14 
 ** IDE:          Eclipse
 * 
 */

public class Lab07 {
	public static void main(String args[])
	{
		int[] arr = initialize(7, 2, 10);
		System.out.println("Test Case 1: ");
		printArray(arr);
		reverse(arr);
		printArray(arr);
		sort(arr);
		printArray(arr);
		count(arr);
		
		if(insert(arr, 3, 3))
			printArray(arr);
		else
			System.out.println("Cannot insert!");
		
		if(insert(arr, 7, 7))
			printArray(arr);
		else
			System.out.println("Cannot insert!");
		
		System.out.println("");
		int[] arr1 = initialize(50, -343, 400);
		System.out.println("Test Case 2: ");
		printArray(arr1);
		reverse(arr1);
		if(insert(arr, 3, 3))
			printArray(arr);
		else
			System.out.println("Cannot insert!");
		
		if(insert(arr, 7, 7))
			printArray(arr);
		else
			System.out.println("Cannot insert!");
		printArray(arr1);
		sort(arr1);
		printArray(arr1);
		count(arr1);
		
		System.out.println("");
		int[] arr2 = initialize(30, 56, 120);
		System.out.println("Test Case 3: ");
		printArray(arr2);
		reverse(arr2);
		printArray(arr2);
		sort(arr2);
		printArray(arr2);
		count(arr2);
		
		System.out.println("");
		int[] arr3 = initialize(30, -120, -1);
		System.out.println("Test Case 4: ");
		printArray(arr3);
		reverse(arr3);
		if(insert(arr, 3, 23))
			printArray(arr);
		else
			System.out.println("Cannot insert!");
		
		if(insert(arr, 7, 31))
			printArray(arr);
		else
			System.out.println("Cannot insert!");
		printArray(arr3);
		sort(arr3);
		printArray(arr3);
		count(arr3);
	}
	
	/**Creates the initial array and fills it with numbers within a given range. 
	 * @param size
	 * @param lowerBound
	 * @param upperBound
	 * @return
	 */
	public static int[] initialize(int size, int lowerBound, int upperBound)
	{
		int[] arr = new int[size];
		for(int i = 0; i < size; i++)
		{
			arr[i] = (int) (Math.random() * ((upperBound - lowerBound) + 1)) + lowerBound; 
		}
		
		return arr;
	}
	
	/** Prints the array
	 * @param arr
	 */
	public static void printArray(int[] arr)
	{
		for(int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("");
	}
	
	/** Reverses each element in the array by swapping positions.
	 * @param arr
	 */
	public static void reverse(int[] arr)
	{
		int temp;
		for(int i = 0; i < (arr.length * 0.5); i++)
		{
			temp = arr[i];
			arr[i] = arr[arr.length - i -1];
			arr[arr.length-i-1] = temp;
		}
	}
	
	/** Sorts the array using Sequential Sort
	 * @param arr
	 */
	public static void sort(int[] arr)
	{
		int temp;
		
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[i] > arr[j])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
	}
	
	/**Keeps count of all the numbers in the array and how often they occur. 
	 * @param arr
	 */
	public static void count(int[] arr)
	{
		int count, currentNumber;
		
		for(int i = 0; i < arr.length; i++)
		{
			currentNumber = arr[i];
			count = 0;
			for(int j = 0; j < arr.length; j++)
			{
				if(currentNumber == arr[j])
					count += 1;
			}
			
			if(i == 0)
			{
				System.out.println(currentNumber + " occurs " + count + " times.");
				continue;
			}
			else if(arr[i-1] == arr[i])
				continue;
			else
				System.out.println(currentNumber + " occurs " + count + " times.");
		}
	}
	
	/**Attempts to insert a new value in the array and moves the rest after it to the right. 
	 * Removes the last element.
	 * @param arr
	 * @param n
	 * @param index
	 * @return true if able to place the number into the correct index
	 * return false if the index given is greater than the length of the array
	 */
	public static boolean insert(int[] arr, int n, int index)
	{
		if(index >= arr.length)
		{
			return false;
		}
		else
		{
			for(int i = arr.length-2; i >= index ; i--)
			{
				arr[i+1] = arr[i];
			}
			arr[index] = n;
			return true;
		}
	}
}
