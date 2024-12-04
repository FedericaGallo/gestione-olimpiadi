package Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Config.DbConnection;
import Entity.OlimpiadeSport;
import Entity.Olimpiade;
import Entity.Sport;

public class OlimpiadeSportRepository {
    public void createOlimpiadeSport(OlimpiadeSport oOlimpiadeSport) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO OlympicsSport VALUES('" + oOlimpiadeSport.getOlimpiadeId() + "','" + oOlimpiadeSport.getSportId() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public OlimpiadeSport readOlimpiadeSportById(int id){
        OlimpiadeSport oOlimpiadeSport = new OlimpiadeSport();
        OlimpiadeRepository olimpiadeRepository = new OlimpiadeRepository();
        SportRepository sportRepository = new SportRepository();

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OlympicsSport WHERE id = " + id);
            while (rs.next()) {

                oOlimpiadeSport.setId(rs.getInt("id"));
                Olimpiade oOlimpiade =olimpiadeRepository.readOlimpiadeByID(rs.getInt("id_olympics"));
                Sport oSport = sportRepository.readSportByID(rs.getInt("id_sport"));
                oOlimpiadeSport.setOlimpiade(oOlimpiade);
                oOlimpiadeSport.setSport(oSport);

            }

        }catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return oOlimpiadeSport;
    }

    public ArrayList<OlimpiadeSport> readOlimpiadeSport () {
        ArrayList<OlimpiadeSport> listaOlimpiadeSport = new ArrayList<>();

        OlimpiadeRepository olimpiadeRepository = new OlimpiadeRepository();
        SportRepository sportRepository = new SportRepository();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM OlympicsSport ORDER BY id asc");
            while (rs.next()) {
                OlimpiadeSport oOlimpiadeSport = new OlimpiadeSport();
                oOlimpiadeSport.setId(rs.getInt("id"));
                Olimpiade oOlimpiade =olimpiadeRepository.readOlimpiadeByID(rs.getInt("id_olympics"));
                Sport oSport = sportRepository.readSportByID(rs.getInt("id_sport"));
                oOlimpiadeSport.setOlimpiade(oOlimpiade);
                oOlimpiadeSport.setSport(oSport);
                listaOlimpiadeSport.add(oOlimpiadeSport);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaOlimpiadeSport;
    }
    public void deleteOlimpiadeSport(OlimpiadeSport oOlympicsSport) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM OlympicsSport WHERE id = '" + oOlympicsSport.getId() + "'");
            System.out.println("model.dao.OlympicsSport eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateOlimpiadeSport(OlimpiadeSport oOlympicsSport) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE OlympicsSport SET id_olympics='"+oOlympicsSport.getOlimpiadeId()+"', id_sport='"+oOlympicsSport.getSportId()+"' WHERE id ="  + oOlympicsSport.getId());
            System.out.println("model.dao.OlympicsSport aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
