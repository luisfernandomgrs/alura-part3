public record Conteudo(
    String id,
    String titulo,
    String rating,
    String urlImagem) {

  public Conteudo(String id, String titulo, String rating, String urlImagem) {
    this.id = id;
    this.titulo = titulo;
    this.rating = rating;
    this.urlImagem = urlImagem;
  }

  public String getComicRating() {
    String comicRating = "";
    int iStars;

    for (iStars = 0; iStars < Double.valueOf(this.rating).intValue(); iStars++) {
      comicRating += "\u2B50\u001b[m";
    }

    if (this.rating.indexOf(".") > 0) {
      if (Integer.valueOf(this.rating.substring(this.rating.indexOf(".") + 1, this.rating.length())) > 0) {
        comicRating += " \u272E\u001b[m";
        iStars++;
      }
      for (; iStars < 10; iStars++) {
        comicRating += " \u2730\u001b[m";
      }
    }

    return comicRating;
  }
}