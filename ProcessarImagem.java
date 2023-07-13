package pdi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ProcessarImagem {

    private static BufferedImage image ;


    public ProcessarImagem(String Arquivo) throws IOException {// Pega o caminho para salvar a imagem
        this.image = ImageIO.read(new File(Arquivo));
    }

    public ProcessarImagem(BufferedImage img, double[][] gaussian) {
    }

    private void salvarImagem(String Salvar) throws IOException {//salva a imagem
        ImageIO.write(image, "JPG", new File(Salvar));
    }

    private int somaTomComLimiteMinMax(int valorBandaAtual, int valorAumentoBanda){//brilho max soma
        if(valorBandaAtual+valorAumentoBanda > 255){
            return 255;
        }else if(valorBandaAtual+valorAumentoBanda < 0){
            return 0;
        }else{
            return valorBandaAtual+valorAumentoBanda;
        }
    }

    private int multiplicacaoComLimiteMinMax(int valorBandaAtual, double valorAumentoBanda){
        if(valorBandaAtual*valorAumentoBanda > 255){
            return 255;
        }else if(valorBandaAtual*valorAumentoBanda < 0){
            return 0;
        }else{
            return (int) (valorBandaAtual*valorAumentoBanda);
        }
    }

    public void bandaAzul(String Salvar) throws IOException {
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);
                Color azul = new Color(0, 0,cor.getBlue());
                image.setRGB(altura,largura,azul.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }

    public void bandaVerde(String Salvar) throws IOException {
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);
                Color verde = new Color(0, cor.getGreen(),0);
                image.setRGB(altura,largura,verde.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }

    public void bandaVermelho(String Salvar) throws IOException {
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);
                Color vermelho = new Color(cor.getRed(), 0,0);
                image.setRGB(altura,largura,vermelho.getRGB());
            }
        }
        this.salvarImagem(Salvar);

    }

    public void imagemOrigi(String Salvar) throws IOException {
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);
                Color origi = new Color(cor.getRed(),cor.getGreen(),0);
                image.setRGB(altura,largura,origi.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }


    public void cinzaMedio(String Salvar) throws IOException {
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){

                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);
                int somaCores = cor.getRed() + cor.getGreen() + cor.getBlue();
                int media = somaCores/3;
                Color cinzaMedio = new Color(media, media,media);
                image.setRGB(altura,largura,cinzaMedio.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }

    public void cinzaDerivado(String Salvar, String banda) throws  IOException{
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);
                int valor = 0;
                if(banda == "Vermelho"){
                    valor = cor.getRed();
                }else if(banda == "Verde"){
                    valor = cor.getGreen();
                }else if(banda == "Azul"){
                    valor = cor.getGreen();
                }else{
                    throw new IllegalArgumentException("Insira um valor igual a Vermelho, Azul ou Verde");
                }
                Color newCor = new Color(valor, valor,valor);
                image.setRGB(altura,largura,newCor.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }

    public void subirTom(String Salvar, String banda, int valorSubirTom)throws  IOException{
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);

                int red = banda == "Vermelho"? somaTomComLimiteMinMax(cor.getRed(), valorSubirTom) : cor.getRed();
                int green = banda == "Verde"? somaTomComLimiteMinMax(cor.getGreen(), valorSubirTom) : cor.getGreen();
                int blue = banda == "Azul"? somaTomComLimiteMinMax(cor.getBlue(), valorSubirTom) : cor.getBlue();

                Color newCor = new Color(red, green, blue);
                image.setRGB(altura,largura,newCor.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }

    public void negativo(String Salvar)throws  IOException{
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);

                int red = 255 - cor.getRed();
                int green = 255 - cor.getGreen();
                int blue = 255 - cor.getBlue();

                Color neg = new Color(red, green, blue);
                image.setRGB(altura,largura,neg.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }

    //limiar 128
    public void limiarizacao(String Salvar, int limiar) throws IOException {
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);
                int somaCores = (cor.getRed() + cor.getGreen() + cor.getBlue()) / 3 ;


                Color newCor = new Color(0, 0,0);
                if(somaCores > limiar){
                    newCor = new Color(255, 255,255);
                }
                image.setRGB(altura,largura,newCor.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }

    public void brilhoAditivo(String Salvar, int valorSubirBrilho)throws  IOException{
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight() ;altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);

                int red = somaTomComLimiteMinMax(cor.getRed(), valorSubirBrilho);
                int green = somaTomComLimiteMinMax(cor.getGreen(), valorSubirBrilho);
                int blue = somaTomComLimiteMinMax(cor.getBlue(), valorSubirBrilho);

                Color newCor = new Color(red, green,blue);
                image.setRGB(altura,largura,newCor.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }

    public void brilhoMultiplicativo(String Salvar, double valorMultiplicarBrilho)throws  IOException{
        int altura;
        int largura;
        for(altura = 0; altura< image.getHeight(); altura++){
            for(largura = 0; largura< image.getWidth(); largura++){
                int rgbInt = image.getRGB(altura,largura);
                Color cor =  new Color(rgbInt);

                int red = multiplicacaoComLimiteMinMax(cor.getRed(), valorMultiplicarBrilho);
                int green = multiplicacaoComLimiteMinMax(cor.getGreen(), valorMultiplicarBrilho);
                int blue = multiplicacaoComLimiteMinMax(cor.getBlue(), valorMultiplicarBrilho);

                Color newCor = new Color(red, green,blue);
                image.setRGB(altura,largura,newCor.getRGB());
            }
        }
        this.salvarImagem(Salvar);
    }



     public static BufferedImage media(BufferedImage imagemEntrada) {
         BufferedImage imagemSaida = image.getSubimage(0, 0, image.getWidth(), image.getHeight());
         int[] valoresVizinhanca = new int[9];

         for (int i = 1; i < imagemEntrada.getHeight() - 1; i++) {
             for (int j = 1; j < imagemEntrada.getWidth() - 1; j++) {
                 int aux = -1;
                 for (int x = j - 1; x <= j + 1; x++) {
                     for (int y = i - 1; y <= i + 1; y++) {
                         valoresVizinhanca[++aux] = new Color(imagemEntrada.getRGB(x, y)).getRed();

                     }
                 }
                 int media = Arrays.stream(valoresVizinhanca).sum() / 9;
                 int[] arrayOrdenado = Arrays.stream(valoresVizinhanca).sorted().toArray();
                 int mediana = arrayOrdenado[arrayOrdenado.length / 2];
                 Color novaCor = new Color(media, media, media);
                 imagemSaida.setRGB(j, i, novaCor.getRGB());
             }
         }


         return imagemSaida;
     }
}