import java.util.*;

public class RailwaySystem {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// using Queue for ticket line
		Queue<String> queue = new ArrayDeque<>();
		
		// storing the cancelled tickets in the Stack
		Stack<String> cancelled = new Stack<>();
		
		// using Array to store the issued tickets
		String[] tickets = new String[45];
		
		int ticketCount = 0;
		
		int choice;
		
		do {
			System.out.println("\n1. Add Customer");
			System.out.println("2. Serve the Customer");
			System.out.println("3. Cancel the ticket");
			System.out.println("4. Display the Queue");
			System.out.println("5. Exit");
			System.out.println("Enter Choice: ");
			
			choice = sc.nextInt();
			sc.nextLine();		     //clearing buffer by consuming the leftover newline character
			
			switch (choice) {
			
			case 1 : 
				System.out.println("Enter Customer Name: ");
				String name = sc.nextLine();
				
				// adding the customer to the queue
				queue.add(name);
				System.out.println("Customer is added!");
				break;
				
			case 2 :
				if (!queue.isEmpty()) {
					
					//serve the customer on first come(FIF)) basis
					String served = queue.remove();
					
					//storing the issued ticket in array
					tickets[ticketCount++] = served;
					
					System.out.println("Ticket issued to : " + served);
				} else {
					System.out.println("Queue is Empty!");
				}
				break;
				
			case 3 :
				if (ticketCount > 0) {
					
					//Cancel the last issued ticket (stored in stack - LIFO)
					String last = tickets[--ticketCount];
					cancelled.push(last);
					
					System.out.println("Ticket is cancelled for: " + last);
				} else {
					System.out.println("there are no tickets to cancel.");
				}
				break;
				
			case 4 : 
				if (!queue.isEmpty()) {
					//display the waiting list
					System.out.println("Waiting list: " + queue);
				} else {
					System.out.println("Queue is empty");
				}
				break;
				
			case 5:
				System.out.println("Exited.");
				break;
				
			default : 
				System.out.println("Invalid Choice");
			}
		} while (choice != 5);
		sc.close();
	}
}
