package Educative.Matiers;

public class Matier {
    private int id;
    private String titre;
    private int nomMatier;
//    private int profId;

    public Matier(int id, String titre, int nomMatier) {
        this.id = id;
        this.titre = titre;
        this.nomMatier = nomMatier;
//        this.profId = profId;
    }

    public Matier(String titre, int nomMatier) {
        this.titre = titre;
        this.nomMatier = nomMatier;
//        this.profId = profId;
    }

//    public int getProfId() {
//        return profId;
//    }

//    public void setProfId(int profId) {
//        this.profId = profId;
//    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public int getNomMatier() {
        return nomMatier;
    }

    public void setNomMatier(int nomMatier) {
        this.nomMatier = nomMatier;
    }
}
