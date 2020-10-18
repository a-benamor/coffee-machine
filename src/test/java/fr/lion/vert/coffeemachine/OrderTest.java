package fr.lion.vert.coffeemachine;

import fr.lion.vert.coffeemachine.drinks.imp.*;
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
                new Order(new Tea(),0, new BigDecimal("0.4")).translateCustomerOrderToDrinkMaker());

        Assertions.assertEquals("H::",
                new Order(new Chocolate(),0, new BigDecimal("0.4")).translateCustomerOrderToDrinkMaker());

        Assertions.assertEquals("C::",
                new Order(new Coffee(),0, new BigDecimal("0.4")).translateCustomerOrderToDrinkMaker());

    }

    @Test
    public void givenTheDrinkTypeAndSugar_asOrder_then_ShouldReturnTheRightInstruction() {
        Assertions.assertEquals("T:1:0",
                new Order(new Tea(),1, new BigDecimal("0.4")).translateCustomerOrderToDrinkMaker());

        Assertions.assertEquals("C:2:0",
                new Order(new Coffee(),2, new BigDecimal("0.4")).translateCustomerOrderToDrinkMaker());
    }

    @Test
    public void given_enoughMoney_then_shouldMakeDrink() {
        Assertions.assertEquals("T:1:0",
                new Order(new Tea(),1,new BigDecimal("0.4")).sendCommandToDrinkMaker());

        Assertions.assertEquals("T:1:0",
                new Order(new Tea(),1,new BigDecimal("2")).sendCommandToDrinkMaker());

        Assertions.assertEquals("C:2:0",
                new Order(new Coffee(),2,new BigDecimal("0.6")).sendCommandToDrinkMaker());

        Assertions.assertEquals("H::",
                new Order(new Chocolate(),0,new BigDecimal("0.5")).sendCommandToDrinkMaker());
    }

    @Test
    public void given_notEnoughMoney_then_forwardTheMissingMoney() {
        Assertions.assertEquals("M:The amount of money missing is : 0.2",
                new Order(new Tea(),1,new BigDecimal("0.2")).sendCommandToDrinkMaker());

        Assertions.assertEquals("M:The amount of money missing is : 0.1",
                new Order(new Coffee(),2,new BigDecimal("0.5")).sendCommandToDrinkMaker());

        Assertions.assertEquals("M:The amount of money missing is : 0.4",
                new Order(new Chocolate(),0,new BigDecimal("0.1")).sendCommandToDrinkMaker());
    }

    @Test
    public void given_enoughMoney_thenMakeHotDrink() {
        Assertions.assertEquals("O::",
                new Order(new OrangeJuice(),0,new BigDecimal("0.6")).sendCommandToDrinkMaker());

        Assertions.assertEquals("Ch::",
                new Order(new HotCoffee(),0,new BigDecimal("0.6")).sendCommandToDrinkMaker());

        Assertions.assertEquals("Hh:1:0",
                new Order(new HotChocolate(),1,new BigDecimal("0.5")).sendCommandToDrinkMaker());

        Assertions.assertEquals("Th:2:0",
                new Order(new HotTea(),2,new BigDecimal("0.5")).sendCommandToDrinkMaker());
    }

    @Test
    public void given_notEnoughMoney_ForHotDrink_then_forwardTheMissingMoney() {
        Assertions.assertEquals("M:The amount of money missing is : 0.2",
                new Order(new OrangeJuice(),0,new BigDecimal("0.4")).sendCommandToDrinkMaker());

        Assertions.assertEquals("M:The amount of money missing is : 0.1",
                new Order(new HotCoffee(),0,new BigDecimal("0.5")).sendCommandToDrinkMaker());

        Assertions.assertEquals("M:The amount of money missing is : 0.4",
                new Order(new HotChocolate(),1,new BigDecimal("0.1")).sendCommandToDrinkMaker());

        Assertions.assertEquals("M:The amount of money missing is : 0.2",
                new Order(new HotTea(),2,new BigDecimal("0.2")).sendCommandToDrinkMaker());
    }

}