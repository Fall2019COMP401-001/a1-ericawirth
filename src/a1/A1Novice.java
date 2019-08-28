package a1;

import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		process(scan);
		
	}
	
	public static void process(Scanner s) {
		
		int totalCustomers = s.nextInt();
		String customerFirstName;
		String customerLastName;
		String customerFirstInital;
		int totalItemsBought;
		int quantityPurchased = 0;
		String itemName;
		double itemPrice = 0.0;
		
		for (int i=0; i < totalCustomers; i++) {
			customerFirstName = s.next();
			customerLastName = s.next();
			customerFirstInital = customerFirstName.substring(0,1);
			totalItemsBought = s.nextInt();
			double totalCost = 0;
			
			for (int x=0; x<totalItemsBought; x++) {
				quantityPurchased = s.nextInt();
				itemName = s.next();
				itemPrice = s.nextDouble();
				totalCost += (itemPrice*quantityPurchased);
				//System.out.println (totalCost);
			}
			
		System.out.println(customerFirstInital + ". " + customerLastName + ": " + String.format("%.2f", totalCost));	
		
		}
	}
}
