package Administrative.Bureau;

public class ReunionBureau {
    private int id;
    private String descripton;
    private String dateReunion;

    public ReunionBureau(String descripton, String dateReunion) {
        this.descripton = descripton;
    }

    public ReunionBureau(int id, String descripton, String dateReunion) {
        this.id = id;
        this.descripton = descripton;
        this.dateReunion = dateReunion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripton() {
        return descripton;
    }

    public void setDescripton(String descripton) {
        this.descripton = descripton;
    }

    public String getDate() {
        return dateReunion;
    }

    public void setDate(String dateReunion) {
        this.dateReunion = dateReunion;
    }
}
