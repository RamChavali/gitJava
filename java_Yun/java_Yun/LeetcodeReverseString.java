package java_Yun;

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
	
	public static void main(String[] args) { reverseString("hello"); }
}