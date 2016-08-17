package java_Yun;

/**
 * Additional resources:
 * 1) Yun!
 * 2) StringBuilder to String, http://stackoverflow.com/a/16155815
 * 3) reverse string using String Builder, http://www.tutorialspoint.com/java/lang/stringbuilder_reverse.htm
 * 
 * 
 *
 */

public class LeetcodeReverseString {
	
    public static String reverseString(String originalString) {
    	String reversedString = null;
		if (originalString==null || originalString.length()==0) { reversedString = ""; }
		else {
			int sizeOfString = originalString.length();
			char[] charArray = new char[originalString.length()];
			for (int i=0; i<sizeOfString; i++) {
				//This was the killer! IndexOfBoundArgghh
				//System.out.println("Ref:\t"+ i + "\t" + (sizeOfString-i-1));
				charArray[i] = originalString.charAt(sizeOfString-i-1);
			}
			reversedString = new String(charArray);
		}
		System.out.println("reversedString:\t" + reversedString);
    	return reversedString;
    }
    
    
    // refactored version using StringBuilder!
    public static String reverseStringUsingStringBuilder(String originalString) {
    	String reversedString = new StringBuilder(originalString).reverse().toString();
    	System.out.println("reverseStringUsingStringBuilder:\t" + reversedString);
    	return reversedString;
    }
    
    // refactored version using StringBuffer!
    public static String reverseStringUsingStringBuffer(String originalString) {
    	String reversedString = new StringBuffer(originalString).reverse().toString();
    	System.out.println("reverseStringUsingStringBuffer:\t" + reversedString);
    	return reversedString;
    }
    
    
	public static void main(String[] args) { 
		
		// TEST
		reverseString("hello"); 
		reverseStringUsingStringBuilder("hello2");
		reverseStringUsingStringBuffer("hello3");
	}
	
}