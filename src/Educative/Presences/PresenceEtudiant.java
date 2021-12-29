package Educative.Presences;

public class PresenceEtudiant {
    private int id;
    private String dateSeance;
    private String description;
    private String note;
    private String etudiant_id;
    private String halaka_id;

    public PresenceEtudiant(String dateSeance, String description, String note, String etudiant_id, String halaka_id) {
        this.dateSeance = dateSeance;
        this.description = description;
        this.note = note;
        this.etudiant_id = etudiant_id;
        this.halaka_id = halaka_id;
    }

    public PresenceEtudiant(int id, String dateSeance, String description, String note, String etudiant_id, String halaka_id) {
        this.id = id;
        this.dateSeance = dateSeance;
        this.description = description;
        this.note = note;
        this.etudiant_id = etudiant_id;
        this.halaka_id = halaka_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateSeance() {
        return dateSeance;
    }

    public void setDateSeance(String dateSeance) {
        this.dateSeance = dateSeance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() { return note; }

    public void setNote(String note) { this.note = note; }

    public String getEtudiant_id() {
        return etudiant_id;
    }

    public void setEtudiant_id(String etudiant_id) {
        this.etudiant_id = etudiant_id;
    }

    public String getHalaka_id() {
        return halaka_id;
    }

    public void setHalaka_id(String halaka_id) {
        this.halaka_id = halaka_id;
    }
}
