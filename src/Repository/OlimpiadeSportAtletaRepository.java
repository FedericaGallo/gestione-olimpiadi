package Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Config.DbConnection;
import Entity.OlimpiadeSportAtleta;
import Entity.Atleta;
import Entity.OlimpiadeSport;

public class OlimpiadeSportAtletaRepository {
    public void createOlimpiadeSportAtleta(OlimpiadeSportAtleta oOlympicsSportAthlete) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO olympics_sport_athlete VALUES('" + oOlympicsSportAthlete.getOlimpiadeSportId() + "', '" + oOlympicsSportAthlete.getAtletaId() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public OlimpiadeSportAtleta readOlimpiadeSportAtletaByID(int id){
        OlimpiadeSportAtleta oOlimpiadeSportAtleta = new OlimpiadeSportAtleta();
        OlimpiadeSportRepository olimpiadeSportRepository = new OlimpiadeSportRepository();
        AtletaRepository atletaRepository = new AtletaRepository();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM olympics_sport_athlete WHERE id = " + id);
            while (rs.next()) {
                OlimpiadeSport olimpiadeSport = olimpiadeSportRepository.readOlimpiadeSportById(rs.getInt("id_olympics_sport"));
                Atleta atleta = atletaRepository.readAtletaByID(rs.getInt("id_athleta"));
                oOlimpiadeSportAtleta.setOlimpiadeSport(olimpiadeSport);
                oOlimpiadeSportAtleta.setAtleta(atleta);
                oOlimpiadeSportAtleta.setId(rs.getInt("id"));

            }

        }catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return  oOlimpiadeSportAtleta;
    }

    public ArrayList<OlimpiadeSportAtleta> readOlimpiadeSportAtleta () {
        ArrayList<OlimpiadeSportAtleta> listaOlimpiadeSportAtleta = new ArrayList<>();
        AtletaRepository atletaRepository = new AtletaRepository();
        OlimpiadeSportRepository olimpiadeSportRepository = new OlimpiadeSportRepository();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM olympics_sport_athlete ORDER BY id asc");
            while (rs.next()) {
                OlimpiadeSportAtleta oOlimpiadeSportAtleta = new OlimpiadeSportAtleta();
                Atleta oAtleta = atletaRepository.readAtletaByID(rs.getInt("id_athlete"));
                oOlimpiadeSportAtleta.setAtleta(oAtleta);
                OlimpiadeSport oOlimpiadeSport = olimpiadeSportRepository.readOlimpiadeSportById(rs.getInt("id_olympics_sport"));
                oOlimpiadeSportAtleta.setOlimpiadeSport(oOlimpiadeSport);
                oOlimpiadeSportAtleta.setResult(rs.getString("result"));
                oOlimpiadeSportAtleta.setId(rs.getInt("id"));
                listaOlimpiadeSportAtleta.add( oOlimpiadeSportAtleta);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaOlimpiadeSportAtleta;
    }
    public void deleteOlimpiadeSportAtleta(OlimpiadeSportAtleta oOlimpiadeSportAtleta) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM olympics_sport_athlete WHERE id = '" + oOlimpiadeSportAtleta.getId() + "'");
            System.out.println("model.dao.OlympicsSportAthlete eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateOlimpiadeSportAtleta(OlimpiadeSportAtleta oOlimpiadeSportAtleta) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE olympics_sport_athlete SET id_olympics_sport= '"+oOlimpiadeSportAtleta.getOlimpiadeSportId()+"', id_athlete='"+oOlimpiadeSportAtleta.getAtletaId()+"',result= '"+oOlimpiadeSportAtleta.getResult()+ "' WHERE id = "  + oOlimpiadeSportAtleta.getId());
            System.out.println("model.dao.OlympicsSportAthlete aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
