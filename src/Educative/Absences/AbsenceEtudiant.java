package Educative.Absences;

public class AbsenceEtudiant extends Absences{
    private int etudiantId;

    public AbsenceEtudiant(String dateAbsence, String description, int etudiantId) {
        super(dateAbsence, description);
        this.etudiantId = etudiantId;
    }

    public AbsenceEtudiant(int id, String dateAbsence, String description, int etudiantId) {
        super(id, dateAbsence, description);
        this.etudiantId = etudiantId;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }
}
