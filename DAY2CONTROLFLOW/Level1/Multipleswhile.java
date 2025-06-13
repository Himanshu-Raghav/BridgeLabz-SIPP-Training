import java.util.Scanner;

public class Multipleswhile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if (number > 0 && number < 100) {
            int counter = number - 1;
            while (counter > 1) {
                if (100 % counter == 0) {
                    System.out.println(counter);
                }
                counter--;
            }
        } else {
            System.out.println("Invalid input. Number must be > 0 and < 100");
        }
    }
}
