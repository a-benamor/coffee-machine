package fr.lion.vert.coffeemachine.drinks;

import java.math.BigDecimal;

/**
 * @author abenamor on 19/10/2020
 */
public interface Drink {
    public String getAbreviation();

    public BigDecimal getPrice();
}
