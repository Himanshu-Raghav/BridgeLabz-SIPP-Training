package com.classobject;

public class AreaOfCircle {
	double radius;
	AreaOfCircle(double radius){
		this.radius=radius;
	}
	double Area(double radius) {
		double area=3.14*radius*radius;
		return area;
	}
	
}
