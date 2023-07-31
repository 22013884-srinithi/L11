import java.time.LocalDate;

public class Transactions {
	
	private String transactionID;
	private LocalDate transactionDate;
	private int amountExchanged;
	private String customerID;
	private String currencyCode;
	private double exchangeRate;
	private double amountGiven;
	
	public Transactions(String transactionID, LocalDate transactionDate, int amountExchanged, String customerID, String currencyCode, double exchangeRate, double amountGiven) {
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.amountExchanged = amountExchanged;
		this.customerID = customerID;
		this.currencyCode = currencyCode;
		this.exchangeRate = exchangeRate;
		this.amountGiven = amountGiven;
	}

	public String getTransactionID() {
		return transactionID;
	}

	public LocalDate getTransactionDate() {
		return transactionDate;
	}
	
	public int getAmountExchanged() {
		return amountExchanged;
	}

	public String getCustomerID() {
		return customerID;
	}

	public double getAmountGiven() {
		return amountGiven;
	}

	public String getCurrencyCode() {
		return currencyCode;
	}

	public double getExchangeRate() {
		return exchangeRate;
	}

}
