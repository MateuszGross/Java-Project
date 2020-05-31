package Project;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;

public class Home {

    private MySqlConnection database;

    public Home() {
        this.database = new MySqlConnection();

        printFilms();
        printClients();
        printClientList();
        printFilmList();
    }


    //musimy dopisać logikę do funkcji agregujących ale to po utworzeniu bazy
    public void printFilms() {
        ArrayList<Film> list = database.getFilms();
    }

    public void printClients() {
        ArrayList<Client> list = database.getClients();
    }

    public void printClientList() {
        ArrayList<Client> list = database.getClients();
    }

    public void printFilmList() {
        ArrayList<Film> list = database.getFilms();
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vhs?serverTimezone=UTC","root","baza123");//(url bazy, login , haslo);
        System.out.println("Connected");
        Statement st = con.createStatement();
        ResultSet myRs = st.executeQuery("Select * from klient");

        while(myRs.next()) {
            System.out.println(myRs.getString(myRs.getInt("idKlient"))+"," +myRs.getString("Imie") + "," + myRs.getString("Nazwisko")+ "," + myRs.getString("nrTelefonu")+ "," + myRs.getString("nrDowodu"));
        }
    }
}
