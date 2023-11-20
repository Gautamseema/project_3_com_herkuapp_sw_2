package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class BaseTest {
    static String browser = "Chrome";
    static String baseUrl = "https://the-internet.herokuapp.com/login";
    public static WebDriver driver;

    public void openBrowser(String basUrl){
        if(browser.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if(browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if(browser.equalsIgnoreCase("Edge")) {
            driver  = new EdgeDriver();
        }else {
            System.out.println("Wrong Browser name");
        }
        // open the Url into the browser
        driver.get(baseUrl);
        // maximise the browser
        driver.manage().window().maximize();
        // Give implicit wait to driver
        driver .manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    public void closeBrowser(){
        driver.quit();
    }
}
