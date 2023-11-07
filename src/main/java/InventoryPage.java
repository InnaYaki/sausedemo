import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.assertTrue;


public class InventoryPage extends BasePage{

    @FindBy(xpath = "(//div[@id = 'inventory_container'])[1]")
    private WebElement inventoryContainer;

    @FindBy( xpath = "//div[@class='inventory_item']")
    private List<WebElement> productCards;


    @FindBy (id = "add-to-cart-sauce-labs-backpack")
    private WebElement backpackAddToCarButton;


    @FindBy (id ="shopping_cart_container")
    private WebElement cartIcon;

    @FindBy (id = "add-to-cart-sauce-labs-bike-light")
    private WebElement bikeAddToCartButton;

    @FindBy (id = "add-to-cart-sauce-labs-bolt-t-shirt")
    private  WebElement tShirtAddToCarButton;

    @FindBy(className = "inventory_item_price")
    private List<WebElement> inventoryPrices;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
    private WebElement backPackCost;


    @FindBy(css = "[data-test=\"product_sort_container\"]")
    private WebElement sortDropdown;

    @FindBy(css = "[value=lohi]")
    private WebElement lowHigh;

    @FindBy(css = "[value=\"hilo\"]")
    private WebElement highLow;







    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean inventoryContainerIsDisplayed() {
        return inventoryContainer.isDisplayed();
    }

    public void allProductCardsAreVisible (){
        for (WebElement card :
                productCards){
        assertTrue(card.isDisplayed()); }
    }

    public void clickOnBackpackAddToCart(){
        backpackAddToCarButton.click();
    }
    public  void clickOnCartIcon (){
        cartIcon.click();
    }
    public  void clickOnBikeAddToCart(){
        bikeAddToCartButton.click();
       }

    public  void clickOnTshirtAddToCart(){
       tShirtAddToCarButton.click();
    }

    public String getBackPackCost(){
        return backPackCost.getText();
    }

    /*public void checkFromLowToHigh(){
        List<Double> actualPrices = new ArrayList<Double>();
        for (WebElement price:inventoryPrices){
            actualPrices.add(Double.parseDouble(price.getText().replaceAll("[^0-9.]", "")));
        }
        List<Double> expectedPrices = new ArrayList<Double>(actualPrices);
        Collections.sort(expectedPrices);
        assertEquals(actualPrices, expectedPrices);
    }*/

    /*public boolean checkFromHighToLow(){
        List<Double> actualPrices = new ArrayList<Double>();
        for (WebElement price:inventoryPrices){
            actualPrices.add(Double.parseDouble(price.getText().replaceAll("[^0-9.]", "")));
        }
        List<Double> expectedPrices = new ArrayList<Double>(actualPrices);
        expectedPrices.sort(Collections.reverseOrder());
        return actualPrices.equals(expectedPrices);
    }*/





        }



