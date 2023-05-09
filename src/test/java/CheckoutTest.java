import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CheckoutTest extends BaseTest {

    @Test
    public void testSuccessCheckout(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());

        inventoryPage.clickOnBikeAddToCart();
        inventoryPage.clickOnBackpackAddToCart();
        inventoryPage.clickOnTShirtAddToCart();

        inventoryPage.clickOnCartItem();
        CartPage cartPage = new CartPage(driver);
        cartPage.clickOnCheckoutButton();
        CheckoutStepOnePage checkoutStepOnePage = new CheckoutStepOnePage(driver);
        checkoutStepOnePage.enterValueToFirstName("Vladimir");
        checkoutStepOnePage.enterValueToLastName("Black");
        checkoutStepOnePage.enterValueToZip("33719");
        checkoutStepOnePage.clickOnContinueButton();
        CheckoutStepTwoPage checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutStepTwoPage.clickOnFinishButton();
        CheckoutCompletePage checkoutCompletePage = new CheckoutCompletePage(driver);
        assertEquals("Thank you for your order!", checkoutCompletePage.getSuccessMessageText());

    }
}
