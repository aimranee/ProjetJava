package Educative.Programmes;

public class Programmes {
    private int id;
    private String annee;
    private String Titre;

    public Programmes(String annee, String titre) {
        this.annee = annee;
        Titre = titre;
    }

    public Programmes(int id, String annee, String titre) {
        this.id = id;
        this.annee = annee;
        Titre = titre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }
}
