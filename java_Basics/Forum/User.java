public class User {
  
  private String mFirstName;
  private String mLastName;
  
  public String getFirstName() {
    return mFirstName;
  }
  
  public String getLastName() {
    return mLastName;
  }
 
  public User(String firstName, String lastName) {
    mFirstName = firstName;
    mLastName = lastName;
  }
}