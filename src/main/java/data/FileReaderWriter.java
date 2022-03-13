package data;

import business.BaseProduct;
import business.MenuItem;
import business.Order;
import business.User;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Clasa pentru scrierea si citirea din fiseiere
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public class FileReaderWriter {
    /**
     * Importarea setului de produse din fisierul csv
     * @param name numele fisierului csv
     * @return multimea produselor
     * @throws IOException exceptie
     */
    public static Set<MenuItem> readFromCSV(String name) throws IOException {
        return Files.lines(Paths.get(name))
                .map(x -> x.split(","))
                .map(x -> new BaseProduct(x[0], Float.parseFloat(x[1]), Integer.parseInt(x[2]), Integer.parseInt(x[3]), Integer.parseInt(x[4]), Integer.parseInt(x[5]), Integer.parseInt(x[6])))
                .distinct()
                .collect(Collectors.toSet());
    }

    /**
     * Crearea facturii
     * @param order comanda
     * @param products lista produselor din comanda
     */
    public static void createBill(Order order, List<MenuItem> products) {
        int total = 0;
        for (MenuItem item :
             products) {
            total += item.computePrice();
        }
        try {
            FileWriter fileWriter = new FileWriter("Order-" + order.getOrderID() + ".txt");
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            String toWrite = "Order no." + order.getOrderID() + " from: " + order.getOrderDate() + "\n" + "Client ID: " + order.getClientID() + "\n";
            int index = 1;
            for (MenuItem item :
                 products) {
                toWrite += index + ". " + item.getTitle() + ": " + item.computePrice() + "\n";
                index++;
            }
            toWrite += "\n----------------------------------------------------------------------------------------------------------------------------------------------------------\nTotal price: " + total;
            buffer.write(toWrite);
            toWrite = "";
            buffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Generare string pentru raportul de tip 1
     * @param from ora de inceput
     * @param to ora de final
     * @param orders lista comenzilor
     * @return string ce va fi scris in fisier
     */
    public static String generateStringReport1(int from, int to, List<Order> orders) {
        String toRreturn = "Orders between " + from + " and " + to + ", regardless the date:\n\n";
        for(Order o : orders) {
            toRreturn += "Order ID: " + o.getOrderID() + " Client ID: " + o.getClientID() + " Date And Time: " + o.getOrderDate() + "\n";
        }
        return toRreturn;
    }

    /**
     * Generare string pentru raportul de tip 2
     * @param noOfTimes numar minim de solicitari
     * @param menuItems lista produselor
     * @return string ce va fi scris in fisier
     */
    public static String generateStringReport2(int noOfTimes, List<MenuItem> menuItems) {
        String toRreturn = "Products ordered more than " + noOfTimes + " times so far:\n\n";
        for(MenuItem i : menuItems) {
            toRreturn += "Name: " + i.getTitle() + " Price: " + i.computePrice() + "\n";
        }
        return toRreturn;
    }

    /**
     * Generare string pentru raportul de tip 3
     * @param noOfTimes numar minim de solicitari
     * @param amount valoarea minima a comenzii
     * @param users lista de utilizatori (clienti)
     * @return string ce va fi scris in fisier
     */
    public static String generateStringReport3(int noOfTimes, int amount, List<User> users) {
        String toReturn = "Clients who have ordered more than " + noOfTimes + " times and the order value was higher than " + amount + ":\n\n";
        for(User u : users) {
            toReturn += "ID: " + u.getId() + " Username: " + u.getUsername() + "\n";
        }
        return toReturn;
    }

    /**
     * Generare string pentru raportul de tip 4
     * @param date data comenzii
     * @param map perechile (numar de solicitari, produs)
     * @return string ce va fi scris in fisier
     */
    public static String generateStringReport4(LocalDate date, HashMap<Long, MenuItem> map) {
        String toReturn = "Products ordered on " + date + ":\n\n";
        for(Long i : map.keySet()) {
            toReturn += "Name: " + map.get(i) + " (" + i + " times)\n";
        }
        return toReturn;
    }

    /**
     * Generare rapoarte .txt
     * @param toWrite string-ul ce va fi scris in fisier
     * @param type tipul raportului
     */
    public static void generateReport(String toWrite, int type) {
        try {
            String pattern = "MM-dd-yyy-HH-mm-ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String date = simpleDateFormat.format(new Date());
            FileWriter fileWriter = new FileWriter("Report-type-" + type + "-" + date + ".txt");
            BufferedWriter buffer = new BufferedWriter(fileWriter);
            buffer.write(toWrite);
            buffer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
