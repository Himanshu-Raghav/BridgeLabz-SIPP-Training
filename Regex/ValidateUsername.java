import java.util.regex.*;
public class ValidateUsername {
    public static void main(String[] args) {
        String regex = "^[A-Za-z][A-Za-z0-9_]{4,14}$";
        String[] inputs = {"user_123", "123user", "us"};
        for (String input : inputs) {
            System.out.println(input + ": " + input.matches(regex));
        }
    }
}