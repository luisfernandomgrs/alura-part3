import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoIMDB {
  public List<Conteudo> extraiConteudos(String json) {
    // extrair dados de interesse (titulo, poster, classificação)
    var parser = new JsonParser();
    List<Map<String, String>> listaDeAtributos = parser.parse(json);
    List<Conteudo> conteudos = new ArrayList<>();

    String id, titleFilm, urlImagem;

    // popular a lista de conteudo
    for (Map<String, String> atributos : listaDeAtributos) {
      id = atributos.get("id");
      titleFilm = atributos.get("title");
      urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg");
      var conteudo = new Conteudo(id, titleFilm, "", urlImagem);

      conteudos.add(conteudo);
    }

    return conteudos;
  }
}
