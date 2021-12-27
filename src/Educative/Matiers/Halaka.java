package Educative.Matiers;

class Halaka {
    private int id;
    private String description;
    private int profId;

    public Halaka( String description, int profId) {
        this.description = description;
        this.profId = profId;
    }

    public Halaka(int id,  String description, int etudiantId) {
        this.id = id;
        this.description = description;
        this.profId = etudiantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProfId() {
        return profId;
    }

    public void setProfId(int etudiantId) {
        this.profId = etudiantId;
    }
}
