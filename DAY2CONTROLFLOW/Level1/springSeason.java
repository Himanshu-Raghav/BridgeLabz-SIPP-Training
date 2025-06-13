import java.util.Scanner;

public class springSeason {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
	System.out.println("Enter month in number");
        int month = sc.nextInt();
	System.out.println("Enter date in number");
        int date = sc.nextInt();
        if((month>=3 && month<=6)&& (date>=20 && date<=20 )){
	System.out.println("Its a spring season");
	}
        else{
            System.out.println("not a spring season");
        }
    }
}
