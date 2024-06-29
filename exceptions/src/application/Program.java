package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		sc.nextLine();
		
		System.out.print("Check-in date (DD/MM/YYYY): ");
        String checkInStr = sc.nextLine();
        LocalDate checkIn = LocalDate.parse(checkInStr, formatter);
        
        System.out.print("Check-out date (DD/MM/YYYY): ");
        String checkOutStr = sc.nextLine();
        LocalDate checkOut = LocalDate.parse(checkOutStr, formatter);
		
		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			
			System.out.print("Check-in date (DD/MM/YYYY): ");
	        checkInStr = sc.nextLine();
	        checkIn = LocalDate.parse(checkInStr, formatter);
	        
	        System.out.print("Check-out date (DD/MM/YYYY): ");
	        checkOutStr = sc.nextLine();
	        checkOut = LocalDate.parse(checkOutStr, formatter);
	        
	        String error = reservation.updateDates(checkIn, checkOut);
	        
	        if (error != null) {
	        System.out.println("Error in reservation: " + error);
	        }
	        else {
	        	System.out.println("Reservation: " + reservation);
	        }
		}
	        
	        
		
		
       
		
		
		
		sc.close();	

	}

}
