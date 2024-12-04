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

    public String getSportNome() {
        return sport.getNome();
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public int getOlimpiadeId() {
        return olimpiade.getId();
    }

    public int getOlimpiadeAnno() {
        return olimpiade.getAnno();
    }

    public String getOlimpiadePaeseOspitante() {
        return olimpiade.getPaeseOspitante();
    }
    public void setOlimpiade(Olimpiade olimpiade) {
        this.olimpiade = olimpiade;
    }
}

