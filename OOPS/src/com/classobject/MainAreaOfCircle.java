package com.classobject;
import java.util.Scanner;
public class MainAreaOfCircle {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		double radius=sc.nextDouble();
		AreaOfCircle area=new AreaOfCircle(radius);
		double result=area.Area(radius);
		System.out.println(result);
	}



}
