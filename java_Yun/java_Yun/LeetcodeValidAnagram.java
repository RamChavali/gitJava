package java_Yun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 242. Valid Anagram, https://leetcode.com/problems/valid-anagram/
 * "Given two strings s and t, write a function to determine if t is an anagram of s."
 * "For example, s = "anagram", t = "nagaram", return true. s = "rat", t = "car", return false."
 * "Note: You may assume the string contains only lowercase alphabets."
 * "Follow up: What if the inputs contain unicode characters? How would you adapt your solution to such case?"
 * 
 * Additional References:
 * count distinct chars in char array, http://stackoverflow.com/a/22597587
 * edit hashmap value using key, http://stackoverflow.com/a/4158002
 * count occurrence of each character in string, http://javaconceptoftheday.com/how-to-count-occurrences-of-each-character-in-string-in-java/
 */

public class LeetcodeValidAnagram {

	public static boolean isAnagram(String s, String t) {
		boolean isAnagram = false;
		
		Map<Character, Integer> sMap = new HashMap<>();
		Map<Character, Integer> tMap = new HashMap<>();
		s.chars().distinct().forEach(x -> sMap.put((char) x, 0));
		t.chars().distinct().forEach(y -> tMap.put((char) y, 0));
		
		if (sMap.keySet().equals(tMap.keySet())) { // else go directly to return isAnagram=false
			
			// Question - is there really no easier way to count of char someChar in char array?!
			for (char x: s.toCharArray()) { if (sMap.containsKey(x)) { sMap.put(x, sMap.get(x)+1); } }
			for (char y: t.toCharArray()) { if (tMap.containsKey(y)) { tMap.put(y, tMap.get(y)+1); } } 
			if (sMap.equals(tMap)) { isAnagram = true; } // // else return isAnagram=false
		}
		
		System.out.println(isAnagram + ":\t\"" + t + "\" is an anagram of \"" + s + "\"");
		return isAnagram;
	}
	
	public static void main(String[] args) {
		// TEST - checking here before submitting Leetcode.
		isAnagram("anagram", "nagaram");
		isAnagram("rat", "car");
		isAnagram("", "");
		isAnagram("!", "!");
		isAnagram("anagram!", "anagram");
	}

}
