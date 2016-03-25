public class Hangman {
    
    public static void main(String[] args) {
        // Enter amazing code here:
        if (args.length == 0) {
          System.out.println("Please enter a word.");
          System.exit(0);
        }
      
        Game game = new Game(args[0]);
        Prompter prompter = new Prompter(game);
        prompter.play();
    }
}
    
/*
Notes:
Separation of concern looks great.
We have the prompter object dealing with the IO.
And the game logic is completely separated.
We also have the main executable file here that we'll use both of them from.
*/
//Quotes - double for strings and single for chars.
/*
example.indexOf('z');       //char letter = B  
String example = "Hello";   //java.lang.String example = "Hello" 
example.indexOf('e');       //java.lang.Integer res2 = 1
example.indexOf('H');       //java.lang.Integer res3 = 0
example.indexOf('z');       //java.lang.Integer res4 = -1 
example.indexOf('o') >= 0;  //java.lang.Boolean res5 = true
example.indexOf('y') >= 0;  //java.lang.Boolean res6 = false 
*/
