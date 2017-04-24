package pl.edu.agh.soa.lab3.model;

public class Film {

    private String title;
    private String genre;
    private int year;
    private int income;

    public Film(String title, String genre, int year, int income) {
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.income = income;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }
}
