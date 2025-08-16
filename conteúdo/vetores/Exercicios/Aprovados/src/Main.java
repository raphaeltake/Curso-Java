import entity.person;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        int quantityStudents;
        String name;
        double score1, score2, media;

        System.out.print("Quantos alunos serão digitados? ");
        quantityStudents = sc.nextInt();
        person[] student = new person[quantityStudents];

        for (int i = 0; i < student.length; i++){
            sc.nextLine();
            System.out.printf("%nDigite o nome do aluno: ");
            name = sc.nextLine();

            System.out.print("Digite a primeira nota: ");
            score1 = sc.nextDouble();

            System.out.print("Digite a segunda nota: ");
            score2 = sc.nextDouble();

            media = (score1 + score2) / 2;
            student[i] = new person(name, score1, score2, media);
        }

        System.out.printf("%n%nAlunos aprovados: ");

        for (int i = 0; i < student.length; i++){
            if (student[i].getMedia() >= 6){
                System.out.println(student[i].getName());
            }
        }
    }
}