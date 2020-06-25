package Project;

public class Client {

    private int idKlient;
    private String imie;
    private String nazwisko;
    private String NrTelefonu;
    private String NrDowodu;

    public Client(int idKlient, String imie, String nazwisko, String NrTelefonu, String NrDowodu) {
        this.idKlient = idKlient;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.NrTelefonu = NrTelefonu;
        this.NrDowodu = NrDowodu;
    }

    public int getIdKlient() {
        return idKlient;
    }

    public void setIdKlient(int idKlient) {
        this.idKlient = idKlient;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNrTelefonu() {
        return NrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.NrTelefonu = nrTelefonu;
    }

    public String getNrDowodu() {
        return NrDowodu;
    }

    public void setNrDowodu(String nrDowodu) {
        this.NrDowodu = nrDowodu;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idKlient=" + idKlient +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", NrTelefonu='" + NrTelefonu + '\'' +
                ", NrDowodu='" + NrDowodu + '\'' +
                '}';
    }
}
