package Administrative.EquipeTechnique;

public class EquipeTechniqueMember {
    private int id;
    private String nom;
    private String prenom;
    private int postE_id;

    public EquipeTechniqueMember(int id, String nom, String prenom, int postE_id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.postE_id = postE_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPostE_id(int postE_id) {
        this.postE_id = postE_id;
    }

    public EquipeTechniqueMember(String nom, String prenom, int postE_id) {
        this.nom = nom;
        this.prenom = prenom;
        this.postE_id = postE_id;
    }
}
