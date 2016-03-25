public class Game {
  public static final int MAX_MISSES = 7;
  private String mAnswer;
  private String mHits;
  private String mMisses;
  
  //Constructor
  public Game(String answer) {
    mAnswer = answer;
    mHits = "";
    mMisses = "";
  }
  
  private char validateGuess(char letter) {
    if (! Character.isLetter(letter)) {
      throw new IllegalArgumentException("A letter is required.");
    }
    letter = Character.toLowerCase(letter);
    if (mMisses.indexOf(letter) >=0 || mHits.indexOf(letter) >= 0) {
      throw new IllegalArgumentException(letter + " has already been guessed.");
    }
    return letter;
  }
  
  public boolean applyGuess(String letters) {
    if (letters.length() == 0) {
      throw new IllegalArgumentException("No letter found");
    }
    return applyGuess(letters.charAt(0));
  }
  
  public boolean applyGuess(char letter) {
    letter = validateGuess(letter);
    boolean isHit = mAnswer.indexOf(letter) >= 0;
    if (isHit) {
      mHits += letter;
    } else {
      mMisses += letter;
    }
    return isHit; 
  }
  
public String getCurrentProgress() {
  String progress = "";
  for (char letter: mAnswer.toCharArray()) {
    char display = '-';
    if (mHits.indexOf(letter) >= 0) {
      display = letter;
    }
    progress += display;
  }
  return progress;
}

  public int getRemainingTries() {
    return MAX_MISSES - mMisses.length();
  }
  
  public String getAnswer() {
    return mAnswer;
  }
  
  public boolean isSolved() {
    return getCurrentProgress().indexOf('-') == -1;
  }
  
  
}
  
/*
Game game = Game@167c021b
:load Game.java                     //Loaded source file from Game.java
Game game = new Game("treehouse");  //Game game = Game@eaf6fff
game.applyGuess('t');               //java.lang.Boolean res1 = true
game.applyGuess('z');               //java.lang.Boolean res2 = false
*/
/*
java-repl
String example = "hello";         //java.lang.String example = "hello"  
example.toCharArray();            //char[] res1 = [h, e, l, l, o] 
for (char letter : example.toCharArray()) { 
  System.out.println("We have the letter " + letter); 
  }  
//We have the letter h                                               
//We have the letter e                                               
//We have the letter l                                               
//We have the letter l                                               
//We have the letter o
*/



