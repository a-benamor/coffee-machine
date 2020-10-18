package fr.lion.vert.coffeemachine;

/**
 * @author abenamor on 18/10/2020
 */
public enum DrinkType {
    TEA("T"),CHOCOLATE("H"),COFFEE("C");

    private String abreviation;

    private DrinkType(String abreviation) {
        this.abreviation = abreviation;
    }

    public String getAbreviation() {
        return abreviation;
    }
}
