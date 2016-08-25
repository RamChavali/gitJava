package java_Kanika;

import java.util.Scanner;

public class PrintArraySum {
	
	public static void printArraySum(int[] intArray) {
		int sum = 0;
		for (int i=0; i<intArray.length; i++) {
			sum += intArray[i];
		}
		System.out.print("Sum:\t" + sum);;
	}
	
	public static void arrayContainsInput(int[] intArray) {
		boolean arrayContainsInput = false;
		System.out.println("\nEnter integer input:");
		Scanner scan = new Scanner(System.in);
		int intInput = scan.nextInt();
		for (int i=0; i<intArray.length; i++) {
			if (intInput==intArray[i]) {
				arrayContainsInput = true;
			} 
		}
		System.out.println("arrayContainsInput:\t" + arrayContainsInput);
	}
	
	public static void main(String[] args) {
		int[] hardcodedIntArray = { -1, (int) Math.pow(2, 2), 3, 44};
		printArraySum(hardcodedIntArray);
		arrayContainsInput(hardcodedIntArray);
	}
	
}
