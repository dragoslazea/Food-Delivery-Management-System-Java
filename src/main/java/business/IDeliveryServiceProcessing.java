package business;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Interfata pentru descrierea functionalitatilor posibile pentru utilizatorii de tip Administrator si Client
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public interface IDeliveryServiceProcessing {
    /**
     * Citire produse din fisier csv
     * @param name numele fisierului
     * @pre name != null
     * @post usersSet.size() == usersSet.size()@pre and placedOrders.size() == placedOrders.size()@pre
     * @inv isWellFormed()
     */
    void readProductsFromCSV(String name);

    /**
     * Adaugare produs nou
     * @param item produsul de inserat
     * @pre item != null
     * @post menuItemSet.size() == menuItemSet.size()@pre + 1 and menuItemSet.contains(item) and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    void addProduct(MenuItem item);

    /**
     * Stergere produs existent
     * @param item produsul de sters
     * @pre item != null and menuItemSet.size() != 0
     * @post menuItemSet.size() == menuItemSet.size()@pre - 1 and !menuItemSet.contains(item) and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    void deleteProduct(MenuItem item);

    /**
     * Editarea unui produs existent
     * @param item produsul de editat
     * @pre item != null
     * @post menuItemSet.size() == menuItemSet.size()@pre and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    void updateProduct(MenuItem item);

    /**
     * Filtrarea produselor dupa diverse criterii
     * @param keyword cuvant cheie
     * @param rating rating
     * @param calories calorii
     * @param protein proteine
     * @param fat grasimi
     * @param sodium sodiu
     * @param price pret
     * @return multimea produselor care indeplinesc toate criteriile de selectie
     * @pre !menuItemSet.isEmpty()
     * @post menuItemSet.size() == menuItemSet.size()@pre and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    Set<MenuItem> filterProducts(String keyword, float rating, int calories, int protein, int fat, int sodium, int price);

    /**
     * Inregistrearea unui nou client
     * @param username nume de utilizator
     * @param password parola
     * @param type tipul
     * @return utilizatorul inregistrat
     * @pre username != null and password != null and type = UserType.CLIENT
     * @post menuItemSet.size() == menuItemSet.size()@pre and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre + 1
     * @inv isWellFormed()
     */
    User registerNewClient(String username, String password, UserType type);

    /**
     * Logarea unui utilizator in aplicatie
     * @param username nume de utilizator
     * @return utilizatorul logat
     * @pre username != null
     * @post menuItemSet.size() == menuItemSet.size()@pre and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    User logInUser(String username);

    /**
     * Inregistrarea unei noi comenzi
     * @param user utilizatorul care creeaza comanda
     * @param products lista de produse comandate
     * @pre user != null
     * @post menuItemSet.size() == menuItemSet.size()@pre and placedOrders.size() == placedOrders.size()@pre + 1 and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    void newOrder(User user, List<MenuItem> products);

    /**
     * Generare raport cu comenzile plasate intr-un anumit interval orar, indiferent de zi
     * @param from ora de inceput
     * @param to ora de final
     * @return lista comenzilor care indeplinesc conditia
     * @pre from less than or equal to
     * @post menuItemSet.size() == menuItemSet.size()@pre and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    List<Order> reportOrders(int from, int to);

    /**
     * Generare raport cu produsele comandate de mai mult de un numar de ori specificat
     * @param noOfTimes numarul minim de ori
     * @return lista produselor care indeplinesc conditia
     * @pre noOfTimes > 0
     * @post menuItemSet.size() == menuItemSet.size()@pre and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    List<MenuItem> reportProducts(int noOfTimes);

    /**
     * Generare raport cu clientii care au comandat de mai mult de un numar specificat de ori, iar valoarea comenzii depaseste o valoare specificata
     * @param noOfTimes numarul minim de ori
     * @param amount valoarea minima a comenzii
     * @return lista clientilor care ineplinesc conditia
     * @pre noOfTimes > 0 and amount > 0
     * @post menuItemSet.size() == menuItemSet.size()@pre and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    List<User> reportClients(int noOfTimes, int amount);

    /**
     * Gegnerare raport cu produsele comandate intr-o anumita zi si numarul cererilor pentru fiecare produs
     * @param date data
     * @return pereche (numar de cereri, produs)
     * @pre date != null
     * @post menuItemSet.size() == menuItemSet.size()@pre and placedOrders.size() == placedOrders.size()@pre and usersSet.size() == usersSet.size()@pre
     * @inv isWellFormed()
     */
    HashMap<Long, MenuItem> reportProductsDay(LocalDate date);
}
