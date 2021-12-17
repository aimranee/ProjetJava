package Administrative.Etudiant;

public class Resultat {
    private int id;
    private String commentaire;
    private int noteAbsnce;
    private int noteQuran;
    private int noteMouton;
    private int noteGeneral;
    private int etudiantid;

    public Resultat(String commentaire, int noteAbsnce, int noteQuran, int noteMouton, int noteGeneral, int etudiantid) {
        this.commentaire = commentaire;
        this.noteAbsnce = noteAbsnce;
        this.noteQuran = noteQuran;
        this.noteMouton = noteMouton;
        this.noteGeneral = noteGeneral;
        this.etudiantid = etudiantid;
    }

    public Resultat(int id, String commentaire, int noteAbsnce, int noteQuran, int noteMouton, int noteGeneral, int etudiantid) {
        this.id = id;
        this.commentaire = commentaire;
        this.noteAbsnce = noteAbsnce;
        this.noteQuran = noteQuran;
        this.noteMouton = noteMouton;
        this.noteGeneral = noteGeneral;
        this.etudiantid = etudiantid;
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

    public int getNoteAbsnce() {
        return noteAbsnce;
    }

    public void setNoteAbsnce(int noteAbsnce) {
        this.noteAbsnce = noteAbsnce;
    }

    public int getNoteQuran() {
        return noteQuran;
    }

    public void setNoteQuran(int noteQuran) {
        this.noteQuran = noteQuran;
    }

    public int getNoteMouton() {
        return noteMouton;
    }

    public void setNoteMouton(int noteMouton) {
        this.noteMouton = noteMouton;
    }

    public int getNoteGeneral() {
        return noteGeneral;
    }

    public void setNoteGeneral(int noteGeneral) {
        this.noteGeneral = noteGeneral;
    }

    public int getEtudiantid() {
        return etudiantid;
    }

    public void setEtudiantid(int etudiantid) {
        this.etudiantid = etudiantid;
    }
}
