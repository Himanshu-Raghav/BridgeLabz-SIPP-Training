public class ValidateIPv4 {
    public static void main(String[] args) {
        String regex = "^((25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)\\.){3}(25[0-5]|2[0-4]\\d|1\\d{2}|[1-9]?\\d)$";
        String[] inputs = {"192.168.0.1", "256.100.50.0"};
        for (String input : inputs) {
            System.out.println(input + ": " + input.matches(regex));
        }
    }
}