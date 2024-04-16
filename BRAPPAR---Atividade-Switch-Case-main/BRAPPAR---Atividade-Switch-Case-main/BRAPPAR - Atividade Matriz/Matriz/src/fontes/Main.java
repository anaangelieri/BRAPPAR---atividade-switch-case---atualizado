// Ana Laura Angelieri BP3038262
// Évelin Ferreira da Silva BP3039447

package fontes;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {

            System.out.print("Digite o tamanho da matriz: ");
            int size = scanner.nextInt();

            int[][] matriz1 = new int[size][size];
            int[][] matriz2 = new int[size][size];
            int[][] resultado = new int[size][size];

            Random rand = new Random();
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    matriz1[i][j] = rand.nextInt(10);
                    matriz2[i][j] = rand.nextInt(10);
                }
            }

            System.out.println("Matriz 1:");
            imprimirMatriz(matriz1);

            System.out.println("\nMatriz 2:");
            imprimirMatriz(matriz2);

            Thread1[] threads = new Thread1[size];
            for (int i = 0; i < size; i++) {
                threads[i] = new Thread1(matriz1, matriz2, resultado, i);
                threads[i].start();
            }

            for (Thread1 thread : threads) {
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("\nMatriz multiplicada:");
            imprimirMatriz(resultado);
        }
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }
    }
}

