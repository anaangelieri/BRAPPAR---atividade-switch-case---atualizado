package fontes2;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Random;
import java.util.Scanner;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import fontes2.Matrizes.Matriz;

import fontes2.Imagens4.Thread14q;
import fontes2.Imagens4.Thread24q;
import fontes2.Imagens4.Thread34q;
import fontes2.Imagens4.Thread44q;

import fontes2.Imagens8.Thread1;
import fontes2.Imagens8.Thread2;
import fontes2.Imagens8.Thread3;
import fontes2.Imagens8.Thread4;
import fontes2.Imagens8.Thread5;
import fontes2.Imagens8.Thread6;
import fontes2.Imagens8.Thread7;
import fontes2.Imagens8.Thread8;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar e multiplicar matrizes");
            System.out.println("2 - Transformar imagens coloridas em preto e branco utilizando a estratégia de divisão quatro quadrantes");
            System.out.println("3 - Tranformar imagens coloridas em preto e branco utilizando a estratégia de divisão de oito quadrantes");
            System.out.println("4 - Transformar imagens coloridas em preto e branco utilizando a estratégia de divisão de tiras verticais");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    criarEMultiplicarMatrizes();
                    break;
                case 2:
                    transformarEmPretoEBrancoQuatroQuadrantes();
                    break;
                case 3:
                    transformarEmPretoEBrancoOitoQuadrantes();
                    break;
                case 4:
                    transformarEmPretoEBrancoTirasVerticais();
                    break;
                default:
                    System.out.println("Opção inválida");
            }
        }
    }

    // 1 - Criar e multiplicar matrizes
    public static void criarEMultiplicarMatrizes() {
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

        Matriz[] threads = new Matriz[size];
        for (int i = 0; i < size; i++) {
            threads[i] = new Matriz(matriz1, matriz2, resultado, i);
            threads[i].start();
        }

        for (Matriz thread : threads) {
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

    // 2 - Transformar imagens coloridas em preto e branco utilizando a estratégia de divisão quatro quadrantes
    public static void transformarEmPretoEBrancoQuatroQuadrantes() {
    try {
        BufferedImage original = ImageIO.read(new File("BRAPPAR - Atividade Matriz/Matriz/src/fontes2/Imagens8/batman.png"));

        // constroi threads
        Thread14q thread1 = new Thread14q(original);
        Thread24q thread2 = new Thread24q(original);
        Thread34q thread3 = new Thread34q(original);
        Thread44q thread4 = new Thread44q(original);

        // executa a thread
        System.out.println("Inicio = " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute()
                + ":" + LocalTime.now().getSecond());

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        System.out.println("Fim = " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute()
                + ":" + LocalTime.now().getSecond());

    } catch (IOException e) {
        System.out.println("Não leu a imagem");
    }
}

    // 3 - Tranformar imagens coloridas em preto e branco utilizando a estratégia de divisão de oito quadrantes
    public static void transformarEmPretoEBrancoOitoQuadrantes() {
        try {
            BufferedImage original = ImageIO.read(new File("BRAPPAR - Atividade Matriz/Matriz/src/fontes2/Imagens8/batman.png"));            
    
            // Cria e inicia as threads para cada quadrante
            Thread1 thread1 = new Thread1(original);
            Thread2 thread2 = new Thread2(original);
            Thread3 thread3 = new Thread3(original);
            Thread4 thread4 = new Thread4(original);
            Thread5 thread5 = new Thread5(original);
            Thread6 thread6 = new Thread6(original);
            Thread7 thread7 = new Thread7(original);
            Thread8 thread8 = new Thread8(original);
    
            // Inicia as threads
            System.out.println("Início = " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute()
                    + ":" + LocalTime.now().getSecond());
    
            thread1.start();
            thread2.start();
            thread3.start();
            thread4.start();
            thread5.start();
            thread6.start();
            thread7.start();
            thread8.start();
    
            System.out.println("Fim = " + LocalTime.now().getHour() + ":" + LocalTime.now().getMinute()
                + ":" + LocalTime.now().getSecond());
        } catch (IOException e) {
            System.out.println("Não leu a imagem");
        }
    }

    // 4 - Transformar imagens coloridas em preto e branco utilizando a estratégia de divisão de tiras verticais
    public static void transformarEmPretoEBrancoTirasVerticais() {
        // Coloque aqui o código para transformar imagens coloridas em preto e branco utilizando a estratégia de divisão de tiras verticais
    }
}


