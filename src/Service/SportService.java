package Service;
import Repository.SportRepository;
import Entity.Sport;
import java.util.List;

public class SportService {
    SportRepository sportRepository = new SportRepository();

    public void create(String nome, int numeroGiocatori) {
        Sport oSport = new Sport();
        oSport.setNome(nome);
        oSport.setNumeroGiocatori(numeroGiocatori);
        sportRepository.createSport(oSport);
    }


    public List<Sport> readSport(){
        return sportRepository.readSport();
    }


    public void delete(int id) {
        Sport oSport = new Sport();
        oSport.setId(id);
        sportRepository.deleteSport(oSport);
    }

    public void update(int id, String nome, int numeroGiocatori) {
        Sport oSport = new Sport();
        oSport.setNome(nome);
        oSport.setNumeroGiocatori(numeroGiocatori);
        oSport.setId(id);
        sportRepository.updateSport(oSport);
    }
}
