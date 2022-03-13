package test;

import business.CompositeProduct;
import business.DeliveryService;
import business.User;
import business.UserType;
import presentation.AdministratorGUI;
import presentation.ClientGUI;
import presentation.EmployeeGUI;
import presentation.LogInGUI;

/**
 * Clasa pentru pornirea aplicatiei
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public class MainClass {

    /**
     * Metoda main
     * @param args -
     */
    public static void main(String[] args) {
        DeliveryService deliveryService = new DeliveryService();
        CompositeProduct cp = new CompositeProduct("1");
        cp.addProduct(deliveryService.findByName("Italian Chicken Salad "));
        cp.addProduct(deliveryService.findByName("Mango and Red Onion Salsa "));
        System.out.println(cp);
        deliveryService.addProduct(cp);
        System.out.println(deliveryService.findByName("1"));
        LogInGUI logInGUI = new LogInGUI(deliveryService);
        System.out.println(deliveryService.getPlacedOrders());
        System.out.println(deliveryService.getUsersSet());
    }
}
