import java.io.Console;
 
public class TreeStory {
    
    public static void main(String[] args) {
        Console console = System.console();
        /*  Some terms:
            noun - Person, place or thing
            verb - An action
            adjective - A description used to modify or describe a noun
            Enter your amazing code here!
        */
      
      String ageAsString = console.readLine("How old are you?\n");
      int age = Integer.parseInt(ageAsString);
      if (age < 13) {
        //insert exit statement
        console.printf("Sorry, you must be at least 13 to use this program.\n");
        System.exit(0);
      }
      
      //__name__ is a __adjective__ __noun__. They are always __adverb__ __verb__.
      
      String name = console.readLine("Enter name: ");
      String noun;
      boolean isInvalidWord;

      do {
        noun = console.readLine("Enter noun: ");
        isInvalidWord = (noun.equalsIgnoreCase("dork") || noun.equalsIgnoreCase("jerk"));
        if (isInvalidWord) {
          console.printf("\nThat language is not allowed. Try again. \n\n");
        } 
      } while (isInvalidWord);
      
      String verb = console.readLine("Enter verb: ");
      String adjective = console.readLine("Enter adjective: ");
      String adverb = console.readLine("Enter adverb: ");
      
      console.printf("My TreeStory:\n---------\n%s is a %s %s.\nShe is always %s %s. \n", name, adjective, noun, adverb, verb);
      
    }
    
}