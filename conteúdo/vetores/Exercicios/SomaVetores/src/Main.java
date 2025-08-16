import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] numbers;
        double sum = 0;
        System.out.print("Quantos números você vai digitar? ");
        int quantityNumbers = sc.nextInt();
        numbers = new double[quantityNumbers];

        for (int i = 0; i < numbers.length; i++){
            System.out.print("Digite um número: ");
            numbers[i] = sc.nextDouble();
            sum += numbers[i];
        }
        
        System.out.print("VALORES = ");
        for (int i = 0; i < numbers.length; i++){
            System.out.printf(" %.2f ", numbers[i]);
        }

        System.out.println();
        System.out.println("SOMA = " + sum);
        System.out.println("MEDIA = " + sum / numbers.length);
    }
}