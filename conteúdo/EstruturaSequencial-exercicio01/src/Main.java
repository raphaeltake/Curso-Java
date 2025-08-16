import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        exercicio01(sc);
//        exercicio02(sc);
//        exercicio03(sc);
//        exercicio04(sc);
//        exercicio05(sc);
        exercicio06(sc);
    }

    public static void exercicio01(Scanner sc){
        int valor01, valor02, resultado;

        System.out.println("Valor 01:");
        valor01 = sc.nextInt();
        sc.nextLine();
        System.out.println("Valor 02:");
        valor02 = sc.nextInt();
        sc.nextLine();
        resultado = valor01 + valor02;
        System.out.printf("SOMA = %d", resultado);
    }

    public static void exercicio02(Scanner sc){
        double raioCirculo, area, pi;
        System.out.println("Escreva o valor do raio do círculo:");
        raioCirculo = sc.nextDouble();
        pi = 3.14159;
        area = pi * Math.pow(raioCirculo, 2);
        System.out.printf("A=%.4f", area);
    }

    public static void exercicio03(Scanner sc){
        int a,b,c,d, diferenca;
        System.out.println("Digite o valor de a: ");
        a = sc.nextInt();
        System.out.println("Digite o valor de b: ");
        b = sc.nextInt();
        System.out.println("Digite o valor de c: ");
        c = sc.nextInt();
        System.out.println("Digite o valor de d: ");
        d = sc.nextInt();
        diferenca = a*b - c*d;
        System.out.printf("DIFERENCA = %d", diferenca);
    }

    public static void exercicio04(Scanner sc){
        int numFuncionario, horasTrabalhadas;
        double valorHora, salario;
        System.out.println("Digite o número do funcionário: ");
        numFuncionario = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite a quantidade de horas que foram trabalhadas: ");
        horasTrabalhadas = sc.nextInt();
        sc.nextLine();
        System.out.println("Digite o valor por hora trabalhada: ");
        valorHora = sc.nextDouble();
        salario = horasTrabalhadas * valorHora;
        System.out.println("NUMBER = " + numFuncionario);
        System.out.printf("SALARIO = U$ %.2f", salario);
    }

    public static void exercicio05(Scanner sc){
        int codigo01, numeroPecas01;
        int codigo02, numeroPecas02;
        double valorUnitario01, valorUnitario02, totalPagamento;
        System.out.println("Código peça 01: ");
        codigo01 = sc.nextInt();
        System.out.println("Quantidade de peças: ");
        numeroPecas01 = sc.nextInt();
        System.out.println("Valor unitário: ");
        valorUnitario01 = sc.nextDouble();

        System.out.println("Código peça 02: ");
        codigo02 = sc.nextInt();
        System.out.println("Quantidade de peças: ");
        numeroPecas02 = sc.nextInt();
        System.out.println("Valor unitário: ");
        valorUnitario02 = sc.nextDouble();

        totalPagamento = valorUnitario01 * numeroPecas01 + valorUnitario02 * numeroPecas02;
        System.out.printf("VALOR A PAGAR: R$ %.2f", totalPagamento);
    }

    public static void exercicio06(Scanner sc){
        double a, b, c, triangulo, circulo, trapezio, quadrado, retangulo;
        System.out.println("Digite o valor dos lados: ");
        a = sc.nextDouble();
        b = sc.nextDouble();
        c = sc.nextDouble();
        triangulo = a * c / 2;
        circulo = Math.pow(c, 2) * 3.14159;
        trapezio = ((a + b) * c) / 2;
        quadrado = b * b;
        retangulo = a * b;
        System.out.printf("TRIANGULO: %.3f%n", triangulo);
        System.out.printf("CIRCULO: %.3f%n", circulo);
        System.out.printf("TRAPEZIO: %.3f%n", trapezio);
        System.out.printf("QUADRADO: %.3f%n", quadrado);
        System.out.printf("RETANGULO: %.3f%n", retangulo);
    }
}