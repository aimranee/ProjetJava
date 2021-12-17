package Educative.Absences;

public class AbsenceProf extends Absences{
    private int profId;

    public AbsenceProf(int id, String dateAbsence, String description, int profId) {
        super(id, dateAbsence, description);
        this.profId = profId;
    }

    public AbsenceProf(String dateAbsence, String description, int profId) {
        super(dateAbsence, description);
        this.profId = profId;
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int profId) {
        this.profId = profId;
    }
}
