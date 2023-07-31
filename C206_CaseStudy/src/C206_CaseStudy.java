import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class C206_CaseStudy {
	
	
	public static void main(String[] args) {
		// Main method and other code here...
		String id = Helper.readString("Enter your ID: ");
		String password = Helper.readString("Enter your Password: ");
		
		User u1 = new User("A100", "C206", "Larry Loh", 12345678, "admin");
		User u2 = new User("A200", "C206", "Mary Yeo", 87654321, "admin");
		User u3 = new User("C100", "C206", "Sam Lee", 88001122, "customer");
		User u4 = new User("C200", "C206", "Frankie Cha", 99887766, "customer");
		
		Rate r1 = new Rate("KRW", 960);
		Rate r2 = new Rate("MYR", 3.42);
		Rate r3 = new Rate ("JPY", 106.74);
		Rate r4 = new Rate ("EUR", 0.68);
		
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date = "01/02/2023";
		LocalDate dateLD = LocalDate.parse(date, formatter1);

		Transactions t1 = new Transactions("C100KRW1922", dateLD, 2, "C100", "KRW", 960, 1922.2);
		Transactions t2 = new Transactions("C100MYR342", dateLD, 100, "C100", "MYR", 3.42, 342);
		Transactions t3 = new Transactions("C100KRW1922", dateLD, 2, "C100", "KRW", 960, 1922.2);
		Transactions t4 = new Transactions("C100KRW1922", dateLD, 2, "C100", "KRW", 960, 1922.2);
		
		
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Rate> rateList = new ArrayList<Rate>();
		ArrayList<Transactions> transactionList = new ArrayList<Transactions>();
		
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
		
		rateList.add(r1); //Khalis
		rateList.add(r2); //Khalis
		rateList.add(r3); //Khalis
		rateList.add(r4); //Khalis
		
		transactionList.add(t1);
		transactionList.add(t2);
		transactionList.add(t3);
		transactionList.add(t4);
		
		
		String output = " ";
		String role = " ";
		String name = " "; 
		for (User i : userList) {
			if(id.matches(i.getUserID()) && password.matches(i.getPassword())) {
				role =  i.getRole();
				output = " ";
				if(role == "admin") {
					name = i.getFullName();
					break;
				} else if (role == "customer") {
					name = i.getFullName();
					break;
				}
			} else {
				output += "Invalid Username or Password";
			}
		}
		System.out.println(output);
		
		if (role == "admin") {
			System.out.println("Hello " + name + "!");
			int option = 0;
			
			while (option != 5) {
				
				C206_CaseStudy.adminmenu();
				option = Helper.readInt("Enter an option > ");
				
				if (option == 1) {
					
				} else if (option == 2) {
					
				} else if (option == 3) {
					
				} else if(option == 4) {
					
				} else if(option == 5) {
					System.out.println("Goodbye!");
				} else {
					System.out.println("Invalid option!");
				}
			}
		}
		
		if (role == "customer") {
			System.out.println("Hello " + name + "!");
			int option = 0;
			
			while (option != 6) {
				
				C206_CaseStudy.customermenu();
				option = Helper.readInt("Enter an option > ");
				
				if (option == 1) {
					
				} else if (option == 2) {
					createTransaction(rateList, transactionList); // Don Lim
				} else if (option == 3) {
					
				} else if(option == 4) {
					viewRates(rateList); // Khalis
				} else if (option == 5) {
					
				} else if (option == 6) {
					System.out.println("Goodbye!");
				} else {
					System.out.println("Invalid option!");
				}
			}
		}
		
	}
	
	public static void customermenu() {
		C206_CaseStudy.setHeader("Money Exchange Management System");
		System.out.println("1. View Currency");
		System.out.println("2. Transaction");
		System.out.println("3. Maintain Account");
		System.out.println("4. View Rates");
		System.out.println("5. Create Feedbacks");
		System.out.println("6. Quit");
		Helper.line(80, "-");
	}
	
	public static void adminmenu() {
		C206_CaseStudy.setHeader("Money Exchange Management System");
		System.out.println("1. New User");
		System.out.println("2. Currency");
		System.out.println("3. Rates");
		System.out.println("4. View Feedbacks");
		System.out.println("5. Quit");
		Helper.line(80, "-");
	}
	
	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}
	
	public static void createTransaction(ArrayList<Rate> rateList, ArrayList<Transactions> transactionList) {
		String accountID = Helper.readString("Enter Account ID: ");
		String date = Helper.readString("Date of Transaction: ");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate dateLD = LocalDate.parse(date, formatter);
		int amount = Helper.readInt("Enter Amount to Exchange: ");
		String code = Helper.readString("Enter Country code to convert: ").toUpperCase();
		double amountGiven = 0.0;
		double rate = 0.0;
		
		for (Rate i : rateList) {
			if(code.matches(i.getCurrencyCode())) {
				amountGiven = i.getExchangeRate() * amount;
				rate = i.getExchangeRate();
				break;
			}
		}
		String toString = Double.toString(amountGiven);
		String transactionID = accountID + code + toString;
		Transactions newTransaction = new Transactions(transactionID, dateLD, amount, accountID, code, rate, amountGiven);
		transactionList.add(newTransaction);
		
		String output = "";
		for (Transactions i: transactionList) {
			if (transactionID.matches(i.getTransactionID())) {
				output = "New Transaction Successfully Created!";
				break;
			} else {
				output = "Transaction Declined!";
			}
		}
		System.out.println(output);
		
		
	}

	// View Rates
	public static void viewRates(ArrayList<Rate> rateList) { // Khalis
	
	System.out.println(String.format("%-15s %-15s", "Currency Code", "Exchange Rate"));
	Helper.line(30, "=");
	for (Rate i: rateList) {
		System.out.println(String.format("%-15s %-15.2f", i.getCurrencyCode(), i.getExchangeRate()));
			
			
		}
	}

	// Static list to store all rates
	private static List<Rate> rateList = new ArrayList<>();

	// Static list to store all transactions 
	private static List<Transactions> transactionList = new ArrayList<>();

	// Method to add a new rate
	public static void addRate(String currencyCode, double exchangeRate) {
		Rate newRate = new Rate(currencyCode, exchangeRate);
		rateList.add(newRate);
	}

	// Method to view all rates
	public static List<Rate> getAllRates() {
		return rateList;
	}

	// Method to delete an existing rate
	public static boolean deleteRate(String currencyCode) {
		for (Rate rate : rateList) {
			if (rate.getCurrencyCode().equals(currencyCode)) {
				rateList.remove(rate);
				return true; // Rate deleted successfully
			}
		}
		return false; // Rate with given currencyCode not found
	}

}

	
