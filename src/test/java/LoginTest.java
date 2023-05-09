import org.junit.Test;
import static org.junit.Assert.assertTrue;


public class LoginTest extends BaseTest{

    @Test
    public void loginWithValidDataPO(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUserName(validUser);
        loginPage.enterValueToPassword(validUser);
        loginPage.clickOnLoginButton();
        // проверка успешной авторизации
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
    }

    @Test
    public void loginWithLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUserName(lockedOutUser);
        loginPage.enterValueToPassword(lockedOutUser);
        loginPage.clickOnLoginButton();
        // assert error message text
        assertTrue(loginPage.getErrorMessageText().contains("Sorry, this user has been locked out"));
    }


    @Test
    public void loginWithInvalidData() {
        // check error message text
        // "Username and password do not match any user in this service"
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterValueToUserName(invalidUser);
        loginPage.enterValueToPassword(invalidUser);
        loginPage.clickOnLoginButton();
        assertTrue(loginPage.getErrorMessageText().
                contains("Username and password do not match any user in this service"));
        }

    //logout
    @Test
    public void successLogout() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.successLogin(validUser);
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryListIsDisplayed());
        inventoryPage.clickOnBurgerMenuBtn();
        SideBar sideBar = new SideBar(driver);
        sideBar.clickOnLogoutButton();
        assertTrue(loginPage.loginButtonIsDisplayed());
    }
}
