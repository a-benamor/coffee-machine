package fr.lion.vert.coffeemachine;

/**
 * @author abenamor on 18/10/2020
 */
public enum DrinkType {
    TEA('T'),CHOCOLATE('H'),COFFEE('C');

    private Character abreviation;

    private DrinkType(Character abreviation) {
        this.abreviation = abreviation;
    }

    public Character getAbreviation() {
        return abreviation;
    }


}
