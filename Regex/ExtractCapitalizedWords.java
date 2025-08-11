import java.util.regex.*;
public class ExtractCapitalizedWords {
    public static void main(String[] args) {
        String regex = "\\b[A-Z][a-z]*\\b";
        String text = "The Eiffel Tower is in Paris and the Statue of Liberty is in New York.";
        Matcher m = Pattern.compile(regex).matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}