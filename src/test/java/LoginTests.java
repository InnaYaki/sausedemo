
import org.junit.Test;


import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class LoginTests extends BaseTest {

    @Test

    public void loginWithValidData () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName,validPassword);
        loginPage.enterValueUserName(validUser);
        loginPage.enterValueToPassword (validUser);
        loginPage.pushLoginButton();
        sleep(1000);
        assertTrue (driver.getCurrentUrl().contains("inventory"));
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
    }
    @Test
    public void loginWithLockedOutUser (){
        LoginPage loginPage = new LoginPage(driver);
        User locklOutUser = new User(lockedOutUserName,validPassword);
        loginPage.enterValueUserName(locklOutUser);
        loginPage.enterValueToPassword(locklOutUser);
        loginPage.pushLoginButton();
        loginPage.errorMessageTextIsCorrect("Epic sadface: Username and password do not match any user in this service");
    }
    @Test
    public  void invalidUser(){
        LoginPage loginPage = new LoginPage(driver);
        User invalidUser = new User (invalidUserName,invalidPassword);
        loginPage.enterValueUserName(invalidUser);
        loginPage.enterValueToPassword (invalidUser);
        loginPage.pushLoginButton();
        assertTrue (loginPage.getErrorMessageText().contains("Epic sadface: Username and password do not match any user in this service"));
    }

    @Test
    public  void elementsAreDisplayed () {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.swagLabsIsVisible();
        loginPage.fieldOfUsernamesIsVisible();
        loginPage.fieldOfPasswordIsVisible();

    }











}
