import org.junit.Test;
import praktikum.Bun;

import static org.junit.Assert.assertEquals;

public class BunTest{

    private String name;
    private float price;

    @Test
    public void getNameReturnsCorretNameforBun(){
        //Arrange
        Bun bun = new Bun (name, price);
        //Act
        String resultName = bun.getName();
        //Assert
        assertEquals ("Название булочки совпадает",name, resultName);
    }

    @Test
    public void getPriceReturnsCorrectPrcie(){
        //Arrange
        Bun bun = new Bun (name, price);
        //Act
        float resultPrice = bun.getPrice();
        //Assert
        assertEquals ("Цена за булочку совпадает", price, resultPrice, 0);
    }
}
