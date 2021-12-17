package Educative.Programme;

public class Evenement {
    private int id;
    private String libelle;
    private String dateEvenement;
    private int programmeId;

    public Evenement(String libelle, String dateEvenement, int programmeId) {
        this.libelle = libelle;
        this.dateEvenement = dateEvenement;
        this.programmeId = programmeId;
    }

    public Evenement(int id, String libelle, String dateEvenement, int programmeId) {
        this.id = id;
        this.libelle = libelle;
        this.dateEvenement = dateEvenement;
        this.programmeId = programmeId;
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

    public String getDateEvenement() {
        return dateEvenement;
    }

    public void setDateEvenement(String dateEvenement) {
        this.dateEvenement = dateEvenement;
    }

    public int getProgrammeId() {
        return programmeId;
    }

    public void setProgrammeId(int programmeId) {
        this.programmeId = programmeId;
    }
}
