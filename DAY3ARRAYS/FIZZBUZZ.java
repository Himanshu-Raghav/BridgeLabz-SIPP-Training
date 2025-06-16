import java.util.*;
public class FIZZBUZZ{
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		int number=input.nextInt();
		String [] arr=new String[number+1];
		if(number>0){
		   for(int i=0;i<=number;i++){
		        if(i%3==0 && i%5==0){
		            arr[i]="FIZZBUZZ"; 
		        }else if(i%3==0){
		            arr[i]="FIZZ";
		        }else if(i%5==0){
		            arr[i]="BUZZ";
		        }else{
		            arr[i]=String.valueOf(i);
		        }
		    }
		}
		for(int i=0;i<=number;i++){
		    System.out.println(arr[i]);
		}
	}
}
