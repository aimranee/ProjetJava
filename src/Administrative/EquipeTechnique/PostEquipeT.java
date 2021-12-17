package Administrative.EquipeTechnique;

public class PostEquipeT {
    private int id;
    private String libelle;

    public PostEquipeT(int id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }

    public PostEquipeT(String libelle) {
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
