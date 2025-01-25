package com.busreservation.service;

import java.util.Scanner;

public class PaymentService {

    public boolean processPayment(int amount) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Total amount: $" + amount);
        System.out.println("Enter payment details to proceed.");

        // Simulating payment details (card info, etc.)
        System.out.println("Enter card number:");
        String cardNumber = scanner.nextLine();
        System.out.println("Enter CVV:");
        String cvv = scanner.nextLine();
        System.out.println("Enter expiration date (MM/YY):");
        String expirationDate = scanner.nextLine();

        // Here, you would normally integrate with a real payment gateway.
        // We'll assume payment is always successful for this simulation.
        System.out.println("Processing payment...");
        System.out.println("Payment successful!");

        return true;
    }
}