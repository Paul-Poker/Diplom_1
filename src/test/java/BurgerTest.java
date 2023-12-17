import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerTest {
    private final List<Ingredient> ingredients;
    private final Bun bun;
    private final float expectedPrice;
    private final String expectedReceipt;
    private Burger burger;
    @Mock
    private Bun mockBun;

    public BurgerTest(List<Ingredient> ingredients, Bun bun, float expectedPrice, String expectedReceipt) {
        this.ingredients = ingredients;
        this.bun = bun;
        this.expectedPrice = expectedPrice;
        this.expectedReceipt = expectedReceipt;
    }

    @Parameterized.Parameters(name = "Expected price = {2}")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {
                        Arrays.asList(
                                new Ingredient(SAUCE, "Jam", 50),
                                new Ingredient(FILLING, "Teftel", 100)
                        ),
                        new Bun("Lucky bun", 77),
                        304,
                        "(==== Lucky bun ====)\n" +
                        "= sauce Jam =\n" +
                        "= filling Teftel =\n" +
                        "(==== Lucky bun ====)\n\n" +
                        "Price: 304,000000\n"
                },
                {
                        Arrays.asList(
                                new Ingredient(SAUCE, "Mayochup", 100),
                                new Ingredient(FILLING, "Dragon egg", 500)
                        ),
                        new Bun("Tasty bun", 200),
                        1000,
                        "(==== Tasty bun ====)\n" +
                        "= sauce Mayochup =\n" +
                        "= filling Dragon egg =\n" +
                        "(==== Tasty bun ====)\n\n" +
                        "Price: 1000,000000\n"
                },
        });
    }

    @Before
    public void setUp() {
        // Arrange
        burger = new Burger();
        burger.setBuns(bun);
        for (Ingredient ingredient : ingredients) {
            burger.addIngredient(ingredient);
        }
    }

    @Test
    public void testGetPrice() {
        // Act
        float resultPrice = burger.getPrice();
        // Assert
        assertEquals("Price за бургер совпадает", expectedPrice, resultPrice, 0);
    }

    @Test
    public void setBunsTest() {
        //Arrange
        mockBun = new Bun("lucky bun", 77.7f);
        burger.setBuns(mockBun);
        //Act
        String resultName = burger.bun.getName();
        //Assert
        assertEquals(mockBun.getName(), resultName);
    }

    @Test
    public void addIngredientTest() {
        //Act
        int countOfIngredients = burger.ingredients.size();
        //Assert
        assertEquals("Количество добавленных ingredients совпадает", 2, countOfIngredients);

    }

    @Test
    public void moveIngredientsTest() {
        //Arrange
        String firstIngredientBeforeMoving = String.valueOf(burger.ingredients.get(1));
        String secondIngredientBeforeMoving = String.valueOf(burger.ingredients.get(0));
        //Act
        burger.moveIngredient(1, 0);
        String firstIngredient = String.valueOf(burger.ingredients.get(0));
        String secondIngredient = String.valueOf(burger.ingredients.get(1));
        //Assert
        assertEquals(firstIngredientBeforeMoving, firstIngredient);
        assertEquals(secondIngredientBeforeMoving, secondIngredient);
    }

    @Test
    public void removeIngredientsTest() {
        //Act
        burger.removeIngredient(1);
        burger.removeIngredient(0);
        int countOfIngredients = burger.ingredients.size();
        //Assert
        assertEquals("Количество оставщшихся ingredients совпадает", 0, countOfIngredients);
    }

    @Test
    public void getReceiptTest() {
        // Act
        String resultReceipt = burger.getReceipt();
        // Assert
        assertEquals("receipt совпадает", expectedReceipt, resultReceipt);
    }


}



