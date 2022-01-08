package Educative.Absences;

import java.io.Serializable;

public class Absences implements Serializable {
    private int id;
    private String dateAbsence;
    private String description;

    public Absences(String dateAbsence, String description) {
        this.dateAbsence = dateAbsence;
        this.description = description;
    }

    public Absences(int id, String dateAbsence, String description) {
        this.id = id;
        this.dateAbsence = dateAbsence;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateAbsence() {
        return dateAbsence;
    }

    public void setDateAbsence(String dateAbsence) {
        this.dateAbsence = dateAbsence;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
