import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

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
    public void getPriceReturnsCorrectPrcie() {
        //Arrange
        Bun bun = new Bun(name, price);
        //Act
        float resultPrice = bun.getPrice();
        //Assert
        assertEquals("Price за булочку совпадает", price, resultPrice, 0);
    }
}
