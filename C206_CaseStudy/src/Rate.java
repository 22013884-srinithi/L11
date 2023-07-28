public class Rate {
	
	
    private String currencyCode;
    private double exchangeRate;

    public Rate(String currencyCode, double exchangeRate) {
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

    // Getters for attributes
    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    @Override
    public String toString() {
        return "Currency Code: " + currencyCode + ", Exchange Rate: " + exchangeRate;
    }
}
