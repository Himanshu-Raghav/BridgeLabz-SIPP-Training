import java.util.regex.*;
public class ValidateHexColor {
    public static void main(String[] args) {
        String regex = "^#[0-9A-Fa-f]{6}$";
        String[] inputs = {"#FFA500", "#ff4500", "#123"};
        for (String input : inputs) {
            System.out.println(input + ": " + input.matches(regex));
        }
    }
}