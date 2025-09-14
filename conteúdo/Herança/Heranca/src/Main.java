import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {
    public static void main(String[] args) {
////        BusinessAccount account = new BusinessAccount();
//        Account acc = new Account(1001, "Alex", 0.0);
//        BusinessAccount bacc = new BusinessAccount(1002, "Maria", 0.0, 500.00);
//
//        // Upcasting
//        Account acc1 = bacc;
//        Account acc2 = new BusinessAccount(1003, "Bob", 0.0, 200.00);
//        Account acc3 = new SavingsAccount(1004, "Anna", 0.0, 0.01);
//
//        // Downcasting
//        BusinessAccount acc4 = (BusinessAccount) acc2;
//        acc4.loan(100.0);
//
////        BusinessAccount acc5 = (BusinessAccount) acc3;
//        if(acc3 instanceof BusinessAccount){
//            BusinessAccount acc5 = (BusinessAccount) acc3;
//            acc5.loan(200.0);
//            System.out.println("Loan!");
//        }
//
//        if (acc3 instanceof SavingsAccount){
//            SavingsAccount acc5 = (SavingsAccount)acc3;
//            acc5.updateBalance();
//            System.out.println("Update!");
//        }





        //Sobreposição
        Account acc1 = new Account(1001, "Alex", 1000.0);
        acc1.withdraw(200.0);
        System.out.println(acc1.getBalance());

        Account acc2 = new SavingsAccount(1002, "Maria", 1000.0, 0.01);
        acc2.withdraw(200.0);
        System.out.println(acc2.getBalance());

        Account acc3 = new BusinessAccount(1003, "Bob", 1000.0, 500.0);
        acc3.withdraw(200.0);
        System.out.println(acc3.getBalance());
    }
}