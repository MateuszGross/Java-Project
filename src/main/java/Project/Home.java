package Project;

import java.util.ArrayList;

public class Home {

    private MySqlConnection database;

    /*public Home() {
        this.database = new MySqlConnection();

        printFilms();
        printClients();
        printClientList();
        printFilmList();
    }*/


    //musimy dopisać logikę do funkcji agregujących ale to po utworzeniu bazy
    public void printFilms() {
        ArrayList<Film> list = database.getFilms();
    }

    /*public void printClients() {
        ArrayList<Client> list = database.getClients();
    }*/

    /*public void printClientList() {
        ArrayList<Client> list = database.getClients();
    }*/

    public void printFilmList() {
        ArrayList<Film> list = database.getFilms();
    }
}