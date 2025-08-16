import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Exercicio1(sc);
//        Exercicio2(sc);
        Exercicio3(sc);
    }
    public static void Exercicio1(Scanner sc){
        int senha;
        System.out.println("Digite uma senha: ");
        senha = sc.nextInt();
        while (senha != 2002){
            System.out.println("Senha Inválida");
            System.out.println("Digite uma senha: ");
            senha = sc.nextInt();
        }
        System.out.println("Acesso Permitido");
    }
    public static void Exercicio2(Scanner sc){
        int valor1, valor2;
        do {
            System.out.println("Digite o primeiro valor: ");
            valor1 = sc.nextInt();
            System.out.println("Digite o segundo valor: ");
            valor2 = sc.nextInt();
            if (valor1 == 0 || valor2 == 0){
                break;
            } else if (valor1 > 0 && valor2 > 0) {
                System.out.println("primeiro");
            } else if (valor1 > 0 && valor2 < 0) {
                System.out.println("quarto");
            } else if (valor1 < 0 && valor2 > 0) {
                System.out.println("segundo");
            } else if (valor1 < 0 && valor2 < 0) {
                System.out.println("terceiro");
            } else {
                System.out.println("origem");
            }
        } while (true);

    }
    public static void Exercicio3(Scanner sc){
        int entradaDados, alcool = 0, gasolina = 0, diesel = 0;
        System.out.println("Selecione um combustível: ");
        entradaDados = sc.nextInt();
        while (entradaDados != 4){
            if (entradaDados > 4 || entradaDados < 0){
                System.out.println("Código incorreto! Selecione um combustível: ");
                entradaDados = sc.nextInt();
                continue;
            }
            if (entradaDados == 1){
                alcool++;
            } else if (entradaDados == 2){
                gasolina++;
            } else if (entradaDados == 3) {
                diesel++;
            } else {
                break;
            }
            System.out.println("Selecione um combustível: ");
            entradaDados = sc.nextInt();
        }
        System.out.printf("MUITO OBRIGADO%n" +
                        "Alcool: %d%n" + "Gasolina: %d%n" + "Diesel: %d%n",
                        alcool, gasolina, diesel);

    }
}