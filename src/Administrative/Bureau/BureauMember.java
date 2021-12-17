package Administrative.Bureau;

public class BureauMember {
    private int id;
    private String nom;
    private String prenom;
    private int postB_id;

    public BureauMember(String nom, String prenom, int postB_id) {
        this.nom = nom;
        this.prenom = prenom;
        this.postB_id = postB_id;
    }

    public BureauMember(int id, String nom, String prenom, int postB_id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.postB_id = postB_id;
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

    public int getPostB_id() {
        return postB_id;
    }

    public void setPostB_id(int postB_id) {
        this.postB_id = postB_id;
    }
}
