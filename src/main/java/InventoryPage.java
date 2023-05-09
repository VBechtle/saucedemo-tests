import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class InventoryPage extends BasePage{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "inventory_list")
    private WebElement inventoryList;
    @FindBy(className = "inventory_item")
    private List<WebElement> inventoryItems;

    @FindBy(className = "inventory_item_name")
    private List<WebElement> inventoryNames;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrices;

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuBtn;

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeAddToCart;

    @FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private WebElement TShirtAddToCart;

    @FindBy(className = "shopping_cart_link")
    private WebElement cartIcon;



    public boolean inventoryListIsDisplayed() {

        return inventoryList.isDisplayed();
    }

    public int getItemsQuantity() {
        return inventoryItems.size();  //size показывает спсок items
    }

    public boolean allItemsAreDisplayed() {
        boolean displayed = true;
        for (WebElement item : inventoryItems) {
            if (!item.isDisplayed()) {
                displayed = false;
            }
        }
        return displayed;
    }

    //    for (WebElement item: inventoryItems){ // проверка всех пример как верхний
//            if (!item.isDisplayed()) {
//                return false;
//            }
//        }
//        return true;

    public boolean allItemNamesAreDisplayed() {
        boolean displayed = true;
        for (WebElement itemsName : inventoryNames) {
            if (!itemsName.isDisplayed()) {
                displayed = false;
            }
        }
        return displayed;
    }

    public boolean allNamesAreNotEmpty() {
        boolean notEmpty = true;
        for (WebElement itemsName : inventoryNames) {
            if (itemsName.getText().isEmpty()) {
                notEmpty = false;
            }
        }
        return notEmpty;
    }
    public boolean allNamesStartWithSauceLabs(){
        boolean allContains = true;
//        int index = 1;
        for (WebElement name : inventoryNames) {
            if (!name.getText().startsWith("Sauce Labs")){
                allContains=false;
                System.out.println("Item with product number "+ (inventoryNames.indexOf(name)+1) +" does not start with Sauce Labs" );
            }
//            index++;
        }
        return allContains;
    }

    public void clickOnBurgerMenuBtn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenuBtn));
        burgerMenuBtn.click();
    }

    public void clickOnBackpackAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(backpackAddToCart));
        backpackAddToCart.click();
    }

    public void clickOnBikeAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(bikeAddToCart));
        bikeAddToCart.click();
    }

    public void clickOnTShirtAddToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(TShirtAddToCart));
        TShirtAddToCart.click();
    }
    public void clickOnCartItem(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        cartIcon.click();
    }

    public String getPriceOfFirstItem(){
        return inventoryPrices.get(0).getText();
    }

}

