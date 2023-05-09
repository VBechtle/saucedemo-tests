import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutStepTwoPage extends BasePage{

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    public void clickOnFinishButton(){
        finishButton.click();
    }
}
