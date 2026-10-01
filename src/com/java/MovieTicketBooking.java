package com.java;

import java.util.Scanner;

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        boolean[][] seats = new boolean[5][5];

        int choice;

        do {
            System.out.println("\n===== MOVIE TICKET BOOKING SYSTEM =====");
            System.out.println("1. Show Available Seats");
            System.out.println("2. Book Ticket");
            System.out.println("3. Cancel Ticket");
            System.out.println("4. Apply Discount Coupon");
            System.out.println("5. Weekend Pricing");
            System.out.println("6. Movie Rating");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

            case 1:
                System.out.println("\nAvailable Seats:");

                for (int i = 0; i < seats.length; i++) {
                    for (int j = 0; j < seats[i].length; j++) {

                        int seatNumber = i * 5 + j + 1;

                        if (seats[i][j] == false) {
                            System.out.print("[" + seatNumber + "] ");
                        } else {
                            System.out.print("[X] ");
                        }
                    }
                    System.out.println();
                }
                break;

            case 2:
                System.out.print("\nEnter seat number to book: ");
                int seatNumber = sc.nextInt();

                if (seatNumber >= 1 && seatNumber <= 25) {

                    int row = (seatNumber - 1) / 5;
                    int column = (seatNumber - 1) % 5;

                    if (seats[row][column] == false) {

                        seats[row][column] = true;

                        double ticketPrice = 200;

                        System.out.println("Ticket booked successfully!");
                        System.out.println("Seat Number: " + seatNumber);
                        System.out.println("Ticket Price: ₹" + ticketPrice);

                    } else {
                        System.out.println("Seat is already booked!");
                    }

                } else {
                    System.out.println("Invalid seat number!");
                }
                break;

            case 3:
                System.out.print("\nEnter seat number to cancel: ");
                int cancelSeat = sc.nextInt();

                if (cancelSeat >= 1 && cancelSeat <= 25) {

                    int row = (cancelSeat - 1) / 5;
                    int column = (cancelSeat - 1) % 5;

                    if (seats[row][column] == true) {

                        seats[row][column] = false;

                        System.out.println("Ticket cancelled successfully!");

                    } else {
                        System.out.println("Seat is not booked!");
                    }

                } else {
                    System.out.println("Invalid seat number!");
                }
                break;

            case 4:
                double ticketPrice = 200;

                System.out.print("\nEnter coupon code: ");
                String coupon = sc.next();

                if (coupon.equals("MOVIE10")) {

                    double discount = ticketPrice * 10 / 100;
                    double finalPrice = ticketPrice - discount;

                    System.out.println("10% discount applied!");
                    System.out.println("Final ticket price: ₹" + finalPrice);

                } else {
                    System.out.println("Invalid coupon!");
                    System.out.println("Ticket price: ₹" + ticketPrice);
                }
                break;

            case 5:
                System.out.println("\nSelect Day Type:");
                System.out.println("1. Weekday");
                System.out.println("2. Weekend");

                System.out.print("Enter your choice: ");
                int dayChoice = sc.nextInt();

                double price;

                if (dayChoice == 1) {

                    price = 200;
                    System.out.println("Weekday ticket price: ₹" + price);

                } else if (dayChoice == 2) {

                    price = 250;
                    System.out.println("Weekend ticket price: ₹" + price);

                } else {

                    price = 200;
                    System.out.println(
                            "Invalid choice. Default ticket price: ₹" + price);
                }
                break;

            case 6:
                System.out.print("\nRate the movie from 1 to 5: ");
                int rating = sc.nextInt();

                if (rating >= 1 && rating <= 5) {
                    System.out.println(
                            "Thank you for rating the movie: "
                            + rating + "/5");
                } else {
                    System.out.println(
                            "Invalid rating! Please enter a rating between 1 and 5.");
                }
                break;

            case 7:
                System.out.println(
                        "\nThank you for using Movie Ticket Booking System!");
                break;

            default:
                System.out.println(
                        "\nInvalid choice! Please select 1 to 7.");
            }

        } while (choice != 7);

        sc.close();
    }
}