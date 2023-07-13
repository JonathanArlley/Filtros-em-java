package pdi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class Main {
    public static void main(String[] args) throws IOException {



            File arquivo = new File("C:/Users/Jonat/Desktop/Imagens Pdi/Lena 512 003.png");
            BufferedImage imagemOriginal = ImageIO.read(arquivo);

            BufferedImage imgSaida = ProcessarImagem.media(imagemOriginal);

            /*ProcessarImagem filtro = new ProcessarImagem("C:/Users/Jonat/Desktop/Imagens Pdi/tulips origi.png");
            Scanner teclado = new Scanner(System.in);*/

            /*System.out.println("1- Banda Vermelha ");
            System.out.println("2- Banda Verde ");
            System.out.println("3- Banda Azul ");
            System.out.println("4- Band/a Cinza Medio ");
            System.out.println("5- Banda Cinza Derivado ");
            System.out.println("6- Limiarização ");
            System.out.println("7- Aumento de tonalidade ");
            System.out.println("8- Brilho aditivo ");
            System.out.println("9- Brilho Multiplicativo");
            System.out.println("10- Negativo ");
            System.out.println("11- Imagem Original ");
            System.out.println("12- Cinza Verde  ");
            System.out.println("13- Cinza Azul ");
            System.out.println(" Digite uma opção: ");
            int numero = teclado.nextInt();

            switch (numero) {
                case 1: {
                    System.out.println("Banda Vermelha");
                    filtro.bandaVermelho("C:/Users/Jonat/Desktop/Imagens Pdi/bandaVermelha.png");
                    break;
                }
                case 2: {
                    System.out.println("Banda Verde");
                    filtro.bandaVerde("C:/Users/Jonat/Desktop/Imagens Pdi/bandaVerde .png");
                    break;
                }
                case 3: {
                    System.out.println("Banda Azul");
                    filtro.bandaAzul("C:/Users/Jonat/Desktop/Imagens Pdi/bandaAzul .png");
                    break;
                }
                case 4: {
                    System.out.println("Banda Cinza Médio");
                    filtro.cinzaMedio("C:/Users/Jonat/Desktop/Imagens Pdi/cinzaMedio.png");
                    break;
                }
                case 5: {
                    System.out.println("Banda Cinza Derivado");
                    filtro.cinzaDerivado("C:/Users/Jonat/Desktop/Imagens Pdi/CinzaDerivado .png", "Vermelho");
                    break;
                }

                case 6: {
                    System.out.println("Limiarização");
                    filtro.limiarizacao("C:/Users/Jonat/Desktop/Imagens Pdi Limiarização.png", 255);
                    break;
                }
                case 7: {
                    System.out.println("Aumento de Tonalidade");
                    filtro.subirTom("C:/Users/Jonat/Desktop/Imagens Pdi/AumentoTonalidadeVermeleho.png", "Vermelho", 255);
                    filtro.subirTom("C:/Users/Jonat/Desktop/Imagens Pdi/AumentoTonalidadeVerde .png", "Verde", 180);
                    filtro.subirTom("C:/Users/Jonat/Desktop/Imagens Pdi/AumentoTonalidadeAzul .png", "Azul", 128);
                    break;
                }
                case 8: {
                    System.out.println("Brilho Aditivo");
                    filtro.brilhoAditivo("C:/Users/Jonat/Desktop/Imagens Pdi/BrilhoAditivo.png", 200);
                    break;
                }
                case 9: {
                    System.out.println("Brilho Multiplicativo");
                    filtro.brilhoMultiplicativo("C:/Users/Jonat/Desktop/Imagens Pdi/BrilhoMultiplicativo.png", 198);
                    break;
                }


                case 10: {
                    System.out.println("Negativo");
                    filtro.negativo("C:/Users/Jonat/Desktop/Imagens Pdi/Negativo.png");
                    break;
                }

                case 11: {
                    System.out.println("Imagem Original");
                    filtro.imagemOrigi("C:/Users/Jonat/Desktop/Imagens Pdi/ImagemOrigi.png");
                    break;
                }

            
            case 12: {
                System.out.println("Banda Cinza Derivado");
                filtro.cinzaDerivado("C:/Users/Jonat/Desktop/Imagens Pdi/CinzaVerde .png", "Verde");
                break;
            }
            case 13: {
                System.out.println("Banda Cinza Derivado");
                filtro.cinzaDerivado("C:/Users/Jonat/Desktop/Imagens Pdi/CinzaAzul .png", "Azul");
                break;
            }

        }*/
            double [][] gaussian = new  double [3][3];
            gaussian[0][0] = 0.0625;
            gaussian[1][0] = 0.125;
            gaussian[2][0] = 0.625;
            gaussian[0][1] = 0.125;
            gaussian[1][1] = 0.25;
            gaussian[2][1] = 0.125;
            gaussian[0][2] = 0.0625;
            gaussian[1][2] = 0.125;
            gaussian[2][2] = 0.0625;

           // BufferedImage img  = new BufferedImage(img,gaussian);

            if (ImageIO.write(imgSaida, "jpg", new File ("C:/Users/Jonat/Desktop/Imagens Pdi/Lena 512 003.png") )){
                    System.out.println("Imagem salva com sucesso");
            }
            else {
                    System.out.println("Erro ao salvar a imagem");
            }



    }
}
