package Project;

import java.sql.*;

public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vhs?serverTimezone=UTC", "root", "baza123");//(url bazy, login , haslo);
        //Statement st = con.createStatement();
        //wypisywanie użytkowników do poprawienia
        MySqlConnection connectionGetUsers = new MySqlConnection(con);
        connectionGetUsers.getFilmsVoid();
        //ResultSet myRs = st.executeQuery("Select * from klient");
        /*String query = " insert into klient (Imie, Nazwisko, nrTelefonu, nrDowodu)"
                + " values (?, ?, ?, ?)";*/

        /*while (myRs.next()) {
            System.out.println(
                            myRs.getString("Imie") + ","
                            + myRs.getString("Nazwisko") + ","
                            + myRs.getString("nrTelefonu") + ","
                            + myRs.getString("nrDowodu"));
        }*/

        //dodawanie użytkownika do bazy
        //MySqlConnection connectionAddUser = new MySqlConnection(con);
        //connectionAddUser.addClient("Bard","Drab","123000999","XCD567831");

        //dodawanie filmu do bazy
        //MySqlConnection connectionAddFilm = new MySqlConnection(con);
        //connectionAddFilm.addNewMovie(1,"Kiler","Komedia");

        //stare dodawanie uzytkownika
        /*PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, "Jan");
        pstmt.setString(2, "Kowalski");
        pstmt.setString(3, "777444000");
        pstmt.setString(4, "ABC495831");
        pstmt.execute();*/

        //MySqlConnection connectionDeleteUserByID = new MySqlConnection(con);
        //connectionDeleteUserByID.deleteClient(con,"3");
    }
}

