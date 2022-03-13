package business;

import java.io.Serializable;

/**
 * Clasa abstracta pentru produs din meniu
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public abstract class MenuItem implements Serializable {
    /**
     * Numele produsului
     */
    private String title;

    /**
     * Constructor
     * @param title numele
     */
    public MenuItem(String title) {
        this.title = title;
    }

    /**
     * Getter
     * @return numele
     */
    public String getTitle() {
        return title;
    }

    /**
     * Calcularea pretului
     * @return pretul
     */
    public abstract int computePrice();

    /**
     * Calcularea rating-ului
     * @return rating-ul
     */
    public abstract float getRating();

    /**
     * Calcualrea caloriilor
     * @return caloriile
     */
    public abstract int getCalories();

    /**
     * Calcularea grasimilor
     * @return grasimile
     */
    public abstract int getFat();

    /**
     * Calcularea sodiului
     * @return sodiul
     */
    public abstract int getSodium();

    /**
     * Calcularea proteinelor
     * @return proteinele
     */
    public abstract int getProtein();
}
