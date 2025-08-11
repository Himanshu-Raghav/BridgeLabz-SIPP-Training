import java.util.regex.*;
public class ExtractLanguages {
    public static void main(String[] args) {
        String regex = "\\b(Java|Python|JavaScript|Go)\\b";
        String text = "I love Java, Python, and JavaScript, but I haven't tried Go yet.";
        Matcher m = Pattern.compile(regex).matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}