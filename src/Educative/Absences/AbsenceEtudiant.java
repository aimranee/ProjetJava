package Educative.Absences;

public class AbsenceEtudiant extends Absences{
    private String etudiantId;
    private String halakaId;

    public String getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(String etudiantId) {
        this.etudiantId = etudiantId;
    }

    public String getHalakaId() {
        return halakaId;
    }

    public void setHalakaId(String halakaId) {
        this.halakaId = halakaId;
    }

    public AbsenceEtudiant(String dateAbsence, String description, String etudiantId, String halakaId) {
        super(dateAbsence, description);
        this.etudiantId = etudiantId;
        this.halakaId = halakaId;
    }

    public AbsenceEtudiant(int id, String dateAbsence, String description, String etudiantId, String halakaId) {
        super(id, dateAbsence, description);
        this.etudiantId = etudiantId;
        this.halakaId = halakaId;
    }
}
