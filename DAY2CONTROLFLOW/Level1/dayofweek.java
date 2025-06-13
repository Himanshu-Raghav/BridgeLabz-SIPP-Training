import java.util.Scanner;

public class dayofweek {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int d = input.nextInt();
        int y = input.nextInt();

        int y0 = y - (14 - m) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = m + 12 * ((14 - m) / 12) - 2;
        int d0 = (d + x + 31 * m0 / 12) % 7;

        System.out.println("Day of week, 0 for Sunday, 1 for Monday and so on: " + d0);
    }
}