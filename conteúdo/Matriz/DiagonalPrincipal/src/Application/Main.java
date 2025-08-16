package Application;

import java.util.Scanner;

/*
Fazer um programa para ler um número inteiro N e uma matriz de
ordem N contendo números inteiros. Em seguida, mostrar a diagonal
principal e a quantidade de valores negativos da matriz.
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite o número de linhas e colunas da matriz quadrada: ");
        int n = sc.nextInt();
        int[][] matriz = new int[n][n];
        int quantityNegatives = addData(sc, matriz);
        showMainDiagonal(matriz);
        System.out.printf("%nNegative numbers = %d", quantityNegatives);
    }

    public static int addData(Scanner sc, int[][] matriz){
        int quantityNegatives = 0;
        for (int i = 0; i < matriz.length; i++){
            for (int j = 0; j < matriz[i].length; j++){
                System.out.printf("Linha %d | Coluna %d: ", i, j);
                matriz[i][j] = sc.nextInt();
                if (matriz[i][j] < 0) quantityNegatives++;
            }
        }
        return quantityNegatives;
    }

    public static void showMainDiagonal(int[][] matriz){
        System.out.printf("%nMain diagonal: %n");
        for (int i = 0; i < matriz.length; i++){
            System.out.print(matriz[i][i] + " ");
        }
    }
}