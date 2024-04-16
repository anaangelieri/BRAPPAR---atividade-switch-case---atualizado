package fontes2.Matrizes;

public class Matriz extends Thread {
    private int[][] matriz1;
    private int[][] matriz2;
    private int[][] resultado;
    private int linha;

    public Matriz(int[][] matriz1, int[][] matriz2, int[][] resultado, int linha) {
        this.matriz1 = matriz1;
        this.matriz2 = matriz2;
        this.resultado = resultado;
        this.linha = linha;
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

