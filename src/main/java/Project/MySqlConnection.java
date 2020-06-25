package Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class MySqlConnection {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public MySqlConnection(Connection con) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.con = con;
            st = con.createStatement();

        }
        catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public void getFilmsVoid() {
        ArrayList<Film> FilmsList = new ArrayList<>();

        try {
            String query = "select * from film";
            rs = st.executeQuery(query);
            Film Film;
            while (rs.next()) {
                Film = new Film(
                        rs.getInt("idFilm"),
                        rs.getString("Tytul"),
                        rs.getString("Gatunek")
                );
                FilmsList.add(Film);
            }
        }
        catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        System.out.println(FilmsList);
    }

    public ArrayList<Film> getFilms() {
        ArrayList<Film> FilmsList = new ArrayList<>();

        try {
            String query = "select * from film";
            rs = st.executeQuery(query);
            Film Film;
            while (rs.next()) {
                Film = new Film(
                        rs.getInt("idFilm"),
                        rs.getString("Tytul"),
                        rs.getString("Gatunek")
                );
                FilmsList.add(Film);
            }
        }
        catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        return FilmsList;
    }

    public int addNewMovie(int idFilm , String Tytul, String Gatunek)
    {
        PreparedStatement pstmt = null;
        try{
            pstmt = con.prepareStatement("insert into film (idFilm, Tytul, Gatunek) VALUES(?,?,?)");
            pstmt.setInt(1, idFilm);
            pstmt.setString(2, Tytul);
            pstmt.setString(3, Gatunek);

            pstmt.execute();

        }
        catch(Exception ex){
            System.out.println("Error:"+ ex);
        }
        System.out.println("Film zostal dodany do bazy");
        return 1;
    }

    public int addNewMovieRental(int idFilmu , Date DataWypozyczenia, int IdKlienta, int LiczbaDni, Date DataZwrotu)
    {
        PreparedStatement pstmt = null;
        try{
            pstmt = con.prepareStatement("insert into wypozyczenia (idFilmu, DataWypozyczenia, IdKlienta, LiczbaDni, DataZwrotu) VALUES(?,?,?,?,?)");
            pstmt.setInt(1, idFilmu);
            pstmt.setDate(2, (java.sql.Date) DataWypozyczenia);
            pstmt.setInt(3, IdKlienta);
            pstmt.setInt(4, LiczbaDni);
            pstmt.setDate(5, (java.sql.Date) DataZwrotu);
        }
        catch(Exception ex){
            System.out.println("Error:"+ ex);
        }
        return 1;
    }

    public void getClientsVoid() {
        ArrayList<Client> clientsList = new ArrayList<>();
        try {
            String query = "select * from klient";
            rs = st.executeQuery(query);
            Client client;
            while (rs.next()) {
                client = new Client(
                        rs.getInt("idKlient"),
                        rs.getString("Imie"),
                        rs.getString("Nazwisko"),
                        rs.getString("NrTelefonu"),
                        rs.getString("NrDowodu")
                );
                clientsList.add(client);
            }
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        System.out.println(clientsList);
    }

    public ArrayList<Client> getClients() {
        ArrayList<Client> clientsList = new ArrayList<>();
        try {
            String query = "select * from klient";
            rs = st.executeQuery(query);
            Client client;
            while (rs.next()) {
                client = new Client(
                        rs.getInt("idKlient"),
                        rs.getString("Imie"),
                        rs.getString("Nazwisko"),
                        rs.getString("NrTelefonu"),
                        rs.getString("NrDowodu")
                );
                clientsList.add(client);
            }
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        return clientsList;
    }

    public void addClient(String imie, String nazwisko, String NrTelefonu, String NrDowodu) {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("insert into klient (imie, nazwisko, NrTelefonu, NrDowodu) VALUES(?,?,?,?)");
            pstmt.setString(1, imie);
            pstmt.setString(2, nazwisko);
            pstmt.setString(3, NrTelefonu);
            pstmt.setString(4, NrDowodu);

            pstmt.execute();
        }
        catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
    }

    public void deleteClient(String id) {
        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("DELETE FROM klient WHERE idKlient = ?");
            pstmt.setString(1, id);
            pstmt.execute();
        }
        catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
    }

    public int checkDateAvailability(String startDate, String endDate, String FilmId) {
        //PreparedStatement pstmt = null;
        //dopisać logike
        return 0;
    }

    public Long calculateDaysFromDate(String inputString1,String inputString2)
    {
        SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

        long outputDays = 0;
        try {
            Date date1 = myFormat.parse(inputString1);
            Date date2 = myFormat.parse(inputString2);
            long diff = date2.getTime() - date1.getTime();
            outputDays = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return outputDays;
    }

    /*public int addNewMovieRental(String beginDate,String expireDate,String FilmId,String clientId)
    {
        PreparedStatement pstmt = null;
        try{
            pstmt = con.prepareStatement("insert into MovieRental (client_id, Film_id, date_from, date_to, price) VALUES(?,?,?,?,?)");
            pstmt.setString(1,clientId);
            pstmt.setString(2,FilmId);
            pstmt.setString(3,beginDate);
            pstmt.setString(4,expireDate);
        }
        catch(Exception ex){
            System.out.println("Error:"+ ex);
        }
        return 1;
    }*/

    public ArrayList<MovieRental> getMovieRental() {
        ArrayList<MovieRental> MovieRentalsList = new ArrayList<>();

        try{
            String query = "select * from MovieRental";
            rs = st.executeQuery(query);
            MovieRental MovieRental;
            while(rs.next()){
                MovieRental = new MovieRental(
                        rs.getInt("id"),
                        rs.getInt("client_id"),
                        rs.getInt("Film_id"),
                        rs.getString("date_from"),
                        rs.getString("date_to"),
                        rs.getFloat("price")
                );
                MovieRentalsList.add(MovieRental);
            }
        }
        catch(Exception ex){
            System.out.println("Error:"+ ex);
        }

        return MovieRentalsList;
    }

}

