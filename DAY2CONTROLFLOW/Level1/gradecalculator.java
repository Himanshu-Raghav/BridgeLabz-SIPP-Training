import java.util.Scanner;

public class gradecalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int physics = input.nextInt();
        int chemistry = input.nextInt();
        int maths = input.nextInt();

        double average = (physics + chemistry + maths) / 3.0;

        if (average >= 80) {
            System.out.println("Average Mark: " +average +", Grade A,Level 4,above agency normalized standars");
        } else if (average >= 70 && average <=79) {
            System.out.println("Average Mark: " +average +", Grade B,Level 3, at agency normalized standards");
        } else if (average >= 60 && average <=69) {
            System.out.println("Average Mark: " +average +", Grade C,Level 2,below, but approaching agency normalized standards");
        } else if (average >= 50 && average <=59) {
            System.out.println("Average Mark: " +average +", Grade D,Level1,well below agency-normalized standards");
        }  else if (average >= 50 && average <=59) {
            System.out.println("Average Mark: " +average +", Grade E,Level1,too well below agency-normalized standards");
        } else {
            System.out.println("Average Mark: " +average +", Grade F,Remedial standards");
        }
    }
}
