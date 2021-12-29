package Administrative.Etudiant;

public class Etudiants {
    private int id;
    private String nom;
    private String prenom;
    private String datNaissance;
    private String sexe;
    private String filiere;

    public Etudiants(int id, String nom, String prenom ,String datNaissance, String sexe ,String filiere) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datNaissance = datNaissance;
        this.sexe = sexe;
        this.filiere = filiere;
    }

    public Etudiants(String nom, String prenom, String datNaissance, String sexe ,String filiere) {
        this.nom = nom;
        this.prenom = prenom;
        this.datNaissance = datNaissance;
        this.sexe = sexe;
        this.filiere = filiere;
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

	public String getDatNaissance() {
		return datNaissance;
	}

	public void setDatNaissance(String datNaissance) {
		this.datNaissance = datNaissance;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	@Override
	public String toString() {
		return "Etudiants [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", datNaissance=" + datNaissance
				+ ", sexe=" + sexe + ", filiere=" + filiere + "]";
	}

	


}
