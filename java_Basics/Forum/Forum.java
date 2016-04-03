public class Forum {
  private String mTopic;
  
  public String getTopic() {
      return mTopic;
  }
    
  public Forum(String userTopic) {
    mTopic = userTopic;
  }
  
  
  public void addPost(ForumPost post) {
      /* When all is ready uncomment this... */
      System.out.printf("New post from %s %s about %s.\n",
                         post.getAuthor().getFirstName(),
                         post.getAuthor().getLastName(),
                         post.getTitle());
     
  }
}