import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType type;
    private final String name;
    private final float expectedPrice;


    public IngredientTest(IngredientType type, String name, float price) {
        this.type = type;
        this.name = name;
        this.expectedPrice = price;

    }

    @Parameterized.Parameters(name = "Type = {0}, Name = {1}, Price = {2}")
    public static Object[][] getData() {
        return new Object[][]{{SAUCE, "Jam", 20.20F}, {SAUCE, "Mayochup", 66.66F}, {FILLING, "Teftel", 100.10F}, {FILLING, "Dragon egg", 7777.77F}};
    }

    @Test
    public void getPriceReturnsCorrectPriceForIngredient() {
        // Arrange
        IngredientType mockType = mock(IngredientType.class);
        Ingredient ingredient = new Ingredient(mockType, name, expectedPrice);
        //Act
        float resultPrice = ingredient.getPrice();
        //Arrange
        assertEquals("Price совпадает", expectedPrice, resultPrice, 0);
    }

    @Test
    public void getNameReturnsCorrectNameForIngredient() {
        // Arrange
        IngredientType mockType = mock(IngredientType.class);
        Ingredient ingredient = new Ingredient(mockType, name, expectedPrice);
        //Act
        String resultName = ingredient.getName();
        //Arrange
        assertEquals("Name совпадает", name, resultName);
    }

    @Test
    public void getTypeReturnsCorrectTypeForIngredient() {
        // Arrange
        Ingredient ingredient = new Ingredient(type, name, expectedPrice);
        //Act
        IngredientType resultType = ingredient.getType();
        //Arrange
        assertEquals("Type совпадает", type, resultType);
    }
}
