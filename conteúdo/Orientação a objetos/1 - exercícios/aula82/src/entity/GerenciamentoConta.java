package entity;

public class GerenciamentoConta {
    private final int accountNumber;
    private String name;
    private double value;

    public GerenciamentoConta(int accountNumber, String name, double value) {
        this.accountNumber = accountNumber;
        this.name = name;
        deposit(value);
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getValue() {
        return value;
    }

    public void deposit(double value){
        this.value += value;
    }

    public void withdraw(double value){
        this.value -= value + 5;
    }

    
    public String toString() {
        return "account " + accountNumber +
                ", holder: " + name +
                String.format(", balance: $ %.2f%n", value);
    }
}
