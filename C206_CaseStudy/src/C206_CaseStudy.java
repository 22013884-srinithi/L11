import java.util.ArrayList;
import java.util.List;

public class C206_CaseStudy {

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

	public static void main(String[] args) {
		// Main method and other code here...
	}
}

	
