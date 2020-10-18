package fr.lion.vert.coffeemachine;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * @author abenamor on 18/10/2020
 */
public class Order {
    private static final Logger LOG = LoggerFactory.getLogger(Order.class);
    private static final String TWO_POINTS = ":";
    private static final String ZERO = "0";
    private static final BigDecimal TEA_UNIT_PRICE = new BigDecimal("0.4");
    private static final BigDecimal COFFEE_UNIT_PRICE = new BigDecimal("0.6");
    private static final BigDecimal CHOCOLATE_UNIT_PRICE = new BigDecimal("0.5");

    private static Map<Character, BigDecimal> drinkTypePrice = new HashMap<>();

    // A map that map a drink to its price
    static {
        drinkTypePrice.put(DrinkType.TEA.getAbreviation(), TEA_UNIT_PRICE);
        drinkTypePrice.put(DrinkType.COFFEE.getAbreviation(), COFFEE_UNIT_PRICE);
        drinkTypePrice.put(DrinkType.CHOCOLATE.getAbreviation(), CHOCOLATE_UNIT_PRICE);
    }

    private DrinkType drinkType;
    private int sugarNumber;
    private BigDecimal money;

    public Order(DrinkType drinkType, int sugarNumber) {
        this.drinkType = drinkType;
        this.sugarNumber = sugarNumber;
    }

    public Order(DrinkType drinkType, int sugarNumber, BigDecimal money) {
        this.drinkType = drinkType;
        this.sugarNumber = sugarNumber;
        this.money = money;
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

    private String forwardInfoMessageToTheDrinkMaker(String msg) {
        return new StringBuilder("M:").append(msg).toString();
    }

    public String sendCommandToDrinkMaker() {
        if (this.money.compareTo(drinkTypePrice.get(drinkType.getAbreviation())) >= 0 ) {
            return translateCustomerOrderToDrinkMaker();
        } else {
            String infoMsg = new StringBuilder("The amount of money missing is : ")
                    .append(drinkTypePrice.get(drinkType.getAbreviation()).subtract(money))
                    .toString();

            LOG.info(infoMsg);
            return forwardInfoMessageToTheDrinkMaker(infoMsg);
        }

    }

}
