package Service;
import Repository.AtletaRepository;
import Repository.OlimpiadeSportAtletaRepository;
import Entity.OlimpiadeSportAtleta;
import Entity.Atleta;
import Entity.OlimpiadeSport;
import Repository.OlimpiadeSportRepository;

import java.util.List;

public class OlimpiadeSportAtletaService {
    OlimpiadeSportAtletaRepository olympicsSportAthleteRepository = new OlimpiadeSportAtletaRepository();
   AtletaRepository oAtletaRepository = new AtletaRepository();
    OlimpiadeSportRepository oOlimpiadeSportRepository = new OlimpiadeSportRepository();

    public void create(int idAtleta, int idOlimpiadeSport) {
        OlimpiadeSportAtleta oOlympicsSportAthlete = new OlimpiadeSportAtleta();
        Atleta oAtleta = oAtletaRepository.readAtletaByID(idAtleta);
        OlimpiadeSport oOlimpiadeSport = oOlimpiadeSportRepository.readOlimpiadeSportById(idOlimpiadeSport);
        oOlympicsSportAthlete.setAtleta(oAtleta);
        oOlympicsSportAthlete.setOlimpiadeSport(oOlimpiadeSport);
        olympicsSportAthleteRepository.createOlimpiadeSportAtleta(oOlympicsSportAthlete);
    }


    public List<OlimpiadeSportAtleta> read(){
        return olympicsSportAthleteRepository.readOlimpiadeSportAtleta();
    }


    public void delete(int id) {
        OlimpiadeSportAtleta oOlympicsSportAthlete = new OlimpiadeSportAtleta();
        oOlympicsSportAthlete.setId(id);
        olympicsSportAthleteRepository.deleteOlimpiadeSportAtleta(oOlympicsSportAthlete);
    }

    public void update(int id, int idAtleta, int idOlimpiadeSport) {
        OlimpiadeSportAtleta oOlimpiadeSportAtleta = new OlimpiadeSportAtleta();
        oOlimpiadeSportAtleta.setId(id);
        Atleta oAtleta = oAtletaRepository.readAtletaByID(idAtleta);
        OlimpiadeSport oOlimpiadeSport = oOlimpiadeSportRepository.readOlimpiadeSportById(idOlimpiadeSport);
        oOlimpiadeSportAtleta.setAtleta(oAtleta);
        oOlimpiadeSportAtleta.setOlimpiadeSport(oOlimpiadeSport);

        olympicsSportAthleteRepository.updateOlimpiadeSportAtleta(oOlimpiadeSportAtleta);
    }
}
