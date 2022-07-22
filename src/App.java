import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        List<String> urlS = new ArrayList<>();
        urlS.add("https://api.mocki.io/v2/549a5d8b");
        urlS.add(
                "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/NASA-APOD-JamesWebbSpaceTelescope.json");

        // conexão HTTP e busca de conteúdo...
        var http = new ClienteHttp();
        // get class to generate a new image...
        String json = http.buscaDados(urlS.get(0));
        ExtratorDeConteudo extrator = new ExtratorDeConteudoLivre_modelOne();
        // ExtratorDeConteudo extrator = new ExtratorDeConteudoLivre_modelTwo();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradoraDeFigurinhas = new GeradoraDeFigurinhas();

        // exibir e manipular os dados
        for (int i = 0; i < conteudos.size(); i++) {
            Conteudo conteudo = conteudos.get(i);

            // make sticker
            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            geradoraDeFigurinhas.cria(inputStream, "img/output/" + conteudo.getId() + ".png");

            // print out information content
            System.out.println("\u001b[4m" + conteudo.getTitulo() + "\u001b[0m");
            System.out.println("\u001b[38;5;226m\u001b[48;5;53m Classificação: " + conteudo.getRating() + " \u001b[0m");
            System.out.println(conteudo.getComicRating());
            System.out.println();
        }
    }
}
