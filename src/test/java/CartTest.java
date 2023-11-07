import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CartTest extends BaseTest {
   @Test
   public void successCheckout() {
      LoginPage loginPage = new LoginPage(driver);
      User validUser = new User(validUserName, validPassword);
      loginPage.successLogin(validUser);
      InventoryPage inventoryPage = new InventoryPage(driver);
      assertTrue(inventoryPage.inventoryContainerIsDisplayed());
      String costFromInventory = inventoryPage.getBackPackCost();
      inventoryPage.clickOnBackpackAddToCart();
      inventoryPage.clickOnCartIcon();
      Cart cart = new Cart(driver);
      assertTrue(cart.firstItemIsDisplayed());
      assertEquals(1, cart.getItemsQuantity());
      assertEquals(costFromInventory,cart.getPriceOfFirstItem());

   }

   //@Test
   public void successAdding3Items() {
      LoginPage loginPage = new LoginPage(driver);
      User validUser = new User(validUserName, validPassword);
      loginPage.successLogin(validUser);
      InventoryPage inventoryPage = new InventoryPage(driver);
      assertTrue(inventoryPage.inventoryContainerIsDisplayed());
      inventoryPage.clickOnBackpackAddToCart();

      inventoryPage.clickOnBikeAddToCart();
      inventoryPage.clickOnTshirtAddToCart();
      inventoryPage.clickOnCartIcon();
      Cart cart = new Cart(driver);
      assertEquals(3, cart.getItemsQuantity());
      assertTrue( cart.allItemsIsDisplayed());
   }

   //@Test
   public void emptyCart() {
      LoginPage loginPage = new LoginPage(driver);
      User validUser = new User(validUserName, validPassword);
      loginPage.successLogin(validUser);
      InventoryPage inventoryPage = new InventoryPage(driver);
      inventoryPage.clickOnCartIcon();
      Cart cart = new Cart(driver);
      assertTrue(cart.cartIsEmpty());


   }












}

