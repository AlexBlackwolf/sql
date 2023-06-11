package test3;

public class Main {
    public static void main(String[] args) {

        Products product1 = new Products(1,"ps5", 299.99, 1);

        InventoryManagementDAO inventoryManagementDAO = new InventoryManagementDAO();
        inventoryManagementDAO.creaTabellaProdcuts();
        inventoryManagementDAO.inserisciProdcuts(product1);
    }
}
