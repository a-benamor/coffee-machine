package fr.lion.vert.coffeemachine.drinks.imp;

import fr.lion.vert.coffeemachine.drinks.Drink;

import java.math.BigDecimal;

/**
 * @author abenamor on 19/10/2020
 */
public class HotCoffee extends Coffee {
    private static final String HOT_COFFEE_ABREVIATION = "Ch";

    @Override
    public String getAbreviation() {
        return HOT_COFFEE_ABREVIATION;
    }
}
