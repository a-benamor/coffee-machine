package fr.lion.vert.coffeemachine;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

}