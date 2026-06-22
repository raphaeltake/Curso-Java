package exercicio;

import exercicio.entities.Base;
import exercicio.entities.Company;
import exercicio.entities.Individual;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main{
    static void main(String[] arg){

        Locale.setDefault(Locale.US);

        List<Base> payers = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of tax payers: ");
        int quantity_payers = sc.nextInt();
        Base payer;
        for (int i = 0; i < quantity_payers; i++){
            sc.nextLine();
            System.out.printf("Tax payer #%d data: \n", i + 1);
            System.out.print("Individual or company (i/c)? ");
            char choice = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Anual income: ");
            double anual_income = sc.nextDouble();

            if (choice == 'i'){
                payer = new Individual(name, anual_income, individual(sc));
            } else{
                payer = new Company(name, anual_income, company(sc));
            }

            payers.add(payer);
        }

        show_taxes_paid(payers);
    }

    static double individual(Scanner sc){
        System.out.print("Health expenditures: ");
        return sc.nextDouble();
    }

    static int company(Scanner sc){
        System.out.print("Number of employees: ");
        return sc.nextInt();
    }

    static void show_taxes_paid(List<Base> payers){
        double total_taxes = 0.0;

        System.out.println("\nTAXES PAID:");
        for (Base payer : payers){
            double tax = payer.calc_taxes();
            System.out.printf("%s: $ %.2f \n", payer.getName(), tax);
            total_taxes += tax;
        }

        System.out.printf("\nTOTAL TAXES: $ %.2f", total_taxes);
    }
}