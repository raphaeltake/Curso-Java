import entity.Grade;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Grade nota = new Grade();
        Scanner sc = new Scanner(System.in);

        System.out.print("Name: ");
        nota.name = sc.nextLine();
        System.out.print("First semester grade: ");
        nota.firstSemester = sc.nextDouble();
        System.out.print("Second semester grade: ");
        nota.secondSemester = sc.nextDouble();
        System.out.print("Third semester grade: ");
        nota.thirdSemester = sc.nextDouble();

        System.out.println(nota);
    }
}