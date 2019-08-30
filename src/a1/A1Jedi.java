package a1;

import java.util.Scanner;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		process(scan);
	}
	
	public static void process(Scanner s) {
		
		int totalNumberOfStoreItems = s.nextInt();
		String[] allItemNames = new String[totalNumberOfStoreItems];
		String itemName = "";
		double[] allItemPrices = new double[totalNumberOfStoreItems];
		double itemPrice = 0.0;
		int[] totalItemsPurchased = new int[totalNumberOfStoreItems];
		int[] customerAmountPurchased = new int[totalNumberOfStoreItems];
		
		for (int i = 0; i < totalNumberOfStoreItems; i++) {
			allItemNames[i] = s.next();
			allItemPrices[i] = s.nextDouble();
			// System.out.println(allItemNames[2]);
			// System.out.println(allItemPrices[2]);
		}
		
		int numberOfCustomers = s.nextInt();
		// System.out.println(numberOfCustomers);
		
		String[] customerSpecifics = new String[numberOfCustomers];
		String customerFirstName;
		String customerLastName;
		int numberOfItemsPurchased;
		double totalCost;
		double totalCostsArray[] = new double[numberOfCustomers];
			
		for (int x=0; x<numberOfCustomers; x++) {
				customerFirstName = s.next();
				customerLastName = s.next();
				customerSpecifics[x] = customerFirstName + " " + customerLastName;
				// System.out.println(customerSpecifics[x]);
				numberOfItemsPurchased = s.nextInt();
				totalCost = 0.0;
				// System.out.println(customerFirstName);
				// System.out.println(customerLastName);
				// System.out.println(numberOfItemsPurchased);
				
				boolean[] repeatedItems = new boolean[allItemNames.length];
				for (int f = 0; f <allItemNames.length; f++) {
					repeatedItems[f] = true;
				}
				
				for (int y=0; y<numberOfItemsPurchased; y++) {
					int multiple = s.nextInt();
					// System.out.println(multiple);
					String thisPurchase = s.next();
					// System.out.println(thisPurchase);
					
					for (int z=0; z<allItemNames.length;z++) {
						if (allItemNames[z].contentEquals(thisPurchase)) {
							totalItemsPurchased[z] += multiple;
							if (repeatedItems[z]) {
								customerAmountPurchased[z] += 1;
								repeatedItems[z] = false;
							}
						}
					}
				}
			}
		
		for (int r=0; r < allItemNames.length; r++) {
			if (customerAmountPurchased[r] == 0) {
				System.out.println("No customers bought " + allItemNames[r]);
			} else {
				System.out.println(customerAmountPurchased[r] + " customers bought " + totalItemsPurchased[r] + " " + allItemNames[r]);
			}
		}

	}
	
}


