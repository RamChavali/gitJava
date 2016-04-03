public class Example {

  public static void main(String[] args) {
    System.out.println("Starting forum example...");
    if (args.length < 2) {
       System.out.println("first and last name are required. eg:  java Example Craig Dennis");
    }
    Forum forum = new Forum("Java");
    // Take the first two elements passed args
    User author = new User(args[0], args[1]);
    // Add the author, title and description
    ForumPost post = new ForumPost(author, "My favorite so far!", "Cool and challenging.");
    forum.addPost(post);
  }
}