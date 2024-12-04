package Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Config.DbConnection;
import Entity.Sport;

public class SportRepository {
    public void createSport(Sport oSport) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO Sport VALUES('" + oSport.getNome() + "','" + oSport.getNumeroGiocatori() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public Sport readSportByID(int id){
        Sport oSport = new Sport();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Sport WHERE id = " + id);
            while (rs.next()) {

                oSport.setNome(rs.getString("name"));
                oSport.setNumeroGiocatori(rs.getInt("player_number"));
                oSport.setId(rs.getInt("id"));

            }

        }catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return oSport;
    }

    public ArrayList<Sport> readSport () {
        ArrayList<Sport> listaSport = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Sport ORDER BY id asc");
            while (rs.next()) {
                Sport oSport = new Sport();
                oSport.setNome(rs.getString("name"));
                oSport.setNumeroGiocatori(rs.getInt("player_number"));
                oSport.setId(rs.getInt("id"));
                listaSport.add(oSport);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaSport;
    }
    public void deleteSport(Sport oSport) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM Sport WHERE id = '" + oSport.getId() + "'");
            System.out.println("model.dao.Sport eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateSport(Sport oSport) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE Sport SET name='"+oSport.getNome()+"', player_number='"+oSport.getNumeroGiocatori()+"' WHERE id ="  + oSport.getId());
            System.out.println("model.dao.Sport aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
