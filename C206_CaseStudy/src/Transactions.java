
public class Transactions {
	
	private int transactionID;
	private String transactionDate;
	private int amountExchanged;
	private int customerID;
	private String currencyCode;
	private double exchangeRate;
	
	public Transactions(int transactionID, String transactionDate, int amountExchanged, int customerID, String currencyCode, double exchangeRate) {
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.amountExchanged = amountExchanged;
		this.customerID = customerID;
		this.currencyCode = currencyCode;
		this.exchangeRate = exchangeRate;
	}

	public int getTransactionID() {
		return transactionID;
	}

	public String getTransactionDate() {
		return transactionDate;
	}
	
	public int getAmountExchanged() {
		return amountExchanged;
	}

	public int getCustomerID() {
		return customerID;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

}
