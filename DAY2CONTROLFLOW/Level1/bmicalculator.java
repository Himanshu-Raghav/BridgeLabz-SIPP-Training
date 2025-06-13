import java.util.Scanner;

public class bmicalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double weight = input.nextDouble(); 
        double height = input.nextDouble(); 
        height = height / 100.0; 
        double bmi = weight / (height * height);

        System.out.println("BMI: " + bmi);

        if (bmi <=18.4) {
            System.out.println("Underweight");
        } else if (bmi >=18.5 && bmi <= 24.9) {
            System.out.println("Normal");
        } else if (bmi >=25.0 && bmi <= 39.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}