package Entity;

public class OlimpiadeSportAtleta {
    private int id;
    private OlimpiadeSport olimpiadeSport;
    private Atleta atleta;
    private String result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOlimpiadeSportId() {
        return olimpiadeSport.getId();
    }

    public String getOlimpiadeSport() {
        return olimpiadeSport.getSportNome();
    }

    public int getOlimpiadeAnno() {
        return olimpiadeSport.getOlimpiadeAnno();
    }

    public String getOlimpiadePaeseOspitante() {
        return olimpiadeSport.getOlimpiadePaeseOspitante();
    }

    public void setOlimpiadeSport(OlimpiadeSport olympicsSport) {
        this.olimpiadeSport = olympicsSport;
    }

    public int getAtletaId() {
        return atleta.getId();
    }

    public String getAtletaNome() {
        return atleta.getNome();
    }

    public String getAtletaCognome() {
        return atleta.getCognome();
    }

    public void setAtleta(Atleta athlete) {
        this.atleta = athlete;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
