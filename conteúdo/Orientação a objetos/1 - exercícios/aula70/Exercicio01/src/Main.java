import entity.Rectangle;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Rectangle retangulo = new Rectangle();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter rectangle width and height: ");
        retangulo.width = sc.nextDouble();
        retangulo.height = sc.nextDouble();
        System.out.println(retangulo);
    }
}