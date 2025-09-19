import entities.Employee;
import entities.OutsourceEmployee;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int qtde = sc.nextInt();
        Employee[] vect = new Employee[qtde];
        inputData(vect, sc);
        showPayment(vect);

    }

    public static void inputData(Employee[] vect, Scanner sc){
        for (int i = 0; i < vect.length; i++){
            sc.nextLine();
            System.out.printf("%nEmployee #%d data:", i+1);
            System.out.printf("%nOutsorced (y/n)? ");
            String outsorced = sc.next().toUpperCase();

            sc.nextLine();

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Hours: ");
            int hours = sc.nextInt();

            System.out.print("Value per hour: ");
            double valuePerHour = sc.nextDouble();

            if (outsorced.equals("Y")){
                System.out.print("Additional charge: ");
                double additionalCharge = sc.nextDouble();
                vect[i] = new OutsourceEmployee(name, hours, valuePerHour, additionalCharge);
            } else {
                vect[i] = new Employee(name, hours, valuePerHour);
            }
        }
    }

    public static void showPayment(Employee[] vect){
        System.out.println();
        System.out.println("Payments:");
        for (Employee employee : vect){
            System.out.println(employee.getName() + " - $" + String.format("%.2f", employee.payment()));
        }
    }
}