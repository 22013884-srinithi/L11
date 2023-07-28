import java.util.ArrayList;
import java.util.List;

public class Rate {
    private String currencyCode;
    private double exchangeRate;

    // Static list to store all rates (could be replaced with a database in a real application)
    private static List<Rate> rateList = new ArrayList<>();

    public Rate(String currencyCode, double exchangeRate) {
        this.currencyCode = currencyCode;
        this.exchangeRate = exchangeRate;
    }

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

    // Getters for attributes
    public String getCurrencyCode() {
        return currencyCode;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public String toString() {
        return "Currency Code: " + currencyCode + ", Exchange Rate: " + exchangeRate;
    }
}
