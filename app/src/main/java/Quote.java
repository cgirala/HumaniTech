import java.util.ArrayList;

/**
 * Created by Micah on 4/2/2016.
 */
public class Quote {

    private String author;
    private String message;
    private ArrayList<String> authors;
    private ArrayList<String> messages;

    public Quote(String author, String message) {
        this.author = author;
        this.message = message;
    }

    public String toString() {
        return "\"" + message + "\"" + "\n" + "- " + author;
    }
}
