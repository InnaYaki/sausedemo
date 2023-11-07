import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    ChromeDriver driver;
    String BASE_URL = "https://www.saucedemo.com/";

    @Before

    public void SetUp(){
        System.setProperty("web-driver.chrome.driver", "/Users/inna/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get(BASE_URL);
    }

    public String validUserName = "standard_user";
    public String lockedOutUserName = "locked_out_user";
    public String validPassword = "secret_sauce";

    public String invalidUserName = "hjuiifff";
    public  String invalidPassword = "jkiggff";



    @After
    public void tearDown(){
        driver.quit();
    }





}

