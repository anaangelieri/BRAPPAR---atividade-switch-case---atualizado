package fontes2.Imagens4;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Thread24q extends Thread {
    
    private int larguraInicial;
    private int larguraFinal;
    private int alturaInicial;
    private int alturaFinal;
    BufferedImage imagem;
    
    
    public Thread24q(BufferedImage imagem){
        
        this.imagem = imagem;
        
        int altura = this.imagem.getHeight();
        int largura = this.imagem.getWidth();

        this.larguraInicial = largura/2;
        this.larguraFinal = largura ;
        this.alturaInicial = 0;
        this.alturaFinal = altura/2;
        
    }
    
    
    public void run(){
        
        
        for (int x = larguraInicial; x<this.larguraFinal; x++){
            for (int y = this.alturaInicial; y<this.alturaFinal; y++){
                Color pixel = new Color(this.imagem.getRGB(x, y));
                
                int corPixel = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                
                this.imagem.setRGB(x, y, new Color(corPixel, corPixel, corPixel).getRGB());
               // System.out.println("Passando T2");
            }
        }
        
        try {
            ImageIO.write(this.imagem, "JPG", new File("imgGrayscale.jpg"));
            System.out.println("Escrevendo T2");
        } catch (IOException ex) {
            Logger.getLogger(Thread14q.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
            
    }
}
