package Day2;

import java.util.Scanner;

public class MultiTaskProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

      
        System.out.println("Enter two numbers (floating point) for calculator:");
        double number1 = sc.nextDouble();
        double number2 = sc.nextDouble();

        double add = number1 + number2;
        double sub = number1 - number2;
        double mul = number1 * number2;
        double div = number1 / number2;

        System.out.println("The addition, subtraction, multiplication, and division value of 2 numbers "
                + number1 + " and " + number2 + " is " + add + ", " + sub + ", " + mul + ", and " + div);

        
        System.out.println("\nEnter base and height in cm:");
        double base = sc.nextDouble();
        double height = sc.nextDouble();

        double areaCm = 0.5 * base * height;
        double areaInch = areaCm / (2.54 * 2.54);

        System.out.println("The Area of the triangle in sq in is " + areaInch + " and sq cm is " + areaCm);

      
        System.out.println("\nEnter the perimeter of the square:");
        double perimeter = sc.nextDouble();
        double side = perimeter / 4;

        System.out.println("The length of the side is " + side + " whose perimeter is " + perimeter);

    
        System.out.println("\nEnter distance in feet:");
        double distanceFeet = sc.nextDouble();

        double distanceYards = distanceFeet / 3.0;
        double distanceMiles = distanceYards / 1760.0;

        System.out.println("The distance in yards is " + distanceYards + " while the distance in miles is " + distanceMiles);

        System.out.println("\nEnter unit price and quantity:");
        double unitPrice = sc.nextDouble();
        int quantity = sc.nextInt();

        double totalPrice = unitPrice * quantity;
        System.out.println("The total purchase price is INR " + totalPrice + " if the quantity " + quantity + " and unit price is INR " + unitPrice);

        System.out.println("\nEnter two numbers to find quotient and remainder:");
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();

        int quotient = num1 / num2;
        int remainder = num1 % num2;

        System.out.println("The Quotient is " + quotient + " and Remainder is " + remainder + " of two number " + num1 + " and " + num2);

   
        System.out.println("\nEnter three integers a, b, c:");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int result1 = a + b * c;
        int result2 = a * b + c;
        int result3 = c + a / b;
        int result4 = a % b + c;

        System.out.println("The results of Int Operations are " + result1 + ", " + result2 + ", " + result3 + ", and " + result4);

       
        System.out.println("\nEnter three double values a, b, c:");
        double da = sc.nextDouble();
        double db = sc.nextDouble();
        double dc = sc.nextDouble();

        double dres1 = da + db * dc;
        double dres2 = da * db + dc;
        double dres3 = dc + da / db;
        double dres4 = da % db + dc;

        System.out.println("The results of Double Operations are " + dres1 + ", " + dres2 + ", " + dres3 + ", and " + dres4);

        sc.close();
    }
}
