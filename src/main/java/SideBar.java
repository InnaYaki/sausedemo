import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.lang.Thread.sleep;

public class SideBar extends BasePage {



    @FindBy (id = "react-burger-menu-btn")
    WebElement  openSideBarButton;
    @FindBy (className = "bm-menu-wrap")
    WebElement SideBarMenu;

     @FindBy (id = "inventory_sidebar_link")
    WebElement allItemsLink;

    @FindBy (id = "about_sidebar_link" )
    WebElement aboutLink;

    @FindBy (id = "logout_sidebar_link")
    WebElement logoutLink;

    @FindBy (id = "reset_sidebar_link")
    WebElement resetAppStateLink;

    @FindBy (id ="react-burger-cross-btn")
    WebElement closeSideBarButton;

    public SideBar (WebDriver driver) {
        super(driver);
    }

   public boolean openSideBarButtonIsDisplayed (){
      return openSideBarButton.isDisplayed();
   }

    public boolean allItemsLinkIsDisplayed () throws InterruptedException {
        sleep(2000);
        return allItemsLink.isDisplayed();
    }

    public boolean aboutLinkIsDisplayed ()
    {
        return aboutLink.isDisplayed();
    }

    public boolean logoutLinkIsDisplayed ()
    {
        return logoutLink.isDisplayed();
    }
    public boolean resetAppLinkIsDisplayed ()
    {
        return resetAppStateLink.isDisplayed();
    }

    public boolean closeSideBarButtonIsDisplayed (){
        return closeSideBarButton.isDisplayed();
    }

    public void openSideBar(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(openSideBarButton));

        openSideBarButton.click();
        //wait.until(ExpectedConditions.visibilityOf(SideBarMenu));
    }
    public void closeSideBar(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(allItemsLink));
       closeSideBarButton.click();
}
    public void sideBarHasHidden (){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.attributeToBe(SideBarMenu,"aria-hidden","true"));
    }
 public  void clickOnResetAppState (){

     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    wait.until(ExpectedConditions.visibilityOf(resetAppStateLink));
    resetAppStateLink.click();
    }




}
