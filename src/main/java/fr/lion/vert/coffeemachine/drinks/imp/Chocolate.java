package fr.lion.vert.coffeemachine.drinks.imp;

import fr.lion.vert.coffeemachine.drinks.Drink;

import java.math.BigDecimal;

/**
 * @author abenamor on 19/10/2020
 */
public class Chocolate implements Drink {
    private static final String CHOCOLATE_ABREVIATION = "H";
    private static final BigDecimal CHOCOLATE_UNIT_PRICE = new BigDecimal("0.5");

    @Override
    public String getAbreviation() {
        return CHOCOLATE_ABREVIATION;
    }

    @Override
    public BigDecimal getPrice() {
        return CHOCOLATE_UNIT_PRICE;
    }
}
