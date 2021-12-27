package Administrative.Etudiant;

public class Etudiants {
    private int id;
    private String nom;
    private String prenom;
    private int halakaId;
//    private int halakaMoutonId;

    public Etudiants(int id, String nom, String prenom, int halakaId) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.halakaId = halakaId;
//        this.halakaMoutonId = halakaMoutonId;
    }

    public Etudiants(String nom, String prenom, int halakaId) {
        this.nom = nom;
        this.prenom = prenom;
        this.halakaId = halakaId;
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

    public int getHalakaId() {
        return halakaId;
    }

    public void setHalakaId(int halakaId) {
        this.halakaId = halakaId;
    }

	@Override
	public String toString() {
		return "Etudiants [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", halakaId=" + halakaId + "]";
	}


}
