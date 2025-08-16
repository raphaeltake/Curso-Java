import entity.room;

import java.util.Scanner;

/*
A dona de um pensionato possui dez quartos para alugar para estudantes,
sendo esses quartos identificados pelos números 0 a 9.

Fazer um programa que inicie com todos os dez quartos vazios, e depois
leia uma quantidade N representando o número de estudantes que vão
alugar quartos (N pode ser de 1 a 10). Em seguida, registre o aluguel dos
N estudantes. Para cada registro de aluguel, informar o nome e email do
estudante, bem como qual dos quartos ele escolheu (de 0 a 9). Suponha
que seja escolhido um quarto vago. Ao final, seu programa deve imprimir
um relatório de todas as ocupações do pensionato, por ordem de quarto,
conforme exemplo.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int quantityStudents;
        room[] vect = new room[10];

        System.out.print("How many rooms will be rented? ");
        quantityStudents = sc.nextInt();
        sc.nextLine();
        registerStudents(quantityStudents, vect, sc);
        showBusyRooms(vect);
        sc.close();
    }

    public static void registerStudents(int quantityStudents, room[] vect, Scanner sc){
        int roomNumber;
        String nameStudent, emailStudent;
        for (int i = 0; i < quantityStudents; i++){
            System.out.println();
            System.out.println("Rent #" + (i + 1) + ":");
            System.out.print("Name: ");
            nameStudent = sc.nextLine();

            System.out.print("Email: ");
            emailStudent = sc.nextLine();

            do {
                System.out.print("Room: ");
                roomNumber = sc.nextInt();
                sc.nextLine();
                if (roomNumber > 9 || roomNumber < 0 || vect[roomNumber] != null) System.out.println("Quarto não existe ou já está ocupado!");
            } while(roomNumber > 9 || roomNumber < 0 || vect[roomNumber] != null);

            vect[roomNumber] = new room(nameStudent, emailStudent);
        }
    }

    public static void showBusyRooms(room[] vect){
        System.out.printf("%n%nBusy rooms: %n");
        for (int i = 0; i < vect.length; i++){
            if (vect[i] != null){
                System.out.println(i + ": " + vect[i].toString());
//                System.out.printf("%d: %s, %s%n", i ,vect[i].getName(), vect[i].getEmail());
            }
        }
    }
}