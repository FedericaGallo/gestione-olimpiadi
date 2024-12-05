package Repository;
import Config.DbConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Entity.Atleta;
import java.time.LocalDate;

public class AtletaRepository {
    public void createAtleta(Atleta oAthlete) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("INSERT INTO Athlete VALUES('" + oAthlete.getNome() + "','" + oAthlete.getCognome() + "','" + oAthlete.getDataNascita() + "','" + oAthlete.getAltezza() + "','" + oAthlete.getNazionalità() + "')");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public Atleta readAtletaByID(int id){
        Atleta oAthlete = new Atleta();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Athlete WHERE id = " + id);
            while (rs.next()) {

                oAthlete.setNome(rs.getString("first_name"));
                oAthlete.setCognome(rs.getString("last_name"));
                oAthlete.setId(rs.getInt("id"));
                oAthlete.setDataNascita(rs.getDate("birth_date").toLocalDate());
                oAthlete.setAltezza(rs.getInt("height"));
                oAthlete.setNazionalità(rs.getString("nationality"));


            }

        }catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return oAthlete;
    }

    public ArrayList<Atleta> readAtleta () {
        ArrayList<Atleta> listaDocenti = new ArrayList<>();
        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Athlete ORDER BY id asc");
            while (rs.next()) {
                Atleta oAthlete = new Atleta();
                oAthlete.setNome(rs.getString("first_name"));
                oAthlete.setCognome(rs.getString("last_name"));
                oAthlete.setId(rs.getInt("id"));
                oAthlete.setDataNascita(rs.getDate("birth_date").toLocalDate());
                oAthlete.setAltezza(rs.getInt("height"));
                oAthlete.setNazionalità(rs.getString("nationality"));
                listaDocenti.add(oAthlete);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
        return listaDocenti;
    }
    public void deleteAtleta(Atleta oAtleta) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("DELETE FROM Athlete WHERE id = '" + oAtleta.getId() + "'");
            System.out.println("model.dao.Athlete eliminato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }

    public void updateAtleta(Atleta oAtleta) {

        try {
            Connection c = DbConnection.openConnection();
            //System.out.println("Connessione riuscita!");
            Statement stmt = c.createStatement();
            stmt.execute("UPDATE Athlete SET first_name='"+oAtleta.getNome()+"', last_name='"+oAtleta.getCognome()+"', birth_date='"+oAtleta.getDataNascita()+"', height= '"+oAtleta.getAltezza()+"' , nationality='"+oAtleta.getNazionalità()+"' WHERE id ="  + oAtleta.getId());
            System.out.println("model.dao.Athlete aggiornato");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e.getMessage());
            System.exit(0);
        }
    }
}
