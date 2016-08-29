public class PrintArraySumWithConstructor {
	
	private int inputInteger2Check = 0;
	private int[] intArray = null;
	
	public PrintArraySumWithConstructor(int inputInteger2Check, int[] intArray){
		if(intArray == null || intArray.length == 0){
			throw new IllegalArgumentException("intArray");
		}
		this.inputInteger2Check = inputInteger2Check;
		this.intArray = intArray;
	}
	
	public static void printArraySum() {
		int sum = 0;
		
		for (int i=0; i<intArray.length; i++) {
			if(intArray[i] == (int) Double.POSITIVE_INFINITY){
				sum = (int) Double.POSITIVE_INFINITY;
				break;
			}else if(intArray[i] == (int) Double.NEGATIVE_INFINITY){
				sum = (int) Double.NEGATIVE_INFINITY;
				break;
			}
			sum += intArray[i];
		}
		System.out.print("Sum:\t" + sum);;
	}
	
	public boolean arrayContainsInput() {
		boolean arrayContainsInput = false;		
		for (int i=0; i<intArray.length; i++) {
			if (inputInteger2Check==intArray[i]) {
				arrayContainsInput = true;
				//Once you find the element there is no need to continue the for loop.
				break;
			} 
		}
		return arrayContainsInput;
	}	
}

//To Use....
//PrintArraySumWithConstructor printArraySumWithConstructor = new PrintArraySumWithConstructor(10, new int[]{1,2,3,4});
//printArraySumWithConstructor.printArraySum();
//boolean isInputExists = printArraySumWithConstructor.arrayContainsInput();
