package Project;

public class Film {
    private int id;
    private String title;
    private String author;
    private String category;
    private int yearOfProduction;
   // private String image; //dodajemy obrazek filmu?

    public Film(int id, String title, String author, String category, int yearOfProduction){ //String image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.category = category;
        this.yearOfProduction = yearOfProduction;
        //this.image = image;

    }

    public Film() { //do dodawania nowego filmu
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    /*public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }*/

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }


}
