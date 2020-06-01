package Project;

import java.sql.*;

public class TestClass {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vhs?serverTimezone=UTC", "root", "baza123");//(url bazy, login , haslo);
        Statement st = con.createStatement();
        // wypisywanie użytkowników do poprawienia
        /*MySqlConnection connectionGetUsers = new MySqlConnection(con);
        connectionGetUsers.getClients(con);*/
        ResultSet myRs = st.executeQuery("Select * from klient");
        String query = " insert into klient (Imie, Nazwisko, nrTelefonu, nrDowodu)"
                + " values (?, ?, ?, ?)";

        while (myRs.next()) {
            System.out.println(
                    myRs.getInt("idKlient") + ","
                            + myRs.getString("Imie") + ","
                            + myRs.getString("Nazwisko") + ","
                            + myRs.getString("nrTelefonu") + ","
                            + myRs.getString("nrDowodu"));
        }

        //dodawanie użytkownika
        MySqlConnection connectionAddUser = new MySqlConnection(con);
        //connectionAddUser.addClient("Bard","Drab","123000999","XCD567831");

        //stare dodawanie uzytkownika
        /*PreparedStatement pstmt = con.prepareStatement(query);
        pstmt.setString(1, "Jan");
        pstmt.setString(2, "Kowalski");
        pstmt.setString(3, "777444000");
        pstmt.setString(4, "ABC495831");
        pstmt.execute();*/

        MySqlConnection connectionDeleteUserByID = new MySqlConnection(con);
        //connectionDeleteUserByID.deleteClient(con,"3");


    }
    //poniżej do usunięcia, działa poprzez klase MySqlConnection
    /*public void deleteClient(Connection con, String id) throws SQLException {
        String deleteUser = "DELETE FROM klient WHERE idKlient = ?";
        PreparedStatement pstmt2 = con.prepareStatement(deleteUser);
        try {
            pstmt2.setString(1, id);
            pstmt2.execute();
        } catch (Exception ex) {
            System.out.println("Error:" + ex);
        }
    }*/
}

