import entity.GerenciamentoConta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GerenciamentoConta accountData = createAccount(sc);
        showAccountInfo(accountData);
        makeDeposit(sc, accountData);
        showAccountInfo(accountData);
        makeWithdraw(sc, accountData);
        showAccountInfo(accountData);
        sc.close();
    }

    public static GerenciamentoConta createAccount(Scanner sc){
        String name;
        char option;
        int accountNumber;
        double initialDeposit = 0.0;

        System.out.print("Enter account number: ");
        accountNumber = sc.nextInt();
        System.out.print("Enter account holder: ");
        sc.nextLine();
        name = sc.nextLine();
        System.out.print("Is there an initial deposit (y/n)? ");
        option = sc.next().charAt(0);
        if (option == 'y'){
            System.out.print("Enter initial deposit value: ");
            initialDeposit = sc.nextDouble();
        }
        return new GerenciamentoConta(accountNumber, name, initialDeposit);
    }

    public static void showAccountInfo(Object accountData){
        System.out.println("Account data: ");
        System.out.println(accountData.toString());
    }

    public static void makeDeposit(Scanner sc, GerenciamentoConta accountData){
        double deposit;
        System.out.print("Enter a deposit value: ");
        deposit = sc.nextDouble();
        accountData.deposit(deposit);
    }

    public static void makeWithdraw(Scanner sc, GerenciamentoConta accountData){
        double withdraw;
        System.out.print("Enter a withdraw value: ");
        withdraw = sc.nextDouble();
        accountData.withdraw(withdraw);
    }
}