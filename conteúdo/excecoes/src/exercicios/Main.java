import exercicios.model.entities.Account;
import exercicios.model.exception.DomainException;

void main() {
    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    try{
        System.out.println("Enter account data");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        sc.nextLine();

        System.out.print("Holder: ");
        String holder = sc.nextLine();

        System.out.print("Initial balance: ");
        Double balance = sc.nextDouble();
        sc.nextLine();

        System.out.print("Withdraw limit: ");
        Double withdrawLimit = sc.nextDouble();
        sc.nextLine();

        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.print("\nEnter amount for withdraw: ");
        Double withdraw = sc.nextDouble();

        acc.withdraw(withdraw);

        System.out.println("New balance: " + acc.getBalance());

    } catch (DomainException e){
        System.out.println("Withdraw error: " + e.getMessage());
    } catch (RuntimeException e){
        System.out.println("Unexpected error " + e.getMessage());
    }

    sc.close();
}
