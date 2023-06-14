package prova;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("viper", "bmw", 2018);
        Car car2 = new Car("snake", "Honda", 2017);

        CarDAO carDAO = new CarDAO();
        //carDAO.createCar(car1);

        for (Car car : carDAO.readAllCars()){
        System.out.println(car);
        }
        for (Car car : carDAO.readCarBrand("bmw")){
            System.out.println(car);
        }
    }
}

