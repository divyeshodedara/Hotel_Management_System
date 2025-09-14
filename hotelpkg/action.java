package hotelpkg;

import java.util.Scanner;

public class action {

    Hotel hotel = new Hotel();
    Scanner scanner = new Scanner(System.in);

    public void addcustomer() {
        System.out.print("Enter Customer Name: ");  
        String name = scanner.nextLine();

        System.out.print("Enter Room Number: ");
        int room = scanner.nextInt();

        if (!hotel.roomavailable(room)) {
            System.out.println("Room is already occupied.");
            return;
        }

        System.out.println("Room Rates:");
        System.out.println("1->Standard: Rs.1200 per Day");
        System.out.println("2->Deluxe: Rs.2500 per Day");
        System.out.println("3->Suite: Rs.4000 per Day");
        System.out.print("Select Room Type : ");
        int n = scanner.nextInt();
        String rtype;

        switch (n) {
            case 1 ->
                rtype = "Standard";
            case 2 ->
                rtype = "Deluxe";
            case 3 ->
                rtype = "Suite";
            default -> {
                System.out.println("Invalid room type selected. Please try again.");
                return;
            }
        }

        System.out.print("Enter Number of days: ");
        int days = scanner.nextInt();

        System.out.print("Is this a member? (yes/no): ");
        String mbr = scanner.next();

        Customer customer;
        if (mbr.equalsIgnoreCase("yes")) {
            customer = new member(name, room, rtype, days);
        } else {
            customer = new Customer(name, room, rtype, days);
        }

        if (hotel.roomavailable(room)) {
            hotel.addcustomer(customer);
            System.out.println("Customer added successfully!");
        }

    }

    public void roomservice() {
        System.out.print("Enter Room Number: ");
        int room = scanner.nextInt();
        Customer customer = hotel.customerdetails(room);

        if (customer != null) {
            System.out.println("Choose Service:");
            System.out.println("1. Food Service (Rs.800)");
            System.out.println("2. Cleaning Service (Rs.200)");
            System.out.println("3. Car Service (Rs.300)");
            int k = scanner.nextInt();

            switch (k) {
                case 1 ->
                    customer.addservice("Food Service" + ": Rs." + 800);
                case 2 ->
                    customer.addservice("Cleaning service" + ": Rs." + 200);
                case 3 ->
                    customer.addservice("Car service" + ": Rs." + 300);
                default ->
                    System.out.println("Invalid service choice.");
            }
            System.out.println("Service added successfully.");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void invoice() {
        System.out.print("Enter Room Number to generate invoice: ");
        int room = scanner.nextInt();
        Customer customer = hotel.customerdetails(room);

        if (customer != null) {
            System.out.println("\n+---------------------------------------+");
            System.out.println("|              INVOICE                  |");
            System.out.println("+---------------------------------------+");
            System.out.printf("| Customer Name: %-21s |%n", customer.name);
            System.out.printf("| Room Number:   %-21d |%n", customer.room);
            System.out.printf("| Room Type:     %-21s |%n", customer.rtype);
            System.out.printf("| Days Stayed:   %-21d |%n", customer.days);
            System.out.println("+---------------------------------------+");
            System.out.printf("| Room Charges:  Rs.%-18d |%n", customer.totalroomcharge());

            int total = customer.totalroomcharge();
            if (!customer.getservice().isEmpty()) {
                System.out.println("| Services Used:                        |");
                for (String service : customer.getservice()) {
                    System.out.printf("| - %-32s |%n", service);
                    total += Integer.parseInt(service.replaceAll("[^0-9]", ""));
                }
            } else {
                System.out.println("| No Services Used                      |");
            }
            System.out.println("+---------------------------------------+");
            System.out.printf("| Total Amount Due: Rs.%-16d |%n", total);
            System.out.println("+---------------------------------------+");
        } else {
            System.out.println("Customer not found.");
        }
    }

    public void show() {
        if (hotel.customerData.isEmpty()) {
            System.out.println("No customers to display.");
        } else {
            System.out.println("\n+-------------------------------------------------------------+");
            System.out.println("|                     LIST OF CUSTOMERS                     |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.printf("| %-20s | %-12s | %-10s | %-4s |%n", "Customer Name", "Room Number", "Room Type", "Days");
            System.out.println("+-------------------------------------------------------------+");

            for (Customer customer : hotel.customerData.values()) {
                System.out.printf("| %-20s | %-12d | %-10s | %-4d |%n",
                        customer.name,
                        customer.room,
                        customer.rtype,
                        customer.days);
            }
            System.out.println("+-------------------------------------------------------------+");
        }
    }

    public void checkout() {
        System.out.print("Enter Room Number to checkout: ");
        int room = scanner.nextInt();
        Customer customer = hotel.customerdetails(room);

        if (customer != null) {
            hotel.removecustomer(room);
            System.out.println("Checkout successful. Room " + room + " is now available.");
        } else {
            System.out.println("Room number not found or already vacant.");
        }
    }
}
