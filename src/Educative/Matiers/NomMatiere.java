package Educative.Matiers;

public class NomMatiere {
    private int id;
    private String libelle;

    public NomMatiere(String libelle) {
        this.libelle = libelle;
    }

    public NomMatiere(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

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
}
