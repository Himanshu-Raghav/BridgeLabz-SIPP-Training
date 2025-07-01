package object_modeling_package;

import java.util.*;


//Patient class
class Patient {
 String name;
 List<Doctor> doctors = new ArrayList<>();

 Patient(String name) {
     this.name = name;
 }

 // Add doctor to patient list
 public void addDoctor(Doctor d) {
     if (!doctors.contains(d)) {
         doctors.add(d);
         d.addPatient(this); 
     }
 }

 // Show all doctors consulted
 public void showDoctors() {
     System.out.println("Patient " + name + " has consulted:");
     for (Doctor d : doctors)
         System.out.println("- Dr. " + d.name);
 }
}

//Doctor class
class Doctor {
 String name;
 List<Patient> patients = new ArrayList<>();

 Doctor(String name) {
     this.name = name;
 }

 // Add patient to doctor list
 public void addPatient(Patient p) {
     if (!patients.contains(p)) {
         patients.add(p);
         p.addDoctor(this);
     }
 }

 // Communication method
 public void consult(Patient p) {
     addPatient(p); // ensure association
     System.out.println("Dr. " + name + " is consulting patient " + p.name);
 }

 // Show all patients
 public void showPatients() {
     System.out.println("Dr. " + name + " has consulted:");
     for (Patient p : patients)
         System.out.println("- " + p.name);
 }
}

//Hospital class
class Hospital {
 String name;
 List<Doctor> doctors = new ArrayList<>();
 List<Patient> patients = new ArrayList<>();

 Hospital(String name) {
     this.name = name;
 }

 public void addDoctor(Doctor d) {
     doctors.add(d);
 }

 public void addPatient(Patient p) {
     patients.add(p);
 }

 public void showAll() {
     System.out.println("Hospital: " + name);
     System.out.println("Doctors:");
     for (Doctor d : doctors)
         System.out.println("- Dr. " + d.name);

     System.out.println("Patients:");
     for (Patient p : patients)
         System.out.println("- " + p.name);
 }
}

//Main Method
public class HospitalManagement {
 public static void main(String[] args) {
     Hospital hospital = new Hospital("City Hospital");

     Doctor d1 = new Doctor("Sharma");
     Doctor d2 = new Doctor("Verma");

     Patient p1 = new Patient("Amit");
     Patient p2 = new Patient("Neha");

     hospital.addDoctor(d1);
     hospital.addDoctor(d2);
     hospital.addPatient(p1);
     hospital.addPatient(p2);

     d1.consult(p1);
     d1.consult(p2);
     d2.consult(p1);

     System.out.println();
     d1.showPatients();
     d2.showPatients();
     System.out.println();
     p1.showDoctors();
     p2.showDoctors();
     System.out.println();
     hospital.showAll();
 }
}

