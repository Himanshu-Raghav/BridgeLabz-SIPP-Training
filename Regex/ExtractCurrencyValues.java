import java.util.regex.*;
public class ExtractCurrencyValues {
    public static void main(String[] args) {
        String regex = "\\$?\\d+(\\.\\d{2})?";
        String text = "The price is $45.99, and the discount is 10.50.";
        Matcher m = Pattern.compile(regex).matcher(text);
        while (m.find()) {
            System.out.println(m.group());
        }
    }
}