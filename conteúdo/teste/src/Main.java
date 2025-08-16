import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        umaDasPrimeiraAulasAI();
        aula26EntradaDeDados();

    }
    public static void umaDasPrimeiraAulasAI(){
        double x = 10.35784;
        System.out.println(x);
        System.out.printf("%.2f%n",x);
        System.out.printf("%.4f%n",x);
        Locale.setDefault(Locale.US);
        System.out.printf("%.4f%n",x);
        System.out.printf("Resultado = %.2f metros %n", x);
    }

    public static void aula26EntradaDeDados(){
        Scanner sc = new Scanner(System.in);
        String x;
        System.out.println("Digite algo:");
//        x = sc.next();
//        System.out.println("Você digitou: " + x);

        sc.close();
    }
}