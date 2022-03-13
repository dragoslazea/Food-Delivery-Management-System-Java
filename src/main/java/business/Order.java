package business;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

/**
 * Clasa pentru comanda
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public class Order implements Serializable, Comparable<Order> {
    /**
     * ID-ul clientului
     */
    private int clientID;

    /**
     * ID-ul comenzii
     */
    private int orderID;

    /**
     * Data si ora la care a fost plasata comanda
     */
    private Date orderDate;

    /**
     * Constructor
     * @param clientID ID-ul clientului
     * @param orderID ID-ul comenzii
     */
    public Order(int clientID, int orderID) {
        this.clientID = clientID;
        this.orderID = orderID;
        this.orderDate = new Date();
    }

    /**
     * Getter
     * @return clientID
     */
    public int getClientID() {
        return clientID;
    }

    /**
     * Getter
     * @return orderID
     */
    public int getOrderID() {
        return orderID;
    }

    /**
     * Getter
     * @return data comenzii
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * Determinarea orei comenzii
     * @return ora la care a fost plasata comanda
     */
    public int getOrderHour() {
        return this.orderDate.getHours();
    }

    /**
     * Conversie la formatul LocalDate
     * @return data in formatul LocalDate
     */
    public LocalDate convertDateToLocalDate() {
        return this.orderDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    /**
     * Determinarea zilei comenzii
     * @return ziua plasarii comenzii
     */
    public int getOrderDay() {
        return convertDateToLocalDate().getDayOfMonth();
    }

    /**
     * Determinarea lunii in care a fost plasata comanda
     * @return luna in care a fost plasata comanda
     */
    public int getOrderMonth() {
        return convertDateToLocalDate().getMonthValue();
    }

    /**
     * Determinarea anului in care a fost plasata comanda
     * @return anul in care a fost plasata comanda
     */
    public int getOrderYear() {
        return convertDateToLocalDate().getYear();
    }

    /**
     * Crearea unui pattern pentru data
     * @return pattern pentru data
     */
    public String stringOrderDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = formatter.format(this.orderDate);
        return strDate;
    }

    /**
     * Suprascriere equals()
     * @param o obiectul cu care se compara
     * @return valoare booleana
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return clientID == order.clientID && orderID == order.orderID && orderDate.equals(order.orderDate);
    }

    /**
     * Suprasciere hashCode()
     * @return hashCode
     */
    @Override
    public int hashCode() {
        return Objects.hash(clientID, orderID, orderDate);
    }

    /**
     * Supreascriere toString()
     * @return string cu informatiile despre comanda
     */
    @Override
    public String toString() {
        return "Order{" +
                "clientID=" + clientID +
                ", orderID=" + orderID +
                ", orderDate=" + orderDate +
                '}';
    }

    /**
     * Suprascriere compareTO() in functie de orderID
     * @param o obiectul cu care se compara
     * @return -1, 0, 1
     */
    @Override
    public int compareTo(Order o) {
        Integer id = orderID;
        Integer idO = o.orderID;
        return id.compareTo(idO);
    }
}
