package Entity;
public class OlimpiadeSport {
    private int id;
    private Sport sport;
    private Olimpiade olimpiade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSportId() {
        return sport.getId();
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public int getOlimpiadeId() {
        return olimpiade.getId();
    }

    public void setOlimpiade(Olimpiade olimpiade) {
        this.olimpiade = olimpiade;
    }
}

