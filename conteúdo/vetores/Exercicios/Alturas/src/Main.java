import entity.person;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        String name;
        int age, less16Years = 0;
        double height;

        System.out.print("Quantas pessoas serão digitas? ");
        int quantityPersons = sc.nextInt();
        person[] vect = new person[quantityPersons];

        for (int i = 0; i < vect.length; i++){
            sc.nextLine();
            System.out.printf("%nDados da %da pessoa%n", i + 1);
            System.out.print("Nome: ");
            name = sc.nextLine();

            System.out.print("Idade: ");
            age = sc.nextInt();

            System.out.print("Altura: ");
            height = sc.nextDouble();

            vect[i] = new person(name, age, height);
            if (age < 16) less16Years++;
        }

        double percentageLess16Years =  ((double) less16Years / vect.length) * 100;
        System.out.printf("%nAltura média: %.2f%n", mediaHeight(vect));
        System.out.println("Pessoas com menos de 16 anos: " + porcentageLess16Years + "%");
        personLess16years(vect);
    }

    public static double mediaHeight(person[] vect){
        double media = 0;
        for (int i = 0; i < vect.length; i++){
            media += vect[i].getHeight();
        }
        return media / vect.length;
    }

    public static void personLess16years(person[] vect){
        for (int i = 0; i < vect.length; i++){
            if (vect[i].getAge() < 16){
                System.out.println(vect[i].getName());
            }
        }
    }
}