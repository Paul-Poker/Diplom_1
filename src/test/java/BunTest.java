import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {
    private String name;
    private float price;

    @Test
    public void getNameReturnsCorrectNameForBun() {
        //Arrange
        Bun bun = new Bun(name, price);
        //Act
        String resultName = bun.getName();
        //Assert
        assertEquals("Name булочки совпадает", name, resultName);
    }

    @Test
    public void getPriceReturnsCorrectPrice() {
        //Arrange
        Bun bun = new Bun(name, price);
        //Act
        float resultPrice = bun.getPrice();
        //Assert
        assertEquals("Price за булочку совпадает", price, resultPrice, 0);
    }
}
