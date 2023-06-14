package prova;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    public void createCar(Car car) {

        String query = "INSERT INTO cars(name, brand, releasedate) VALUES (?, ?, ?)";
        try {
            PreparedStatement statement = ConnectionProvider.getInstance().prepareStatement(query);
            statement.setString(1, car.getName());
            statement.setString(2, car.getBrand());
            statement.setInt(3, car.getReleaseDate());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("car created");
    }

    public List<Car> readAllCars() {
        List<Car> carList = new ArrayList<>();
        String query = "SELECT * FROM cars";
        try {
            PreparedStatement statement = ConnectionProvider.getInstance().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery(); // Execute the query and retrieve the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String brand = resultSet.getString("brand");
                int releaseDate = resultSet.getInt("releasedate");
                Car car = new Car(name, brand, releaseDate);
                carList.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carList;
    }
    public List<Car> readCarBrand(String brand) {
        List<Car> carList = new ArrayList<>();
        String query = "SELECT * FROM cars WHERE brand = ?";
        try {
            PreparedStatement statement = ConnectionProvider.getInstance().prepareStatement(query);
            statement.setString(1, brand);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int releaseDate = resultSet.getInt("releasedate");
                Car car = new Car(name, brand, releaseDate);
                carList.add(car);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carList;
    }
}
