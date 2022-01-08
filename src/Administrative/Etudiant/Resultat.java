package Administrative.Etudiant;

import java.io.Serializable;

public class Resultat implements Serializable{
   
	private int id;
    private String etudiantId;
    private String noteQuran;
    private String noteMouton;
    private String noteGeneral;
    private String commentaire;
//    private String noteAbsnce;

   

    public Resultat(int id, String etudiantId, String noteQuran, String noteMouton, String noteGeneral,String commentaire) {
		this.id = id;
		this.etudiantId = etudiantId;
		this.noteQuran = noteQuran;
		this.noteMouton = noteMouton;
		this.noteGeneral = noteGeneral;
		this.commentaire = commentaire;
//		this.noteAbsnce = noteAbsnce;
	}
    

	public Resultat(String etudiantId, String noteQuran, String noteMouton, String noteGeneral, String commentaire) {
		this.etudiantId = etudiantId;
		this.noteQuran = noteQuran;
		this.noteMouton = noteMouton;
		this.noteGeneral = noteGeneral;
		this.commentaire = commentaire;
//		this.noteAbsnce = noteAbsnce;
	}


	public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

//    public String getNoteAbsnce() {
//        return noteAbsnce;
//    }
//
//    public void setNoteAbsnce(String noteAbsnce) {
//        this.noteAbsnce = noteAbsnce;
//    }

    public String getNoteQuran() {
        return noteQuran;
    }

    public void setNoteQuran(String noteQuran) {
        this.noteQuran = noteQuran;
    }

    public String getNoteMouton() {
        return noteMouton;
    }

    public void setNoteMouton(String noteMouton) {
        this.noteMouton = noteMouton;
    }

    public String getNoteGeneral() {
        return noteGeneral;
    }

    public void setNoteGeneral(String noteGeneral) {
        this.noteGeneral = noteGeneral;
    }

    public String getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(String etudiantId) {
        this.etudiantId = etudiantId;
    }

	@Override
	public String toString() {
		return "Resultat [id=" + id + ", etudiantId=" + etudiantId + ", noteQuran=" + noteQuran + ", noteMouton="
				+ noteMouton + ", noteGeneral=" + noteGeneral + ", commentaire=" + commentaire + "]";
	}

	
    
}
