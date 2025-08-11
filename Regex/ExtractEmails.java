import java.util.regex.*;
public class ExtractEmails {
    public static void main(String[] args) {
        String regex = "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[A-Za-z]{2,}";
        String text = "Contact us at support@example.com and info@company.org";
        Matcher m = Pattern.compile(regex).matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}