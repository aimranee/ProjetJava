package Educative.Absences;

public class AbsenceBureau extends Absences{
    private int membreBureau;

    public AbsenceBureau(String dateAbsence, String description, int membreBureau) {
        super(dateAbsence, description);
        this.membreBureau = membreBureau;
    }

    public int getMembreBureau() {
        return membreBureau;
    }

    public void setMembreBureau(int membreBureau) {
        this.membreBureau = membreBureau;
    }

    public AbsenceBureau(int id, String dateAbsence, String description, int membreBureau) {
        super(id, dateAbsence, description);
        this.membreBureau = membreBureau;
    }
}
