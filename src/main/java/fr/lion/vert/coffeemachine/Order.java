package fr.lion.vert.coffeemachine;

import fr.lion.vert.coffeemachine.drinks.Drink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
/**
 * @author abenamor on 18/10/2020
 */
public class Order {
    private static final Logger LOG = LoggerFactory.getLogger(Order.class);
    private static final String TWO_POINTS = ":";
    private static final String ZERO = "0";

    private Drink drink;
    private int sugarNumber;
    private BigDecimal money;


    public Order(Drink drink, int sugarNumber, BigDecimal money) {
        this.drink = drink;
        this.sugarNumber = sugarNumber;
        this.money = money;
    }

    public String translateCustomerOrderToDrinkMaker() {
        StringBuilder instructionBuilder = new StringBuilder();

        instructionBuilder.append(this.drink.getAbreviation()).append(TWO_POINTS);

        if (this.sugarNumber>0) {
            instructionBuilder.append(this.sugarNumber).append(TWO_POINTS).append(ZERO);
        } else {
            instructionBuilder.append(TWO_POINTS);
        }

        LOG.info(instructionBuilder.toString());

        return instructionBuilder.toString();
    }

    private String forwardInfoMessageToTheDrinkMaker(String msg) {
        return new StringBuilder("M:").append(msg).toString();
    }

    public String sendCommandToDrinkMaker() {
        if (money == null) {
            throw new IllegalStateException("The money must not be null");
        }

        if (this.money.compareTo(this.drink.getPrice()) >= 0 ) {
            return translateCustomerOrderToDrinkMaker();
        } else {
            String infoMsg = new StringBuilder("The amount of money missing is : ")
                    .append(drink.getPrice().subtract(money))
                    .toString();

            LOG.info(infoMsg);
            return forwardInfoMessageToTheDrinkMaker(infoMsg);
        }

    }

}
