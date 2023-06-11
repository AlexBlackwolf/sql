package sql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        /*List<Game> gameList = new ArrayList<>();

        gameList.add(new Game("MH", "RPG", true, 30, "CC"));
        gameList.add(new Game("MH2", "RPG", true, 35, "CC"));

        for (int i = 0; i < gameList.size(); i++) {
            Game game = gameList.get(i);
            System.out.println(game);*/

            Game game1 = new Game("DS", "RPG", true, 30, "FS");
            Game game2 = new Game("DS2", "RPG", false, 30, "FS");
            Game game3 = new Game("DS3", "RPG", true, 30, "FS");

            GameDAO gameDAO = new GameDAO();
            gameDAO.createGame(game1);
            gameDAO.createGame(game2);
            gameDAO.createGame(game3);

            //gameDAO.readGameName("ds3");
            System.out.println(gameDAO.readGamePublisher("FS"));
        }
    }
