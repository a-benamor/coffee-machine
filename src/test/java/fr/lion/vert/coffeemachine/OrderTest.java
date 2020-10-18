package fr.lion.vert.coffeemachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @author abenamor on 18/10/2020
 */
class OrderTest {
    @Test
    public void givenTheDrinkTypeWithNoSugar_asOrder_then_ShouldReturnTheRightInstruction() {
        Assertions.assertEquals("T::",
                new Order(DrinkType.TEA,0).translateCustomerOrderToDrinkMaker());

        Assertions.assertEquals("H::",
                new Order(DrinkType.CHOCOLATE,0).translateCustomerOrderToDrinkMaker());

        Assertions.assertEquals("C::",
                new Order(DrinkType.COFFEE,0).translateCustomerOrderToDrinkMaker());

    }

    @Test
    public void givenTheDrinkTypeAndSugar_asOrder_then_ShouldReturnTheRightInstruction() {
        Assertions.assertEquals("T:1:0",
                new Order(DrinkType.TEA,1).translateCustomerOrderToDrinkMaker());

        Assertions.assertEquals("C:2:0",
                new Order(DrinkType.COFFEE,2).translateCustomerOrderToDrinkMaker());
    }

    @Test
    public void given_enoughMoney_then_shouldMakeDrink() {
        Assertions.assertEquals("T:1:0",
                new Order(DrinkType.TEA,1,new BigDecimal("0.4")).sendCommandToDrinkMaker());

        Assertions.assertEquals("T:1:0",
                new Order(DrinkType.TEA,1,new BigDecimal("2")).sendCommandToDrinkMaker());

        Assertions.assertEquals("C:2:0",
                new Order(DrinkType.COFFEE,2,new BigDecimal("0.6")).sendCommandToDrinkMaker());

        Assertions.assertEquals("H::",
                new Order(DrinkType.CHOCOLATE,0,new BigDecimal("0.5")).sendCommandToDrinkMaker());
    }

    @Test
    public void given_notEnoughMoney_then_forwardTheMissingMoney() {
        Assertions.assertEquals("M:The amount of money missing is : 0.2",
                new Order(DrinkType.TEA,1,new BigDecimal("0.2")).sendCommandToDrinkMaker());

        Assertions.assertEquals("M:The amount of money missing is : 0.1",
                new Order(DrinkType.COFFEE,2,new BigDecimal("0.5")).sendCommandToDrinkMaker());

        Assertions.assertEquals("M:The amount of money missing is : 0.4",
                new Order(DrinkType.CHOCOLATE,0,new BigDecimal("0.1")).sendCommandToDrinkMaker());
    }

}