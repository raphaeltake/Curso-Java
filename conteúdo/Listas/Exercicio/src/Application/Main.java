package Application;

import entity.employer;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/*
Fazer um programa para ler um número inteiro N e depois os dados (id, nome e salario) de
N funcionários. Não deve haver repetição de id.
Em seguida, efetuar o aumento de X por cento no salário de um determinado funcionário.
Para isso, o programa deve ler um id e o valor X. Se o id informado não existir, mostrar uma
mensagem e abortar a operação. Ao final, mostrar a listagem atualizada dos funcionários,
conforme exemplos.
Lembre-se de aplicar a técnica de encapsulamento para não permitir que o salário possa
ser mudado livremente. Um salário só pode ser aumentado com base em uma operação de
aumento por porcentagem dada.
 */

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<employer> list = new ArrayList<>();
        registerEmployers(sc, list);
        salaryIncrease(sc, list);
        showEmployees(list);
    }

    public static void registerEmployers(Scanner sc, List<employer> list){
        int quantityEmployees;
        double salary;
        String name;

        System.out.print("How many employees will be registered? ");
        quantityEmployees = sc.nextInt();

        for (int i = 0; i < quantityEmployees; i++){
            int id;
            System.out.printf("%nEmployee #%d%n", i + 1);

            System.out.print("Id: ");
            id = sc.nextInt();
            sc.nextLine();

            employer emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
            if (emp != null){
                System.out.println("Já existe um usuário com esse id!");
                i--;
                continue;
            }

            System.out.print("Name: ");
            name = sc.nextLine();

            System.out.print("Salary: ");
            salary = sc.nextDouble();

            list.add(new employer(id, name, salary));
        }
    }

    public static void salaryIncrease(Scanner sc, List<employer> list){
        int id;
        double percentage;
        System.out.printf("%nEnter the employee id that will have salary increase: ");
        id = sc.nextInt();

        employer emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (emp == null){
            System.out.println("This id does not exist!");
            return;
        }

        System.out.print("Enter the percentage: ");
        percentage = sc.nextDouble();
        emp.increaseSalary(percentage);

    }

    public static void showEmployees(List<employer> list){
        System.out.printf("%nList of employees:%n");
        for (employer pessoas : list){
            System.out.println(pessoas);
        }
    }
}