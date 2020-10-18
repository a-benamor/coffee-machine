package fr.lion.vert.coffeemachine.drinks.imp;

import fr.lion.vert.coffeemachine.drinks.Drink;

import java.math.BigDecimal;

/**
 * @author abenamor on 19/10/2020
 */
public class OrangeJuice implements Drink {
    private static final String ORANGE_JUICE_ABREVIATION = "O";
    private static final BigDecimal ORANGE_JUICE_UNIT_PRICE = new BigDecimal("0.6");

    @Override
    public String getAbreviation() {
        return ORANGE_JUICE_ABREVIATION;
    }

    @Override
    public BigDecimal getPrice() {
        return ORANGE_JUICE_UNIT_PRICE;
    }
}
