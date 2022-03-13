package business;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clasa pentru produs de baza
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public class BaseProduct extends MenuItem implements Serializable {
    /**
     * Rating
     */
    private float rating;

    /**
     * Calorii
     */
    private int calories;

    /**
     * Proteine
     */
    private int protein;

    /**
     * Grasimi
     */
    private int fat;

    /**
     * Sodiu
     */
    private int sodium;

    /**
     * Pret
     */
    private int price;

    /**
     * Constructor
     * @param title -
     * @param rating -
     * @param calories -
     * @param protein -
     * @param fat -
     * @param sodium -
     * @param price -
     */
    public BaseProduct(String title, float rating, int calories, int protein, int fat, int sodium, int price) {
        super(title);
        this.rating = rating;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.sodium = sodium;
        this.price = price;
    }

    /**
     * Getter
     * @return titlul
     */
    public String getTitle() {
        return super.getTitle();
    }

    /**
     * Getter
     * @return ratingul
     */
    public float getRating() {
        return rating;
    }

    /**
     * Getter
     * @return caloriile
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Getter
     * @return proteinele
     */
    public int getProtein() {
        return protein;
    }

    /**
     * Getter
     * @return grasimile
     */
    public int getFat() {
        return fat;
    }

    /**
     * Getter
     * @return sodiul
     */
    public int getSodium() {
        return sodium;
    }

    /**
     * Getter
     * @return pretul
     */
    public int getPrice() {
        return price;
    }

    /**
     * Setter
     * @param rating rating-ul
     */
    public void setRating(float rating) {
        this.rating = rating;
    }

    /**
     * Setter
     * @param calories caloriile
     */
    public void setCalories(int calories) {
        this.calories = calories;
    }

    /**
     * Setter
     * @param protein proteinele
     */
    public void setProtein(int protein) {
        this.protein = protein;
    }

    /**
     * Setter
     * @param fat garsimile
     */
    public void setFat(int fat) {
        this.fat = fat;
    }

    /**
     * Setter
     * @param sodium sodiul
     */
    public void setSodium(int sodium) {
        this.sodium = sodium;
    }

    /**
     * Setter
     * @param price pretul
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Afisare detalii produs
     */
    public void showProductDetails() {
        System.out.println("Title: " + getTitle() + " rating: " + rating + " calories: " + calories + " protein: " + protein + " fat: " + fat + " sodium: " + sodium + " price: " + price);
    }

    /**
     * Calcularea pretului
     * @return pretul produsului
     */
    @Override
    public int computePrice() {
        return this.price;
    }

    /**
     * Suprascrierea metodei equals() dupa numele produslui
     * @param o obiect cu care se compara
     * @return valoare booleana
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseProduct that = (BaseProduct) o;
        return getTitle().equals(that.getTitle());
    }

    /**
     * Suprascriere hashCode()
     * @return hasCode dupa nume
     */
    @Override
    public int hashCode() {
        return Objects.hash(getTitle());
    }

    /**
     * Suprascriere toString()
     * @return string cu informatiile despre produs
     */
    @Override
    public String toString() {
        return "BaseProduct{" +
                "title='" + getTitle() + '\'' +
                ", rating=" + rating +
                ", calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", price=" + price +
                '}';
    }
}
