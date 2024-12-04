package Service;
import Repository.AtletaRepository;
import Entity.Atleta;

import java.time.LocalDate;
import java.util.List;

public class AtletaService {
    AtletaRepository atletaRepository = new AtletaRepository();

    public void create(String nome, String cognome, int altezza, LocalDate dataNascita, String nazionalità) {
        Atleta oAtleta = new Atleta();
        oAtleta.setCognome(cognome);
        oAtleta.setNome(nome);
        oAtleta.setAltezza(altezza);
        oAtleta.setDataNascita(dataNascita);
        oAtleta.setNazionalità(nazionalità);
        atletaRepository.createAtleta(oAtleta);
    }


    public List<Atleta> read(){
        return atletaRepository.readAtleta();
    }


    public void delete(int id) {
        Atleta oAtleta = new Atleta();
        oAtleta.setId(id);
        atletaRepository.deleteAtleta(oAtleta);
    }

    public void update(int id, String nome, String cognome, String nazionalità, int altezza, LocalDate dataNascita) {
        Atleta oAtleta = new Atleta();
        oAtleta.setNome(nome);
        oAtleta.setCognome(cognome);
        oAtleta.setDataNascita(dataNascita);
        oAtleta.setNazionalità(nazionalità);
        oAtleta.setAltezza(altezza);
        oAtleta.setId(id);
        atletaRepository.updateAtleta(oAtleta);
    }
}
