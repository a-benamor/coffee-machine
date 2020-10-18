package fr.lion.vert.coffeemachine.drinks.imp;

import fr.lion.vert.coffeemachine.drinks.Drink;

import java.math.BigDecimal;

/**
 * @author abenamor on 19/10/2020
 */
public class Tea implements Drink {
    private static final String TEA_ABREVIATION = "T";
    private static final BigDecimal TEA_UNIT_PRICE = new BigDecimal("0.4");

    @Override
    public String getAbreviation() {
        return TEA_ABREVIATION;
    }

    @Override
    public BigDecimal getPrice() {
        return TEA_UNIT_PRICE;
    }
}
