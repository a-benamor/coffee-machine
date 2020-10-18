package fr.lion.vert.coffeemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author abenamor on 18/10/2020
 */
public class Order {
    private static final Logger LOG = LoggerFactory.getLogger(Order.class);
    private static final String TWO_POINTS = ":";
    private static final String ZERO = "0";

    private DrinkType drinkType;
    private int sugarNumber;

    public Order(DrinkType drinkType, int sugarNumber) {
        this.drinkType = drinkType;
        this.sugarNumber = sugarNumber;
    }

    public String translateCustomerOrderToDrinkMaker() {
        StringBuilder instructionBuilder = new StringBuilder();

        instructionBuilder.append(this.drinkType.getAbreviation()).append(TWO_POINTS);

        if (this.sugarNumber>0) {
            instructionBuilder.append(this.sugarNumber).append(TWO_POINTS).append(ZERO);
        } else {
            instructionBuilder.append(TWO_POINTS);
        }

        LOG.info(instructionBuilder.toString());

        return instructionBuilder.toString();
    }


}
