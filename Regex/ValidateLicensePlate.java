import java.util.regex.*;
public class ValidateLicensePlate {
    public static void main(String[] args) {
        String regex = "^[A-Z]{2}\\d{4}$";
        String[] inputs = {"AB1234", "A12345"};
        for (String input : inputs) {
            System.out.println(input + ": " + input.matches(regex));
        }
    }
}