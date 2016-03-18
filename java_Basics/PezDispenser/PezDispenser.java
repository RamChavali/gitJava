public class PezDispenser {
  
  //Vital constant information for a class.
  //Class level variables
  public static final int MAX_PEZ = 12;

  private String mCharacterName;
  private int mPezCount;  

  //Constructor, method to instantiate
  public PezDispenser(String characterName) {
    mCharacterName = characterName;
    mPezCount = 0;
  }
  
  //Incrementing and Decrementing
  public boolean dispense() {
    boolean wasDispensed = false;
    if (!isEmpty()) {
      mPezCount--;
      wasDispensed = true;
    }
    return wasDispensed;
  }
  
  //Just checking is Pez count is zero
  //Helper method to stay DRY
  public boolean isEmpty() {
    return mPezCount == 0;
  }
  
  //When method returns nothing, you say "Void"
  //Default values, 'method signature'
  public void load() {
    load(MAX_PEZ);
  }
  
  //Different signature
  public void load(int pezAmount) {
    int newAmount = mPezCount + pezAmount;
    if (newAmount > MAX_PEZ) {
      throw new IllegalArgumentException("Too many PEZ!!!");
    }
    mPezCount = newAmount;
  }
  
  public String getCharacterName() {
    return mCharacterName;
  }
  
}

/*

Terminology

    constants (Search for constants) - 
    ---------
    Values that never change. It is good practice to store these in a clear variable name instead of placing them directly in your code. There is a naming style for them that is all uppercase letters separated by underscores. Here is a list of all constant values in Java SE 8. (I linked directly to the Integer.MAX_VALUE we discussed.)
    
    
    static - 
    ---------
    The static keyword is used to make the class, or blueprint, have access to specific methods or fields without the need to create an instance. This is very common when making constants that are common for all instances of the class. They allow users of your class to not create an unneeded instance just to get the information. Methods that are created using the static keyword are available at the class level, but cannot access non-static, or instance level variables. This is hard to grasp, until you see it in practice. Integer.parseInt is a good example, we call that right from the class, and we didn't need to create an integer to get to it. We'll circle back to this in upcoming projects and it'll sink in.
    
    final - 
    ---------
    The final keyword when used with a variable declaration makes it so once it is initialized, it can never be changed. Final can be used in different cases and we will see that later when we explore things. When a variable cannot change it is said to be immutable, because you cannot mutate, or change it. Oftentimes static and final are used to create class level constants.
    
    void - 
    ---------
    When defining a method, you need to explain to the caller what is expected to be returned after the method has been called. In some cases, your code will not actually return anything, it will just change the internal state of the object. When this happens, you still need to let the caller know. This is what the void keyword is used for. It can be read as "this method returns nothing".

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++l

REPL Commands

    :load FileName.java - 
    This loads the file and allows you to access it. NOTE If you get an error, try to compile your code, there might be a syntax error.
    
    :cls - Clears the screen.

*/