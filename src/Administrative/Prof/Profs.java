package Administrative.Prof;

public class Profs {
    private int id;
    private String nom;
    private String prenom;
    private String username;

    public Profs(int id, String nom, String prenom,String username) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
    }

    public Profs(String nom, String prenom,String username) {
        this.nom = nom;
        this.prenom = prenom;
        this.username = username;
    }

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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
}
