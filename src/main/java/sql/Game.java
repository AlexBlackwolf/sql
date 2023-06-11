package sql;

public class Game {
    private String Name;
    private String Genre;
    private Boolean Goty;
    private Integer Price;
    private String Publisher;

    public Game(String name, String genre, Boolean goty, Integer price, String publisher) {
        Name = name;
        Genre = genre;
        Goty = goty;
        Price = price;
        Publisher = publisher;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public Boolean getGoty() {
        return Goty;
    }

    public void setGoty(Boolean goty) {
        Goty = goty;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    @Override
    public String toString() {
        return "games{" +
                "Name='" + Name + '\'' +
                ", Genre='" + Genre + '\'' +
                ", Goty=" + Goty +
                ", Price=" + Price +
                ", Publisher='" + Publisher + '\'' +
                '}';
    }
}
