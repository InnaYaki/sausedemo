import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CheckOutTest extends BaseTest{

@Test
    public void checkTotalItem (){

    LoginPage loginPage = new LoginPage(driver);
    User validUser = new User(validUserName, validPassword);
    loginPage.successLogin(validUser);
    InventoryPage inventoryPage = new InventoryPage(driver);
    assertTrue(inventoryPage.inventoryContainerIsDisplayed());
    inventoryPage.clickOnBackpackAddToCart();
    inventoryPage.clickOnCartIcon();
    Cart cart = new Cart(driver);


}






}
