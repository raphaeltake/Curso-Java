import entity.CurrencyConverter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double dollarPrice, quantityDollars, valueInReais;
        Scanner sc = new Scanner(System.in);
        System.out.print("What is the dollar price? ");
        dollarPrice = sc.nextDouble();
        System.out.print("How many dollars will be bought? ");
        quantityDollars = sc.nextDouble();
        valueInReais = CurrencyConverter.converter(dollarPrice, quantityDollars);
        System.out.printf("Amount to be paid in reais = %.2f", valueInReais);
    }
}