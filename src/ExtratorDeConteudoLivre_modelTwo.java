import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoLivre_modelTwo implements ExtratorDeConteudo {
  public List<Conteudo> extraiConteudos(String json) {
    // extrair dados de interesse (titulo, poster, classificação)
    var parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);
    List<Conteudo> conteudos = new ArrayList<>();

    int id = 0;
    String titleFilm, urlImagem;

    // popular a lista de conteudo
    for (Map<String, String> atributos : listaDeAtributos) {
      id++;
      titleFilm = atributos.get("title");
      // urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
      urlImagem = atributos.get("hdurl").replaceAll("(@+)(.*).jpg$", "$1.jpg");
      var conteudo = new Conteudo(String.valueOf(id), titleFilm, "10", urlImagem);

      conteudos.add(conteudo);
    }

    return conteudos;
  }
}
