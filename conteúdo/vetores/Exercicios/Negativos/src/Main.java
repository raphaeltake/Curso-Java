import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers;
        int quantityNumbers;
        System.out.print("Quantos números você vai digitar? ");
        quantityNumbers = sc.nextInt();
        numbers = new int[quantityNumbers];

        for (int i = 0; i < numbers.length; i++){
            sc.nextLine();
            System.out.print("Digite um número: ");
            numbers[i] = sc.nextInt();
        }

        System.out.println("Números negativos: ");
        for (int i = 0; i < numbers.length; i++){
            if (numbers[i] < 0){
                System.out.println(numbers[i]);
            }
        }
        sc.close();
    }
}