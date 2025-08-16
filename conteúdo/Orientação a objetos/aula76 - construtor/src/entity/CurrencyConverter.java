package entity;

public class CurrencyConverter {

    public static double converter(double dollarPrice, double quantityDollars){
        return dollarPrice * quantityDollars * 1.06;
    }

}
