
/* Many thanks to Subas S. from Apple!
* */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
    public static void main(String args[]) {

        // String to be scanned to find the pattern.
        String line = "$1.96-$10.00 (151)";

        //(\\d[.]\\d+)-->1.96       //added + to handle 1+ digits
        //(\\d+[.]\\d+)-->10.00
        //(\\d+)-->151
        String pattern = "^\\$(\\d+[.]\\d+)[-][$](\\d+[.]\\d+)[\\s][(](\\d+)[)]";
        System.out.println("\n-------------------------------------------");
        System.out.println("Original string: " + line);
        System.out.println("-------------------------------------------\n");

        // Create a Pattern object
        Pattern r = Pattern.compile(pattern);

        // Now create matcher object.
        Matcher m = r.matcher(line);
        if (m.find()) {
            //start from 1, if you start 0 it gives the whole matching
            System.out.println("Should be [1.96]: " + m.group(1)); // 0.00
            System.out.println("Should be [10.00]: " + m.group(2)); // 10.00
            System.out.println("Should be [151]: " + m.group(3)); // 151
        } else {
            System.out.println("NO MATCH");
        }
    }
}


/*

TODO - add +
^\$(\d[.]\d+)[-][$](\d+[.]\d+)[\s][(](\d+)[)]
-----------------------------------------------

^               :matches beginning of the line
\$              :ESCAPES matching end of the line
(\d[.]\d+)      :\d     :matches digits
                :[.]    :matches any single character except newline
                :\d     :matches digits
                :+      :matches when preceding character occurs 1 or more times
[-]             :matches literal dash character
[$]             :matches literal dollar character
(\d+[.]\d+)     :\d     :matches digits
                :+      :matches when preceding character occurs 1 or more times
                :[.]    :matches any single character except newline
                :\d     :matches digits
                :+      :matches when preceding character occurs 1 or more times
[\s]            :matches whitespace
[(]             :matches literal left parentheses character
(\d+)           :matches when there are 1 or more digits
[)]             :matches literal right parentheses character

 */