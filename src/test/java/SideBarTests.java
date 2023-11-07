import org.junit.Test;


import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SideBarTests extends BaseTest {



    @Test
    public void linksAreDisplayed () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName,validPassword);
        loginPage.successLogin (validUser) ;
        SideBar sidebar = new SideBar(driver);
        sidebar.openSideBar();
        //sleep(5000);
        assertTrue(sidebar.allItemsLinkIsDisplayed());
        assertTrue(sidebar.aboutLinkIsDisplayed());
        assertTrue(sidebar.logoutLinkIsDisplayed());
        assertTrue(sidebar.resetAppLinkIsDisplayed());
        assertTrue(sidebar.closeSideBarButtonIsDisplayed());
        //assertTrue(sidebar.openSideBarButtonIsDisplayed());


    }
@Test
   public void closeSideBar () throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        User validUser = new User(validUserName,validPassword);
        loginPage.successLogin (validUser) ;
        InventoryPage inventoryPage = new InventoryPage(driver);
        assertTrue(inventoryPage.inventoryContainerIsDisplayed());
        SideBar sidebar = new SideBar(driver);
        sidebar.openSideBar();
        sidebar.closeSideBar();
        sidebar.sideBarHasHidden();
        sleep (2000);

        assertFalse(sidebar.allItemsLinkIsDisplayed());
        assertFalse(sidebar.aboutLinkIsDisplayed());
        assertFalse(sidebar.logoutLinkIsDisplayed());
        assertFalse(sidebar.resetAppLinkIsDisplayed());



    }



}
