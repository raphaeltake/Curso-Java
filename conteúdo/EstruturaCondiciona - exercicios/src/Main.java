import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        Exercicio01(sc);
//        Exercicio02(sc);
//        Exercicio03(sc);
//        Exercicio04(sc);
//        Exercicio5(sc);
//        Exercicio6(sc);
        Exercicio7(sc);
    }

    public static void Exercicio01(Scanner sc){
        System.out.println("Digite um número: ");
        int numero = sc.nextInt();
//        if (numero >= 0) {
//            System.out.println("NÃO NEGATIVO");
//        } else{
//            System.out.println("NEGATIVO");
//        }
        System.out.print((numero >= 0) ? "NÃO NEGATIVO" : "NEGATIVO");
    }

    public static void Exercicio02(Scanner sc){
        System.out.println("Digite um número: ");
        int numero = sc.nextInt();
        System.out.println((numero % 2 == 0) ? "PAR" : "ÍMPAR");
    }

    public static void Exercicio03(Scanner sc){
        int primeiro, segundo;
        System.out.println("Digite o primeiro número: ");
        primeiro = sc.nextInt();
        System.out.println("Digite o segundo número: ");
        segundo = sc.nextInt();
        System.out.println((primeiro % segundo == 0 || segundo % primeiro == 0) ? "SÃO MÚLTIPLOS" : "NÃO SÃO MÚLTIPLOS");
    }

    public static void Exercicio04(Scanner sc){
        int horario1, horario2, tempoJogado;
        System.out.println("Horário 1: ");
        horario1 = sc.nextInt();
        System.out.println("Horário 2: ");
        horario2 = sc.nextInt();
        tempoJogado = (horario1 < horario2) ? horario2 - horario1 : (24 - horario1) + horario2;
        System.out.printf("O JOGO DUROU %d HORA(S)", tempoJogado);
    }

    public static void Exercicio5(Scanner sc){
        int codigo, quantidade;
        double preco_unitario, preco;
        System.out.println("Digite o código do item: ");
        codigo = sc.nextInt();
        System.out.println("Digite a quantidade: ");
        quantidade = sc.nextInt();
        preco_unitario = switch (codigo) {
            case 1 -> 4.0;
            case 2 -> 4.5;
            case 3 -> 5.0;
            case 4 -> 2.0;
            case 5 -> 1.5;
            default -> 0;
        };
        preco = preco_unitario * quantidade;
        System.out.printf("TOTAL: R$ %.2f", preco);
    }

    public static void Exercicio6(Scanner sc){
        double valor;
        String intervalo;
        System.out.println("Digite um valor: ");
        valor = sc.nextDouble();
        if (valor >= 0.0 && valor <= 25.0){
            intervalo = "[0,25]";
        } else if (valor > 25.0 && valor <= 50.0){
            intervalo = "(25,50]";
        } else if (valor > 50.0 && valor <= 75.0){
            intervalo = "(50,75]";
        } else if (valor > 75.0 && valor <=100.0) {
            intervalo = "(75,100]";
        } else{
            intervalo = "";
        }

        if (!intervalo.isEmpty()){
            System.out.printf("Intervalo %s", intervalo);
        } else {
            System.out.println("Fora de intervalo");
        }
    }

    public static void Exercicio7(Scanner sc){
        double valor1, valor2;
        String quadrante;
        System.out.println("Digite o primeiro valor: ");
        valor1 = sc.nextDouble();
        System.out.println("Digite o segundo valor: ");
        valor2 = sc.nextDouble();
        if (valor1 > 0 && valor2 > 0){
            quadrante = "Q1";
        } else if (valor1 > 0 && valor2 < 0) {
            quadrante = "Q4";
        } else if (valor1 < 0 && valor2 > 0) {
            quadrante = "Q2";
        } else if (valor1 < 0 && valor2 < 0) {
            quadrante = "Q3";
        } else {
            quadrante = "Origem";
        }
        System.out.println(quadrante);
    }

}