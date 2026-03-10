import java.util.*;

public class BillingQueue {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // using Queue for the waiting customers
        Queue<String> customers = new ArrayDeque<>();

        // using Stacks for item reversal
        Stack<String> stack = new Stack<>();

        // using Array to store the list of items
        String[] items = new String[50];

        // using Array again to store the prices of the items
        double[] prices = new double[50];

        int choice;

        do {
            System.out.println("\n1. Add Customer");
            System.out.println("2. Process Billing");
            System.out.println("3. Show Pending Customers");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();     //clearing buffer by consuming the leftover newline character
          
            switch (choice) {

                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    // Adding customer to queue
                    customers.add(name);
                    System.out.println("Customer added to queue.");
                    break;

                case 2:
                    if (!customers.isEmpty()) {

                        // First in First Out (FIFO) billing
                        String current = customers.remove();
                        System.out.println("Processing billing for: " + current);

                        System.out.print("Enter number of items: ");
                        int n = sc.nextInt();
                        sc.nextLine();

                        double total = 0;

                        // storing items and prices
                        for (int i = 0; i < n; i++) {

                            System.out.print("Enter item " + (i + 1) + ": ");
                            items[i] = sc.nextLine();

                            System.out.print("Enter price of " + items[i] + ": ");
                            prices[i] = sc.nextDouble();
                            sc.nextLine();

                            total += prices[i];

                            // pushing items into stack
                            stack.push(items[i] + " - Rs." + prices[i]);
                        }

                        System.out.println("\nItems billed (reverse order):");

                        // displaying items using stack
                        while (!stack.isEmpty()) {
                            System.out.println(stack.pop());
                        }

                        System.out.println("Total Bill = Rs." + total);
                        System.out.println("Billing completed for: " + current);

                    } else {
                        System.out.println("No customers in queue.");
                    }
                    break;

                // displaying the remaining customers in the Queue
                case 3:
                    if (!customers.isEmpty()) {
                        System.out.println("Pending Customers: " + customers);
                    } else {
                        System.out.println("Queue is empty.");
                    }
                    break;

                case 4:
                    System.out.println("Exited.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}
