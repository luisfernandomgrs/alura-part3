import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {
  public void cria(InputStream inputStream, String fileName) throws Exception {
    // leitura da imagem
    // InputStream inputStream = new FileInputStream(new
    // File("img/input/film.jpg"));
    // InputStream inputStream = new
    // URL("https://imersao-java-apis.s3.amazonaws.com/TopMovies_2.jpg").openStream();
    BufferedImage imageOriginal = ImageIO.read(inputStream);

    // cria nova imagem em memória com transparência e com tamanho novo
    int largura = imageOriginal.getWidth();
    int altura = imageOriginal.getHeight();
    int novaAltura = altura + 200;
    String sTitle, sSubTitle;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // copiar a imagem original pra novo imagem (em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imageOriginal, 0, 0, null);

    // configurar a fonte
    var font = new Font(Font.SANS_SERIF, Font.BOLD, 128);
    graphics.setColor(Color.CYAN);
    graphics.setFont(font);

    // define o texto que será usado
    sTitle = "#TOPZERA";
    sSubTitle = "COM ALURA";
    // escrever uma frase na nova imagem... Centrralizando
    graphics.drawString(sTitle,
        (novaImagem.getWidth() / 2) - (graphics.getFontMetrics().stringWidth(sTitle) / 2),
        novaImagem.getHeight() - 100);

    // adicionando textos
    font = new Font(Font.SANS_SERIF, Font.BOLD, 44);
    graphics.setColor(Color.ORANGE);
    graphics.setFont(font);

    // Centrralizando, sub-título
    graphics.drawString(sSubTitle, (novaImagem.getWidth() / 2) - (graphics.getFontMetrics().stringWidth(sSubTitle) / 2),
        novaImagem.getHeight());

    // cria o novo arquivo, incluindo a pasta de destino se não existe
    var fileNewToWrite = new File(fileName);
    fileNewToWrite.mkdirs();

    // escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", fileNewToWrite);
  }
}
