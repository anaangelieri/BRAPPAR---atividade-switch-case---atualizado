package fontes2.Imagens4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Thread44q extends Thread {
    
    private int larguraInicial;
    private int larguraFinal;
    private int alturaInicial;
    private int alturaFinal;
    BufferedImage imagem;
    
    
    public Thread44q(BufferedImage imagem){
        
        this.imagem = imagem;
        
        int altura = this.imagem.getHeight();
        int largura = this.imagem.getWidth();

        this.larguraInicial = largura/2;
        this.larguraFinal = largura ;
        this.alturaInicial = altura/2;
        this.alturaFinal = altura;
        
    }
    
    
    public void run(){
        
        
        for (int x = larguraInicial; x<this.larguraFinal; x++){
            for (int y = this.alturaInicial; y<this.alturaFinal; y++){
                Color pixel = new Color(this.imagem.getRGB(x, y));
                
                int corPixel = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                
                this.imagem.setRGB(x, y, new Color(corPixel, corPixel, corPixel).getRGB());
             //   System.out.println("passando T4");
            }
        }
        
        try {
        	System.out.println("Escrevendo T4");
            ImageIO.write(this.imagem, "JPG", new File("imgGrayscale.jpg"));
        } catch (IOException ex) {
            Logger.getLogger(Thread14q.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
    }
}
