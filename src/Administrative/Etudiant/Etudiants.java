package Administrative.Etudiant;

public class Etudiants {
    private int id;
    private String nom;
    private String prenom;
    private int halakaQuranId;
    private int halakaMoutonId;

    public Etudiants(int id, String nom, String prenom, int halakaQuranId, int halakaMoutonId) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.halakaQuranId = halakaQuranId;
        this.halakaMoutonId = halakaMoutonId;
    }

    public Etudiants(String nom, String prenom, int halakaQuranId) {
        this.nom = nom;
        this.prenom = prenom;
        this.halakaQuranId = halakaQuranId;
    }

    public Etudiants(String nom, String prenom, int halakaQuranId, int halakaMoutonId) {
        this.nom = nom;
        this.prenom = prenom;
        this.halakaQuranId = halakaQuranId;
        this.halakaMoutonId = halakaMoutonId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getHalakaQuranId() {
        return halakaQuranId;
    }

    public void setHalakaQuranId(int halakaQuranId) {
        this.halakaQuranId = halakaQuranId;
    }

    public int getHalakaMoutonId() {
        return halakaMoutonId;
    }

    public void setHalakaMoutonId(int halakaMoutonId) {
        this.halakaMoutonId = halakaMoutonId;
    }
}
