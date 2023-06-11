package test1;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Studente studente1 = new Studente(123, "Alex", "fortini", 23);
        Studente studente2 = new Studente(11,"Gaia","Addeo",24);
        Studente studente3 = new Studente(13, "Alex", "Boh", 25);
        //System.out.println(studente1);


        StudenteDAO studenteDAO = new StudenteDAO();

        //studenteDAO.insertStudente(studente1);
        //studenteDAO.insertStudente(studente2);
        //studenteDAO.insertStudente(studente3);

        //studenteDAO.retriveStudente(studente1.getId());
        //studenteDAO.retriveStudente(studente2.getId());
       //studenteDAO.retriveStudente(124);

        //studenteDAO.retrieveByNome("Alex");
        System.out.println(studenteDAO.retrieveByNome("Alex"));
    }
}

