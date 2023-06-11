package test2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestioneStudentiDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/test2";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hylvanuvola";

    public void creaTabellaStudenti() {
        String query = "CREATE TABLE Studenti (" +
                "ID INT PRIMARY KEY," +
                "Nome VARCHAR(255)," +
                "Cognome VARCHAR(255)," +
                "Eta INT" +
                ")";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            ((Statement) statement).executeUpdate(query);
            System.out.println("Tabella 'Studenti' creata con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void inserisciStudente(Studente studente) {
        String query = "INSERT INTO Studenti (ID, Nome, Cognome, Eta) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, studente.getID());
            statement.setString(2, studente.getNome());
            statement.setString(3, studente.getCognome());
            statement.setInt(4, studente.getEta());

            statement.executeUpdate();
            System.out.println("Studente inserito con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

        public List<Studente> recuperaStudenti() {
            List<Studente> studenti = new ArrayList<>();
            String query = "SELECT ID, Nome, Cognome, Eta FROM Studenti";

            try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                 Statement statement = conn.createStatement();
                 ResultSet resultSet = statement.executeQuery(query)) {

                while (resultSet.next()) {
                    int id = resultSet.getInt("ID");
                    String nome = resultSet.getString("Nome");
                    String cognome = resultSet.getString("Cognome");
                    int eta = resultSet.getInt("Eta");

                    Studente studente = new Studente(id, nome, cognome, eta);
                    studenti.add(studente);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return studenti;
        }
    }

