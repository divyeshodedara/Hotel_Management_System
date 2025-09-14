import hotelpkg.action;
import java.util.*;
public class HMS 
{
    public static void main(String[] args) 
    {
        action actionHandler = new action();
        Scanner scanner = new Scanner(System.in);
        while(true) 
        {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Add New Customer");
            System.out.println("2. Provide Room Service");
            System.out.println("3. Generate Invoice");
            System.out.println("4. Show All Customers");
            System.out.println("5. Checkout Customer");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> actionHandler.addcustomer();
                case 2 -> actionHandler.roomservice();
                case 3 -> actionHandler.invoice();
                case 4 -> actionHandler.show();
                case 5 -> actionHandler.checkout();
                case 6 -> {
                    System.out.println("Exiting system. Goodbye!");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
