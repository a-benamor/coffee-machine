package fr.lion.vert.coffeemachine.drinks.imp;

/**
 * @author abenamor on 19/10/2020
 */
public class HotChocolate extends Chocolate {
    private static final String HOT_CHOCOLATE_ABREVIATION = "Hh";

    @Override
    public String getAbreviation() {
        return HOT_CHOCOLATE_ABREVIATION;
    }
}
