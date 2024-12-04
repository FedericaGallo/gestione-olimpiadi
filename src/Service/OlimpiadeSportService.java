package Service;
import Repository.OlimpiadeSportRepository;
import Entity.OlimpiadeSport;
import Entity.Olimpiade;
import Entity.Sport;
import Repository.SportRepository;
import Repository.OlimpiadeRepository;
import java.util.List;

public class OlimpiadeSportService {
    OlimpiadeSportRepository oOlimpiadeSportRepository = new OlimpiadeSportRepository();
    SportRepository oSportRepository = new SportRepository();
    OlimpiadeRepository oOlimpiadeRepository = new OlimpiadeRepository();

    public void create(int idOlimpiade, int idSport) {
        OlimpiadeSport oOlimpiadeSport = new OlimpiadeSport();
        Olimpiade oOlimpiade = oOlimpiadeRepository.readOlimpiadeByID(idOlimpiade);
        Sport oSport =  oSportRepository.readSportByID(idOlimpiade);
        oOlimpiadeSport.setOlimpiade(oOlimpiade);
        oOlimpiadeSport.setSport(oSport);
        oOlimpiadeSportRepository.createOlimpiadeSport(oOlimpiadeSport);
    }


    public List<OlimpiadeSport> read(){
        return oOlimpiadeSportRepository.readOlimpiadeSport();
    }


    public void delete(int id) {
        OlimpiadeSport oOlympiadeSport = new OlimpiadeSport();
        oOlympiadeSport.setId(id);
        oOlimpiadeSportRepository.deleteOlimpiadeSport(oOlympiadeSport);
    }

    public void update(int id, int idSport , int idOlimpiade) {
        OlimpiadeSport oOlimpiadeSport = new OlimpiadeSport();
        oOlimpiadeSport.setId(id);
        Olimpiade oOlimpiade = oOlimpiadeRepository.readOlimpiadeByID(idOlimpiade);
        Sport oSport =  oSportRepository.readSportByID(idOlimpiade);
        oOlimpiadeSport.setSport(oSport);
        oOlimpiadeSport.setOlimpiade(oOlimpiade);
        oOlimpiadeSportRepository.updateOlimpiadeSport(oOlimpiadeSport);
    }
}
