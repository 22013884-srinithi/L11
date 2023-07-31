import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class C206_CaseStudy {
	
	private static final int OPTION_QUIT = 7;
	
	public static void main(String[] args) {
		// Main method and other code here...
		String id = Helper.readString("Enter your ID: ");
		String password = Helper.readString("Enter your Password: ");
		
		User u1 = new User("A100", "C206", "Larry Loh", 12345678, "admin");
		User u2 = new User("A200", "C206", "Mary Yeo", 87654321, "admin");
		User u3 = new User("C100", "C206", "Sam Lee", 88001122, "customer");
		User u4 = new User("C200", "C206", "Frankie Cha", 99887766, "customer");
		
		Rate r1 = new Rate("KRW", 960);
		Rate r2 = new Rate("MYR", 3.45);
		Rate r3 = new Rate ("JPY", 106.74);
		Rate r4 = new Rate ("EUR", 0.68);
		
		
		ArrayList<User> userList = new ArrayList<User>();
		ArrayList<Rate> rateList = new ArrayList<Rate>();
		
		userList.add(u1);
		userList.add(u2);
		userList.add(u3);
		userList.add(u4);
		
		rateList.add(r1); //Khalis
		rateList.add(r2); //Khalis
		rateList.add(r3); //Khalis
		rateList.add(r4); //Khalis
		
		
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
					createTransaction(); // Don Lim
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
	
	public static void createTransaction() {
		String accountID = Helper.readString("Enter Account ID: ");
		Date date = (Date) Helper.readDate("Date of Transaction: ");
		int amount = Helper.readInt("Enter Amount to Exchange: ");
		String code = Helper.readString("Enter Country code to convert: ");
		double amountGiven = 0.0;
		
		for (Rate i : rateList) {
			if(code.matches(i.getCurrencyCode())) {
				amountGiven = i.getExchangeRate() * amount;
				break;
			}
		}
		
		//Transactions newTransaction = new Transactions(amount, date, amount, amount, code, amount);
		
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

	
