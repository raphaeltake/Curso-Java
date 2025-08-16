package Application;

/*
Fazer um programa para ler dois números inteiros M e N, e depois ler
uma matriz de M linhas por N colunas contendo números inteiros,
podendo haver repetições. Em seguida, ler um número inteiro X que
pertence à matriz. Para cada ocorrência de X, mostrar os valores à
esquerda, acima, à direita e abaixo de X, quando houver, conforme
exemplo.
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, n, x;

        System.out.print("Digite a quantidade de linhas da matriz: ");
        m = sc.nextInt();
        System.out.print("Digite a quantidade de colunas da matriz: ");
        n = sc.nextInt();

        int[][] matriz = new int[m][n];
        addData(matriz, sc);

        System.out.printf("%nDigite um número: ");
        x = sc.nextInt();
        verifiChosenOccurrence(matriz, x);
    }

    public static void addData(int[][] matriz, Scanner sc){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.printf("Linha %d | Coluna %d: ", i, j);
                matriz[i][j] = sc.nextInt();
            }
        }
    }

    public static void verifiChosenOccurrence(int[][] matriz, int x){
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                if (matriz[i][j] == x){
                    System.out.printf("%nPosition %d, %d%n", i, j);
                    if (j > 0){
                        System.out.println("Left: " + matriz[i][j - 1]);
                    }
                    if (i > 0){
                        System.out.println("Up: " + matriz[i - 1][j]);
                    }
                    if (j < matriz.length - 1){
                        System.out.println("Right: " + matriz[i][j + 1]);
                    }
                    if (i < matriz.length - 1){
                        System.out.println("Down: " + matriz[i + 1][j]);
                    }
                }
            }
        }
    }

}