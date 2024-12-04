package Service;
import Repository.OlimpiadeRepository;
import Entity.Olimpiade;
import java.util.List;

public class OlimpiadeService {
    OlimpiadeRepository olympicsRepository = new OlimpiadeRepository();

    public void create(int anno, String paeseOspitante) {
        Olimpiade oOlimpiade = new Olimpiade();
        oOlimpiade.setAnno(anno);
        oOlimpiade.setPaeseOspitante(paeseOspitante);
        olympicsRepository.createOlimpiade(oOlimpiade);
    }


    public List<Olimpiade> read(){
        return olympicsRepository.readOlimpiade();
    }


    public void delete(int id) {
        Olimpiade oOlimpiade = new Olimpiade();
        oOlimpiade.setId(id);
        olympicsRepository.deleteOlimpiade(oOlimpiade);
    }

    public void update(int id, int anno, String paeseOspitante) {
        Olimpiade oOlimpiade = new Olimpiade();
        oOlimpiade.setId(id);
        oOlimpiade.setPaeseOspitante(paeseOspitante);
        oOlimpiade.setAnno(anno);
        olympicsRepository.updateOlimpiade(oOlimpiade);
    }
}
