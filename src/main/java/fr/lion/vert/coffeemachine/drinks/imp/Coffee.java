package fr.lion.vert.coffeemachine.drinks.imp;

import fr.lion.vert.coffeemachine.drinks.Drink;

import java.math.BigDecimal;

/**
 * @author abenamor on 19/10/2020
 */
public class Coffee implements Drink {
    private static final String COFFEE_ABREVIATION = "C";
    private static final BigDecimal COFFEE_UNIT_PRICE = new BigDecimal("0.6");

    @Override
    public String getAbreviation() {
        return COFFEE_ABREVIATION;
    }

    @Override
    public BigDecimal getPrice() {
        return COFFEE_UNIT_PRICE;
    }
}
