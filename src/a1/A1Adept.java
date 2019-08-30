package a1;

import java.util.Scanner;
import java.text.DecimalFormat;

public class A1Adept {

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
				
				for (int y=0; y<numberOfItemsPurchased; y++) {
					int multiple = s.nextInt();
					// System.out.println(multiple);
					String thisPurchase = s.next();
					// System.out.println(thisPurchase);
					totalCost += (multiple*search(allItemNames, allItemPrices,thisPurchase,totalNumberOfStoreItems));
					// System.out.println(search(allItemNames, allItemPrices,thisPurchase,totalNumberOfStoreItems));
					// System.out.println(String.format("%.2f",totalCost));
				}
				totalCostsArray[x] = totalCost;
				// System.out.println(totalCostsArray[x]);
		}
		DecimalFormat df = new DecimalFormat("####0.00");

		System.out.println("Biggest: " + matchToPerson(customerSpecifics, totalCostsArray, maximum(totalCostsArray, numberOfCustomers)) + " (" + df.format((maximum(totalCostsArray, numberOfCustomers))) + ")");
		System.out.println("Smallest: " + matchToPerson(customerSpecifics, totalCostsArray, minimum(totalCostsArray, numberOfCustomers)) + " (" + df.format(minimum(totalCostsArray, numberOfCustomers)) + ")");
		System.out.println("Average: " + df.format(average(totalCostsArray)));
		
		// matchToPerson(customerSpecifics);
	}
	
	// Returns the price that matches the specific item purchased
	public static double search(String[] allItemNames, double[]allItemPrices, String thisPurchase, int totalNumberOfStoreItems) {
		for (int z=0; z < totalNumberOfStoreItems; z++) {
			if (thisPurchase.contentEquals(allItemNames[z])) {
				return allItemPrices[z];
			} 
		}
		return 0.0;
	}	
	
	public static String matchToPerson(String[] customerSpecifics, double[] totalCostsArray, double matchValue) {
		int temp; 
		for (int t=0; t<customerSpecifics.length; t++) {
			if (matchValue == totalCostsArray[t]) {
				temp = t;
				return customerSpecifics[temp];
			}
		}
		return "";
	}
	
	// Finds the maximum value in an array of double values
	public static double maximum(double[] totalCostsArray, int numberOfCustomers) {
		double maximum = totalCostsArray[0];
		for (int k = 0; k < totalCostsArray.length; k++) {
			if (totalCostsArray[k] > maximum) {
				maximum = totalCostsArray[k];
			}
		}
		return maximum;
		
	}
	
	//Finds the minimum value in an array of double values
	public static double minimum(double[] totalCostsArray, int numberOfCustomers) {
		double minimum = totalCostsArray[0];
		for (int p=0; p < totalCostsArray.length; p++) {
			if (totalCostsArray[p] < minimum) {
				minimum = totalCostsArray[p];
			}
		}
		return minimum;
	}
	
	//Finds the average value in an array of double values
	public static double average(double[] totalCostsArray) {
		double total = 0.0;
		for (int j = 0; j <totalCostsArray.length; j++) {
			total += totalCostsArray[j];
			// System.out.println(total);
		}
		double average = (total/totalCostsArray.length);
		return Math.round((average*100.00)) /100.00d;
	}
}

