package java_Hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * https://www.hackerrank.com/domains/java/java-introduction
 *
 */

public class HackerrankIntro {
	
	static String[] untilOptionalArgsFiguredOut = {"until", "optional", "args", "figured", "out"};
	
	public static String[] intro01_justPrintString(String[] stringList) {
		String[] suppliedList = {"Hello, World.", "Hello, Java."};
		String[] thisList = (stringList.length < 1)? suppliedList : stringList;
		for (String s: thisList) { System.out.println( "string:\t" + s ); }
		return thisList;
	}
	
	public static int[] intro02_stdinStdout1() {
		Scanner scan = new Scanner(System.in);
		System.out.println("\nNumber if integers to scan:");
		int numToScan = scan.nextInt();
		int[] scannedInts = new int[numToScan];
	
		for (int i=0; i<numToScan; i++) {
			System.out.println("enter num #" + (i+1) + ":");
			scannedInts[i] = scan.nextInt(); 
		}
		
		for (int n: scannedInts) { System.out.println("scanned:" + n); }
		return scannedInts;
	}
	
	public static String intro03_ifElse() {
		/**
		 * If n is odd, print Weird
		 * If n is even and in the inclusive range of 2 to 5, print Not Weird
		 * If n is even and in the inclusive range of 6 to 20, print Weird
		 * If n is even and greater than 20, print Not Weird
		 */
		String weirdOrNot = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("\nNumber to be evaluated for weirdness:");
		int num = sc.nextInt();
		if (!(num % 2 == 0) || (num > 5 && num < 21)) { 
			weirdOrNot = "Weird"; 
		} 
		else { weirdOrNot = "Weird"; }
		System.out.println("Number " + num + " is " + weirdOrNot);
		return weirdOrNot;		
	}
	
	public static void intro04_stdinStdout2() {
		// TODO - why is nextLine() required? why not continue with nextInt(), nextDouble()?
		/**
		 * On the first line, print String: followed by the unaltered String read from stdin.
		 * On the second line, print Double: followed by the unaltered double read from stdin.
		 * On the third line, print Int: followed by the unaltered integer read from stdin.
		 */
		Scanner sc = new Scanner(System.in);
		
		//TODO - how to either specify or determine later data type? .class()? .instanceOf()?
		//List<Object> sections = new ArrayList <Object>();
		Map<String, String> scannedData = new HashMap<String, String>();
		
		
		System.out.println("Input #1, integer:");
		int i = Integer.parseInt(sc.nextLine());
		scannedData.put("Int", String.valueOf(i));
		System.out.println("Input #2, double:");
		double d = Double.parseDouble(sc.nextLine());
		scannedData.put("Double", String.valueOf(d));
		System.out.println("Input #3, string:");
		String s = sc.nextLine();
		scannedData.put("String", s);
		
		for (String x: scannedData.keySet()) {
			System.out.println(x + ": " + scannedData.get(x));
		}
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TEST  
		//intro01_justPrintString(untilOptionalArgsFiguredOut);
		//intro02_stdinStdout1();
		//intro03_ifElse();
		intro04_stdinStdout2();
	}

}
