package Educative.Matiers;

public class Conferences {
    private int id;
    private String dateConf;

    public Conferences(int id, String dateConf) {
        this.id = id;
        this.dateConf = dateConf;
    }

    public Conferences(String dateConf) {
        this.dateConf = dateConf;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateConf() {
        return dateConf;
    }

    public void setDateConf(String dateConf) {
        this.dateConf = dateConf;
    }
}
