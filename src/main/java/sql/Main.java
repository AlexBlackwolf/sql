package sql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        List<Game> gameList = new ArrayList<>();

        gameList.add(new Game("MH", "RPG", true, 30, "CC"));
        gameList.add(new Game("MH2", "RPG", true, 35, "CC"));
        gameList.add(new Game("DS", "RPG", true, 30, "FS"));
        gameList.add(new Game("DS2", "RPG", false, 30, "FS"));
        gameList.add(new Game("DS3", "RPG", true, 30, "FS"));
        gameList.add(new Game("ER", "RPG", true, 60, "FS"));

        GameDAO gameDAO = new GameDAO();

        //gameDAO.createGame(gameList.get(0));
        //for (Game game : gameDAO.readAllGames()) {
        //   System.out.println(game);
        //}
        for (Game game : gameDAO.readGamePublisher("FS")) {
            System.out.println(game);
        }
        gameDAO.deleteGame(gameList.get(0).getName());
    }
}



        /*for (int i = 0; i < gameList.size(); i++) {
            Game game = gameList.get(i);
            System.out.println(game);*/

        /*Game game1 =

        Game game3 =

        GameDAO gameDAO = new GameDAO();
        //gameDAO.createGame(game1);
        //gameDAO.createGame(game2);
        //gameDAO.createGame(game3);
        List<Game> gameList1 = gameDAO.readAllGames();
        for(Game game : gameList){
            System.out.println(game);
        }

        //}
        //}

        // System.out.println(gameDAO.readAllGames());

        //gameDAO.readGameName("ds3");
        //System.out.println(gameDAO.readGamePublisher("FS"));

         */
