import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginButton;


    @FindBy(tagName = "h3")
    private WebElement errorMessage;

    @FindBy(xpath = "//div[@class = 'login_logo']")
    private WebElement swagLabs;

    @FindBy(xpath = "//div[@class= 'login_credentials']")
    private WebElement fieldOfUsernames;

    @FindBy(xpath = "//div[@class='login_password']")
    private WebElement fieldOfPassword;


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void enterValueUserName(User user) {
        enterTextToElement(user.getUsername(),userName);
        //userName.sendKeys(user.getUsername());
    }


    public void enterValueToPassword(User user) {
        enterTextToElement(user.getPassword(),password);
        //password.sendKeys(user.getPassword());
    }

    public void pushLoginButton() {
        clickOnTheElement(loginButton);
        //loginButton.click();
    }

    public void errorMessageTextIsCorrect(String expectedText){
        assertTrue((errorMessage.getText()).contains(expectedText));
    }

    public String getErrorMessageText() {
        return getTextOfElement(errorMessage);
    }

    public void successLogin(User user) {
        enterTextToElement(user.getUsername(),userName);
        enterTextToElement(user.getPassword(),password);
        clickOnTheElement(loginButton);
        //userName.sendKeys(user.getUsername());
        //password.sendKeys(user.getPassword());
        //loginButton.click();
    }

    public void swagLabsIsVisible() {
        assertTrue(swagLabs.isDisplayed());
    }
    public void fieldOfUsernamesIsVisible (){
        assertTrue(fieldOfUsernames.isDisplayed());
    }
    public void fieldOfPasswordIsVisible (){
        assertTrue(fieldOfPassword.isDisplayed());
    }

}



