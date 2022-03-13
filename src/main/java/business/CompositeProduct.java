package business;

import java.io.Serializable;
import java.util.*;

/**
 * Clasa pentru produs compus
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public class CompositeProduct extends MenuItem implements Serializable {
    /**
     * Lista produselor componente
     */
    private List<MenuItem> menuItemList;

    /**
     * Pretul produsului compus (suma preturilor produselor componente)
     */
    private int price;

    /**
     * Constructor
     * @param title numele produsului compus
     */
    public CompositeProduct(String title) {
        super(title);
        this.menuItemList = new ArrayList<MenuItem>();
        this.price = 0;
    }

    /**
     * Getter
     * @return titlul
     */
    public String getTitle() {
        return super.getTitle();
    }

    /**
     * Setter
     * @param price pretul
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Adaugare produs in produsul compus
     * @param item produsul de adaugat
     */
    public void addProduct(MenuItem item) {
        this.menuItemList.add(item);
        int p = computePrice();
        setPrice(p);
    }

    /**
     * Eliminare produs din produsul compus
     * @param item produsul de eliminat
     */
    public void removeProduct(MenuItem item) {
        this.menuItemList.remove(item);
    }

    /**
     * Afisare detalii produse de baza componente
     */
    public void showBaseProductsDetail() {
        for (MenuItem item : this.menuItemList) {
            ((BaseProduct)item).showProductDetails();
        }
    }

    /**
     * Calculare rating
     * @return media rating-urilor produselor componente
     */
    @Override
    public float getRating() {
        float rating = 0;
        for (MenuItem item : this.menuItemList) {
            rating += item.getRating();
        }
        rating /= this.menuItemList.size();
        return rating;
    }

    /**
     * Calculare calorii
     * @return suma caloriilor produselor componente
     */
    @Override
    public int getCalories() {
        int calories = 0;
        for (MenuItem item : this.menuItemList) {
            calories += item.getCalories();
        }
        return calories;
    }

    /**
     * Calcularea proteinelor
     * @return suma proteinelor produselor componente
     */
    @Override
    public int getProtein() {
        int proteins = 0;
        for (MenuItem item : this.menuItemList) {
            proteins += item.getProtein();
        }
        return proteins;
    }

    /**
     * Calcularea grasimilor
     * @return suma grasimilor produselor componente
     */
    @Override
    public int getFat() {
        int fat = 0;
        for (MenuItem item : this.menuItemList) {
            fat += item.getFat();
        }
        return fat;
    }

    /**
     * Calcularea sodiului
     * @return suma cantitatilor de sodiu ale produselor componente
     */
    @Override
    public int getSodium() {
        int sodium = 0;
        for (MenuItem item : this.menuItemList) {
            sodium += item.getSodium();
        }
        return sodium;
    }

    /**
     * Cautarea dupa nume a unui produs compus
     * @param name numele
     * @return produsul cautat
     */
    public MenuItem searchByName(String name) {
        for (MenuItem item : this.menuItemList) {
            if (item instanceof BaseProduct) {
                if (((BaseProduct)item).getTitle().equals(name)) {
                    return item;
                }
            } else {
                if (((CompositeProduct)item).getTitle().equals(name)) {
                    return item;
                }
            }
        }
        return null;
    }

    /**
     * Suprascriere equals() dupa nume
     * @param o obiect cu care se compara
     * @return valoarea booleana
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompositeProduct that = (CompositeProduct) o;
        return super.getTitle().equals(that.getTitle());
    }

    /**
     * Suprascriere hashCode() dupa nume
     * @return hashCode() dupa nume
     */
    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    /**
     * Calcularea pretului
     * @return suma preturilor produselor componente
     */
    @Override
    public int computePrice() {
        int p = 0;
        for (MenuItem item : this.menuItemList) {
            p += item.computePrice();
        }
        this.setPrice(p);
        return p;
    }

    /**
     * Suprascriere toString()
     * @return string cu informatii despre produsul compus
     */
    @Override
    public String toString() {
        return "CompositeProduct{" +
                "title='" + getTitle() + '\'' +
                ", menuItemList=" + menuItemList +
                ", price=" + price +
                '}';
    }
}
