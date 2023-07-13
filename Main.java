package pdi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;


public class Main {
    public static void main(String[] args) throws IOException {



            File arquivo = new File();
            BufferedImage imagemOriginal = ImageIO.read(arquivo);

            BufferedImage imgSaida = ProcessarImagem.media(imagemOriginal);

            ProcessarImagem filtro = new ProcessarImagem();
            Scanner teclado = new Scanner(System.in);*/

            System.out.println("1- Banda Vermelha ");
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
            System.out.println(" Digite uma opção: ");
            int numero = teclado.nextInt();

            switch (numero) {
                case 1: {
                    System.out.println("Banda Vermelha");
                    filtro.bandaVermelho();
                    break;
                }
                case 2: {
                    System.out.println("Banda Verde");
                    filtro.bandaVerde();
                    break;
                }
                case 3: {
                    System.out.println("Banda Azul");
                    filtro.bandaAzul();
                    break;
                }
                case 4: {
                    System.out.println("Banda Cinza Médio");
                    filtro.cinzaMedio();
                    break;
                }
                case 5: {
                    System.out.println("Banda Cinza Derivado");
                    filtro.cinzaDerivado();
                    break;
                }

                case 6: {
                    System.out.println("Limiarização");
                    filtro.limiarizacao();
                    break;
                }
                case 7: {
                    System.out.println("Aumento de Tonalidade");
                    filtro.subirTom();
                    filtro.subirTom();
                    filtro.subirTom();
                    break;
                }
                case 8: {
                    System.out.println("Brilho Aditivo");
                    filtro.brilhoAditivo();
                    break;
                }
                case 9: {
                    System.out.println("Brilho Multiplicativo");
                    filtro.brilhoMultiplicativo();
                    break;
                }


                case 10: {
                    System.out.println("Negativo");
                    filtro.negativo();
                    break;
                }

                case 11: {
                    System.out.println("Imagem Original");
                    filtro.imagemOrigi();
                    break;
                }

            
            case 12: {
                System.out.println("Banda Cinza Derivado");
                filtro.cinzaDerivado();
                break;
            }
            case 13: {
                System.out.println("Banda Cinza Derivado");
                filtro.cinzaDerivado();
                break;
            }

        }
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

            if (ImageIO.write(imgSaida, "jpg", new File () )){
                    System.out.println("Imagem salva com sucesso");
            }
            else {
                    System.out.println("Erro ao salvar a imagem");
            }



    }
}
