package fontes;

import java.awt.image.BufferedImage;

public class Thread1 extends Thread {
    private int[][] matriz1;
    private int[][] matriz2;
    private int[][] resultado;
    private int linha;

    public Thread1(int[][] matriz1, int[][] matriz2, int[][] resultado, int linha) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.resultado = resultado;
        this.linha = linha;
    }

    public Thread1(BufferedImage original) {
        //TODO Auto-generated constructor stub
    }

    @Override
    public void run() {
        for (int i = 0; i < matriz2[0].length; i++) {
            int soma = 0;
            for (int j = 0; j < matriz1[0].length; j++) {
                soma += matriz1[linha][j] * matriz2[j][i];
            }
            resultado[linha][i] = soma;
        }
    }
}
