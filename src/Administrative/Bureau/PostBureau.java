package Administrative.Bureau;

public class PostBureau {
    private int id;
    private String libelle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public PostBureau(String libelle) {
        this.libelle = libelle;
    }

    public PostBureau(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
}
