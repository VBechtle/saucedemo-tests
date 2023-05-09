import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class InventoryTest extends BaseTest {

    @Test
    public void itemElementsTest(){
        //Проверяем что на странице 6 товаров
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        // проверка что страница с товарами открылась
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        assertEquals(6, inventoryPage.getItemsQuantity());
        assertTrue(inventoryPage.allItemsAreDisplayed());
        assertTrue(inventoryPage.allItemNamesAreDisplayed());
        assertTrue(inventoryPage.allNamesAreNotEmpty());
        assertTrue("Not all names starts with Sauce Labs",inventoryPage.allNamesStartWithSauceLabs());
    }
}
