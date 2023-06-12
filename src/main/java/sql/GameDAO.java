package sql;
//This line specifies the package in which the GameDAO class is defined.


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
//These lines import the necessary classes for working with JDBC and handling lists.

public class GameDAO {
    //This line begins the declaration of the GameDAO class.

    private static final String URL = "jdbc:mysql://localhost:3306/sql";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "hylvanuvola";
    //This line begins the declaration of the GameDAO class.


    public void createGame(Game game) {
        //This line defines a method createGame that takes a Game object as a parameter and does not return any value.
        String query = "INSERT INTO games (name, genre, goty, price, publisher) " +
                "VALUES (?,?,?,?,?)";
        //This line defines the SQL query string for inserting a game into the games table.
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {
            //This line establishes a connection to the database using the URL, username, and password.
            // It also prepares a statement with the SQL query.
            statement.setString(1, game.getName());
            statement.setString(2, game.getGenre());
            statement.setBoolean(3, game.getGoty());
            statement.setInt(4, game.getPrice());
            statement.setString(5, game.getPublisher());
            //These lines set the values of the parameters in the prepared statement
            // based on the properties of the Game object.
            statement.executeUpdate();
            System.out.println("data inserted");
            //This line executes the SQL query and performs the database insert operation.
            // The print statement indicates that the data was successfully inserted.
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //This block catches any SQLException that may
        // occur during the database operation and prints the stack trace.
    }

    public List<Game> readAllGames() {
        List<Game> allGames = new ArrayList<>();
        String query = "SELECT * FROM games";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String genre = resultSet.getString("Genre");
                Boolean goty = resultSet.getBoolean("Goty");
                Integer price = resultSet.getInt("Price");
                String publisher = resultSet.getString("Publisher");
                Game game = new Game(name, genre, goty, price, publisher);
                allGames.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allGames;
    }

    public Game readGameName(String name) {
        //This line defines a method readGameName that takes a name parameter and returns a Game object.
        // It may throw a SQLException.
        String query = "SELECT * FROM games WHERE name =?";
        //This line defines the SQL query string for retrieving a game based on the name.
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {
            //This line establishes a connection to the database and prepares a statement for executing the SQL query.
            statement.setString(1, name);
            //These lines set the value of the parameter in the prepared statement and execute the SQL query to retrieve the data.
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String genre = resultSet.getString("Genre");
                Boolean goty = resultSet.getBoolean("Goty");
                Integer price = resultSet.getInt("Price");
                String publisher = resultSet.getString("Publisher");
                Game selectGame = new Game(name, genre, goty, price, publisher);
                System.out.println(selectGame);
                return selectGame;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
        //This block iterates over the result set to retrieve the game details,
        // creates a Game object with the retrieved data, prints the game details,
        // and returns the Game object. If no matching game is found, it returns null.
    }

    public List<Game> readGamePublisher(String publisher) {
        //This line defines a method readGamePublisher that takes a publisher parameter
        // and returns a list of Game objects. It may throw a SQLException
        List<Game> gamePublishers = new ArrayList<>();
        String query = "SELECT * FROM games WHERE publisher =?";
        //These lines declare an empty List<Game> and define the SQL query
        // string for retrieving games based on the publisher.
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {
            //This line establishes a connection to the database and prepares a
            // statement for executing the SQL query.
            statement.setString(1, publisher);
            ResultSet resultSet = statement.executeQuery();
            //These lines set the value of the parameter in the prepared
            // statement and execute the SQL query to retrieve the data
            while (resultSet.next()) {
                String name = resultSet.getString("Name");
                String genre = resultSet.getString("Genre");
                Boolean goty = resultSet.getBoolean("Goty");
                Integer price = resultSet.getInt("Price");
                gamePublishers.add(new Game(name, genre, goty, price, publisher));
            }
            return gamePublishers;
            //This block iterates over the result set to retrieve the game details,
            // creates a Game object with the retrieved data and the provided publisher,
            // and adds it to the gamePublishers list. Finally, it returns the
            // populated list of games.

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteGame(String name) {
        String query = "DELETE FROM games WHERE name = ?";
        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, name);
            statement.executeUpdate();
            System.out.println("game deleted!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
