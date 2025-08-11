public class ValidateCreditCard {
    public static void main(String[] args) {
        String visaRegex = "^4\\d{15}$";
        String mcRegex = "^5\\d{15}$";
        String[] inputs = {"4123456789012345", "5123456789012345", "6123456789012345"};
        for (String input : inputs) {
            System.out.println(input + ": Visa=" + input.matches(visaRegex) + ", MasterCard=" + input.matches(mcRegex));
        }
    }
}