import java.util.Scanner;

public class Comparebothfuncti {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number < 1) {
            System.out.println("Not a natural number");
        } else {
            int sum = 0;
            for (int i = 1; i <= number; i++) {
                sum += i;
            }
            int formula = number * (number + 1) / 2;
            System.out.println("Sum using loop: " + sum);
            System.out.println("Sum using formula: " + formula);
        }
    }
}
