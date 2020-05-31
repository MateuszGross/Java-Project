package Project;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

public class MySqlConnection {

    private Connection con;
    private Statement st;
    private ResultSet rs;

    public MySqlConnection() {
        try {
            //Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc.mysql://localhost:3306/vhs","root","baza123");//(url bazy, login , haslo);
            st = con.createStatement();
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex);
        }
    }

    public ArrayList<Film> getFilms() {
        ArrayList<Film> FilmsList = new ArrayList<>();

        try {
            String query = "select * from Film";
            rs = st.executeQuery(query);
            Film Film;
            while (rs.next()) {
                Film = new Film(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("category"),
                        rs.getInt("year")
                );
                FilmsList.add(Film);
            }
        }
        catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        return FilmsList;
    }

    public ArrayList<Client> getClients() {
        ArrayList<Client> clientsList = new ArrayList<>();

        try {
            String query = "select * from client";
            rs = st.executeQuery(query);
            Client client;
            while (rs.next()) {
                client = new Client(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("address"),
                        rs.getString("phoneNumber")
                );
                clientsList.add(client);
            }
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
        return clientsList;
    }

    public void addClient(String name, String surname, String address, String phone) {

        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("insert into client (name, surname, address, phone_number) VALUES(?,?,?,?)");
            pstmt.setString(1, name);
            pstmt.setString(2, surname);
            pstmt.setString(3, address);
            pstmt.setString(4, phone);
        }
        catch (Exception ex) {
            System.out.println("Error:" + ex);
        }

    }

    public void deleteClient(String id) {

        PreparedStatement pstmt = null;
        try {
            pstmt = con.prepareStatement("DELETE FROM client WHERE id = ?");
            pstmt.setString(1, id);
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

    public int addNewMovieRental(String beginDate,String expireDate,String FilmId,String clientId)
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
    }

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

