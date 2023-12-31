
import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;


public class InventoryTests extends BaseTest {

    @Test
    public void visibilityOfProductCards(){
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName,validPassword);
        loginPage.successLogin (validUser) ;
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.allProductCardsAreVisible();
    }
@Test
    public void checkProductAdded () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName,validPassword);
        loginPage.successLogin (validUser) ;
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        SideBar sidebar = new SideBar(driver);
        sidebar.openSideBar();
        sleep(1000);
        sidebar.clickOnResetAppState();
        sidebar.closeSideBar();
        inventoryPage.clickOnBackpackAddToCart();
        sleep(10000);
    }







}
