package Educative.Matiers;

class Halaka {
    private int id;
    private String dateHalaka;
    private String description;
    private int etudiantId;

    public Halaka(String dateHalaka, String description, int etudiantId) {
        this.dateHalaka = dateHalaka;
        this.description = description;
        this.etudiantId = etudiantId;
    }

    public Halaka(int id, String dateHalaka, String description, int etudiantId) {
        this.id = id;
        this.dateHalaka = dateHalaka;
        this.description = description;
        this.etudiantId = etudiantId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateHalaka() {
        return dateHalaka;
    }

    public void setDateHalaka(String dateHalaka) {
        this.dateHalaka = dateHalaka;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }
}
