import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class Cart extends BasePage {
    public Cart(WebDriver driver) {
        super(driver);
    }


    @FindBy(className = "cart_item")
    private List<WebElement> items;

     @FindBy (className = "inventory_item_price")
    private List<WebElement> itemPrices;


    public boolean firstItemIsDisplayed() {
        return items.get(0).isDisplayed();
    }

    public int getItemsQuantity() {
        return items.size();
    }

    public boolean allItemsIsDisplayed() {

        return allElementsCollectionAreDisplayed(items);

    }

    public boolean cartIsEmpty() {
        boolean empty = false;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
          wait.until(ExpectedConditions.visibilityOf(items.get(0)));

        }catch (Exception e){
            empty = true;
        }
      return empty;

    }

  public String getPriceOfFirstItem (){
        return itemPrices.get(0).getText();
  }







}