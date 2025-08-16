import entity.Person;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Person pessoa = new Person();
        double increaseSalary;
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        pessoa.name = sc.nextLine();
        System.out.print("Gross salary: ");
        pessoa.salary = sc.nextDouble();
        System.out.print("Tax: ");
        pessoa.tax = sc.nextDouble();

        System.out.println("Employee: " + pessoa);

        System.out.print("Which percentage to increase salary? ");
        increaseSalary = sc.nextDouble();
        pessoa.increaseSalary(increaseSalary);

        System.out.println("Employee: " + pessoa);
    }
}