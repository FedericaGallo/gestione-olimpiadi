package Repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Config.DbConnection;
import Entity.Olimpiade;

public class OlimpiadeRepository {
    public void createOlimpiade(Olimpiade oOlimpiade) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO Olympics VALUES('" + oOlimpiade.getAnno() + "','" + oOlimpiade.getPaeseOspitante() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public Olimpiade readOlimpiadeByID(int id){
        Olimpiade oOlympics = new Olimpiade();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Olympics WHERE id = " + id);
            while (rs.next()) {

                oOlympics.setPaeseOspitante(rs.getString("host_country"));
                oOlympics.setAnno(rs.getInt("year"));
                oOlympics.setId(rs.getInt("id"));

            }

        }catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return oOlympics;
    }

    public ArrayList<Olimpiade> readOlimpiade () {
        ArrayList<Olimpiade> listaDocenti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Olympics ORDER BY id asc");
            while (rs.next()) {
                Olimpiade oOlimpiade = new Olimpiade();
                oOlimpiade.setAnno(rs.getInt("year"));
                oOlimpiade.setPaeseOspitante(rs.getString("host_country"));
                oOlimpiade.setId(rs.getInt("id"));
                listaDocenti.add(oOlimpiade);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDocenti;
    }
    public void deleteOlimpiade(Olimpiade oOlimpiade) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM Olympics WHERE id = '" + oOlimpiade.getId() + "'");
            System.out.println("model.dao.Olympics eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateOlimpiade(Olimpiade oOlimpiade) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE Olympics SET year='"+oOlimpiade.getAnno()+"', host_country='"+oOlimpiade.getPaeseOspitante()+"' WHERE id ="  + oOlimpiade.getId());
            System.out.println("model.dao.Olympics aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
