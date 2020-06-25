package Project;

public class Film {
    private int idFilm;
    private String Tytul;
    private String Gatunek;

    public Film(int idFilm, String tytul, String gatunek) {
        {
            this.idFilm = idFilm;
            this.Tytul = tytul;
            this.Gatunek = gatunek;
        }
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getTytul() {
        return Tytul;
    }

    public void setTytul(String tytul) {
        this.Tytul = tytul;
    }

    public String getGatunek() {
        return Gatunek;
    }

    public void setGatunek(String gatunek) {
        this.Gatunek = gatunek;
    }

    @Override
    public String toString() {
        return "Film{" +
                "idFilm=" + idFilm +
                ", Tytul='" + Tytul + '\'' +
                ", Gatunek='" + Gatunek + '\'' +
                '}';
    }
}

