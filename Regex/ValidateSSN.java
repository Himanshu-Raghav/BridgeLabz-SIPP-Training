public class ValidateSSN {
    public static void main(String[] args) {
        String regex = "^\\d{3}-\\d{2}-\\d{4}$";
        String[] inputs = {"123-45-6789", "123456789"};
        for (String input : inputs) {
            System.out.println(input + ": " + input.matches(regex));
        }
    }
}