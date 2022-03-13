package presentation;

import business.MenuItem;

import javax.swing.*;
import java.util.Set;

/**
 * Clasa pentru tabelul cu produse
 * @author Dragos-Bogdan Lazea, CTI-UTCN, 30223
 * @since May 2021
 */
public class MenuItemsTable {

    /**
     * Generare tabel cu produse
     * @param setOfItems multimea produselor
     * @return tabel cu produsele
     */
    public static JTable generateTable(Set<MenuItem> setOfItems) {
       String[] header = {"Name", "Rating", "Calories", "Protein", "Fat", "Sodium", "Price"};
       String[][] data = new String[setOfItems.size()][7];
       int itemIndex = 0;
       for (business.MenuItem item : setOfItems) {
           if (item instanceof business.BaseProduct) {
               data[itemIndex][0] = ((business.BaseProduct)item).getTitle();
               data[itemIndex][1] = Float.toString(((business.BaseProduct)item).getRating());
               data[itemIndex][2] = Integer.toString(((business.BaseProduct)item).getCalories());
               data[itemIndex][3] = Integer.toString(((business.BaseProduct)item).getProtein());
               data[itemIndex][4] = Integer.toString(((business.BaseProduct)item).getFat());
               data[itemIndex][5] = Integer.toString(((business.BaseProduct)item).getSodium());
               data[itemIndex][6] = Integer.toString(((business.BaseProduct)item).getPrice());
           } else {
               data[itemIndex][0] = ((business.CompositeProduct)item).getTitle();
               data[itemIndex][1] = Float.toString(((business.CompositeProduct)item).getRating());
               data[itemIndex][2] = Integer.toString(((business.CompositeProduct)item).getCalories());
               data[itemIndex][3] = Integer.toString(((business.CompositeProduct)item).getProtein());
               data[itemIndex][4] = Integer.toString(((business.CompositeProduct)item).getFat());
               data[itemIndex][5] = Integer.toString(((business.CompositeProduct)item).getSodium());
               data[itemIndex][6] = Integer.toString(item.computePrice());
           }
           itemIndex++;
       }
       return new JTable(data, header);
   }

}
