
/* Many thanks to Subas S. from Apple!
* */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexSimpleNumGrouping {
    public static void main(String args[]) {

        // String to be scanned to find the pattern.
        String line = "$1.96-$10.00 (151)";

        //(\\d[.]\\d+)-->1.96
        //(\\d+[.]\\d+)-->10.00
        //(\\d+)-->151
        String pattern = "^\\$(\\d[.]\\d+)[-][$](\\d+[.]\\d+)[\\s][(](\\d+)[)]";
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