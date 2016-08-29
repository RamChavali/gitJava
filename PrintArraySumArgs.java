import java.util.Scanner;

public class PrintArraySumArgs {
	
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
				//Once you find the element there is no need to continue the for loop.
				break;
			} 
		}
		System.out.println("arrayContainsInput:\t" + arrayContainsInput);
	}
	
	public static void main(String[] args) {
		//Math.pow takes doubles as arguments..
		//if you do not want to use the hard coded int array and assuming passed arguments are integers
		//int[] hardcodedIntArray = { -1, (int) Math.pow(2.0, 2.0), 3, 44};
		if(args == null){
			throw new NullPointerException("args is null");
		}
		int[] hardcodedIntArray = new int[]{args.length};
		int index = 0;
		for(String arg : args){
			hardcodedIntArray[index] = Integer.parseInt(arg);
		}
		printArraySum(hardcodedIntArray);
		arrayContainsInput(hardcodedIntArray);
	}
	
}
