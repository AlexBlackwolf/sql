package test1;

import sql.Game;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudenteDAO {
    public void insertStudente (Studente studente ) throws SQLException {
            String quary = "INSERT INTO STUDENTE(id, nome, cognome, eta)  VALUES (?, ?, ?, ?)";
            PreparedStatement statement = ConnectionProvider.getInstance().prepareStatement(quary);
            statement.setInt(1, studente.getId());
            statement.setString(2, studente.getNome());
            statement.setString(3, studente.getCognome());
            statement.setInt(4, studente.getEta());

            statement.executeUpdate();
            statement.close();
        }

    public void insertStudente1(Studente studente) {
        String query = "INSERT INTO studente (id, nome, cognome, eta) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConnectionProvider.getInstance();
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, studente.getId());
            statement.setString(2, studente.getNome());
            statement.setString(3, studente.getCognome());
            statement.setInt(4, studente.getEta());

            statement.executeUpdate();
            System.out.println("Studente inserito con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public Studente retriveStudente(int id) throws SQLException {
        String query = "SELECT ID, NOME, COGNOME, ETA FROM STUDENTE WHERE ID = ?";
        PreparedStatement statement = ConnectionProvider.getInstance().prepareStatement(query);
        statement.setInt(1, id); //sostituisce il primo punto interogativo con il valore intero che gli passo io statemenet.setInt da usare soloc on un punto interogativo
        ResultSet resultSet = statement.executeQuery();//risultato della querry
        if (resultSet.next()) {
            String nome = resultSet.getString("NOME");
            String cognome = resultSet.getString("COGNOME");
            Integer eta = resultSet.getInt("ETA");
            Studente selectedStudente = new Studente(id, nome, cognome, eta);
            System.out.println(selectedStudente);
            return selectedStudente;
        }
        return null;
    }
        public List<Studente> retrieveByNome(String nome) throws SQLException {
            List<Studente> studenti = new ArrayList<>();
            String queryNome = "SELECT * FROM studente WHERE nome  = ?";
            PreparedStatement statement = ConnectionProvider.getInstance().prepareStatement(queryNome); //connessione
            statement.setString(1, nome); //
            ResultSet resultset = statement.executeQuery();
            while (resultset.next()){
                int id = resultset.getInt("ID");
                String cognome = resultset.getString("COGNOME");
                Integer eta = resultset.getInt("ETA");
                studenti.add(new Studente(id, nome, cognome, eta));
            }
            return studenti;
        }
    public void updateStudente (Studente studente) throws SQLException {
        String query = "UPDATE STUDENTE SET ID = ?, NOME = ?, COGNOME = ?, ETA = ? WHERE ID = ?";
        PreparedStatement statement = ConnectionProvider.getInstance().prepareStatement(query);
        statement.setInt(1, studente.getId());
        statement.setString(2, studente.getNome());
        statement.setString(3, studente.getCognome());
        statement.setInt(4, studente.getEta());

        statement.executeUpdate();
        statement.close();
    }
    public void deleteStudente(int id) throws SQLException {
        String query = "DELETE FROM STUDENTE WHERE ID = ?";
        PreparedStatement statement = ConnectionProvider.getInstance().prepareStatement(query);
        statement.setInt(1, id);

        statement.executeUpdate();
        statement.close();
    }
}
