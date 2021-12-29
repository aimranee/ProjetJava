package Educative.Presences;

public class PresenceEtudiant {
    private int id;
    private String dateSeance;
    private String description;
    private int note;
    private int etudiant_id;
    private int halaka_id;

    public PresenceEtudiant(String dateSeance, String description, int note, int etudiant_id, int halaka_id) {
        this.dateSeance = dateSeance;
        this.description = description;
        this.note = note;
        this.etudiant_id = etudiant_id;
        this.halaka_id = halaka_id;
    }

    public PresenceEtudiant(int id, String dateSeance, String description, int note, int etudiant_id, int halaka_id) {
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

    public int getNote() { return note; }

    public void setNote(int note) { this.note = note; }

    public int getEtudiant_id() {
        return etudiant_id;
    }

    public void setEtudiant_id(int etudiant_id) {
        this.etudiant_id = etudiant_id;
    }

    public int getHalaka_id() {
        return halaka_id;
    }

    public void setHalaka_id(int halaka_id) {
        this.halaka_id = halaka_id;
    }
}
