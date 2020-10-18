package fr.lion.vert.coffeemachine.drinks.imp;

/**
 * @author abenamor on 19/10/2020
 */
public class HotTea extends Tea {
    private static final String HOT_TEA_ABREVIATION = "Th";

    @Override
    public String getAbreviation() {
        return HOT_TEA_ABREVIATION;
    }
}
