package Administrative.Etudiant;

public class Resultat {
    private int id;
    private String commentaire;
    private String noteAbsnce;
    private String noteQuran;
    private String noteMouton;
    private String noteGeneral;
    private String etudiantId;

    public Resultat(String commentaire, String noteAbsnce, String noteQuran, String noteMouton, String noteGeneral, String etudiantId) {
        this.commentaire = commentaire;
        this.noteAbsnce = noteAbsnce;
        this.noteQuran = noteQuran;
        this.noteMouton = noteMouton;
        this.noteGeneral = noteGeneral;
        this.etudiantId = etudiantId;
    }

    public Resultat(int id, String commentaire, String noteAbsnce, String noteQuran, String noteMouton, String noteGeneral, String etudiantId) {
        this.id = id;
        this.commentaire = commentaire;
        this.noteAbsnce = noteAbsnce;
        this.noteQuran = noteQuran;
        this.noteMouton = noteMouton;
        this.noteGeneral = noteGeneral;
        this.etudiantId = etudiantId;
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

    public String getNoteAbsnce() {
        return noteAbsnce;
    }

    public void setNoteAbsnce(String noteAbsnce) {
        this.noteAbsnce = noteAbsnce;
    }

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
}
