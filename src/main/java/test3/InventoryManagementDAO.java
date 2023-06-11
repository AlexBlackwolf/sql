package test3;

import test2.Studente;

import java.sql.*;

public class InventoryManagementDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/test3";

    private static final String USERNAME = "root";

    private static final String PASSWORD = "hylvanuvola";

    public void creaTabellaProdcuts() {
        String query = "CREATE TABLE Products (" +
                "ID INT PRIMARY KEY," +
                "Name VARCHAR(255)," +
                "Price DOUBLE," +
                "Quantity INT" +
                ")";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             Statement statement = conn.createStatement()) {
            ((Statement) statement).executeUpdate(query);
            System.out.println("Tabella 'Products' creata con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void inserisciProdcuts(Products products) {
        String query = "INSERT INTO Products (ID, Name, Price, Quantity) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(1, products.getId());
            statement.setString(2, products.getName());
            statement.setDouble(3, products.getPrice());
            statement.setInt(4, products.getQuantity());

            statement.executeUpdate();
            System.out.println("Prodotto inserito con successo.");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        }
    }
