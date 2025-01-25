package com.busreservation;

import com.busreservation.model.Bus;
import com.busreservation.model.Booking;
import com.busreservation.model.User;
import com.busreservation.service.BusService;
import com.busreservation.service.BookingService;
import com.busreservation.service.UserService;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BusService busService = new BusService();
        BookingService bookingService = new BookingService();
        UserService userService = new UserService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("==== Welcome to Bus Reservation System ====");
        System.out.println("Login as:");
        System.out.println("1. Admin");
        System.out.println("2. Passenger");

        int userType = scanner.nextInt();
        scanner.nextLine();

//        switch (userType) {
//            case 1:
//                adminMenu(busService, scanner);
//                break;
//            case 2:
//                passengerMenu(busService, bookingService, userService, scanner);
//                break;
//            default:
//                System.out.println("Invalid choice. Exiting.");
//                break;
//        }
//    }
        switch (userType) {
            case 1:
                System.out.println("Enter Admin ID: ");
                String inputId = scanner.nextLine();
//                scanner.nextLine();
                System.out.println("Enter Admin Password: ");
                String inputPassword = scanner.nextLine();
                if (inputId.equals("admin") && inputPassword.equals("password")) {
                    adminMenu(busService, scanner);
                } else {
                    System.out.println("Invalid ID or password. Exiting.");
                }
                break;
          case 2:
                passengerMenu(busService, bookingService, userService, scanner);
                break;
            default:
                System.out.println("Invalid choice. Exiting.");
                break;
        }

    }

    private static void adminMenu(BusService busService, Scanner scanner) {
        boolean adminRunning = true;
        while (adminRunning) {
            System.out.println("\n==== Admin Menu ====");
            System.out.println("1. Add Bus");
            System.out.println("2. View Buses");
            System.out.println("3. Update Bus");
            System.out.println("4. Delete Bus");
            System.out.println("5. Logout");

            int adminChoice = scanner.nextInt();

            switch (adminChoice) {
                case 1:
                    System.out.println("Enter bus details:");
                    System.out.println("Bus Name:");
                    String busName = scanner.next();
                    System.out.println("Source:");
                    scanner.nextLine();
                    String source = scanner.next();
                    System.out.println("Destination:");
                    String destination = scanner.next();
                    System.out.println("Total Seats:");
                    int totalSeats = scanner.nextInt();
                    System.out.println("Available Seats:");
                    int availableSeats = scanner.nextInt();
                    System.out.println("Departure Date (YYYY-MM-DD):");
                    String departureDate = scanner.next();

                    Bus newBus = new Bus(busName, source, destination, totalSeats, availableSeats, departureDate);
                    busService.addBus(newBus);
                    System.out.println("Bus added successfully.");
                    break;

                case 2:
                    List<Bus> buses = busService.getAllBuses();
                    System.out.println("\nAvailable Buses:");
                    for (Bus bus : buses) {
                        System.out.println(bus);
                    }
                    break;

                case 3:
                    System.out.println("Enter Bus ID to update:");
                    int busId = scanner.nextInt();
                    Bus bus = busService.getBusById(busId);
                    if (bus != null) {
                        System.out.println("Enter new available seats:");
                        int newSeats = scanner.nextInt();
                        bus.setAvailableSeats(newSeats);
                        busService.updateBus(bus);
                        System.out.println("Bus updated successfully.");
                    } else {
                        System.out.println("Bus not found.");
                    }
                    break;

                case 4:
                    System.out.println("Enter Bus ID to delete:");
                    int deleteBusId = scanner.nextInt();
                    busService.deleteBus(deleteBusId);
                    System.out.println("Bus deleted successfully.");
                    break;

                case 5:
                    adminRunning = false;
                    System.out.println("Admin logged out.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private static void passengerMenu(BusService busService, BookingService bookingService, UserService userService, Scanner scanner) {
        boolean passengerRunning = true;
        while (passengerRunning) {
            System.out.println("\n==== Passenger Menu ====");
            System.out.println("1. Search Bus");
            System.out.println("2. Book Bus");
            System.out.println("3. Logout");

            int passengerChoice = scanner.nextInt();

            switch (passengerChoice) {
                case 1:
                    System.out.println("Enter source:");
                    String source = scanner.next();
                    System.out.println("Enter destination:");
                    String destination = scanner.next();
                    System.out.println("Enter departure date (YYYY-MM-DD):");
                    String searchDate = scanner.next();

                    List<Bus> availableBuses = busService.searchBus(source, destination, searchDate);
                    if (availableBuses.isEmpty()) {
                        System.out.println("No buses found.");
                    } else {
                        System.out.println("\nAvailable Buses:");
                        for (Bus bus : availableBuses) {
                            System.out.println(bus);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Enter Bus ID to book:");
                    int busId = scanner.nextInt();
                    Bus bus = busService.getBusById(busId);

                    if (bus != null && bus.getAvailableSeats() > 0) {
                        System.out.println("Enter your name:");
                        String userName = scanner.next();
                        System.out.println("Enter contact number:");
                        String contactNumber = scanner.next();
                        System.out.println("Enter number of seats to book:");
                        int seatsToBook = scanner.nextInt();

                        if (seatsToBook <= bus.getAvailableSeats()) {
                            User user = new User(userName, contactNumber);
                            userService.addUser(user);

                            // Now capture the booking date
                            System.out.println("Enter booking date (YYYY-MM-DD):");
                            String date = scanner.next(); // Initialize date here

                            int bookingId = generateBookingId(); // Generate booking ID
                            Booking booking = new Booking(bookingId, user.getUserId(), bus.getBusId(), seatsToBook, date);
                            bookingService.addBooking(booking);

                            busService.updateSeats(bus.getBusId(), seatsToBook);
                            System.out.println("Booking successful.");
                        } else {
                            System.out.println("Not enough seats available.");
                        }
                    } else {
                        System.out.println("Bus not found or no available seats.");
                    }
                    break;

                case 3:
                    passengerRunning = false;
                    System.out.println("Passenger logged out.");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    break;
            }
        }
    }

    private static int bookingIdCounter = 1;

    private static int generateBookingId() {
        return bookingIdCounter++;
    }

}
