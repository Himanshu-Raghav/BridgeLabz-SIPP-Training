package com.classobject;

class Employee{
	 String name;
	 int id;
	 int salary;
	 
	 Employee(String name, int id ,int salary){
		 this.name=name;
		 this.id=id;
		 this.salary=salary;
	 }	 
	 void displayDetails() {
		 System.out.println("Name: " + name + ", id: " + id + ", salary: " + salary);
	 }	
}