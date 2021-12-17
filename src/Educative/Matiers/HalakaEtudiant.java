package Educative.Matiers;

public class HalakaEtudiant {
    private int etudiantId;
    private int halakaId;

    public HalakaEtudiant(int etudiantId, int halakaId) {
        this.etudiantId = etudiantId;
        this.halakaId = halakaId;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    public int getHalakaId() {
        return halakaId;
    }

    public void setHalakaId(int halakaId) {
        this.halakaId = halakaId;
    }
}
