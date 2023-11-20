package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest{
    String baseUrl = "https://the-internet.herokuapp.com/login";

    @Before
    public void SetUp(){
        openBrowser(baseUrl);
        System.out.println("opening the Browser");
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        // Enter userName on userName field
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");
        // Enter password on password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        //Click on loginButton
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']") );
        loginButton.click();

        String expectedText = "Secure Area";
        WebElement actualTextElement = driver.findElement(By.xpath("//h2[normalize-space()='Secure Area']") );
       String actualText = actualTextElement.getText();
       // Verifying actual and expected text
        Assert.assertEquals(expectedText,actualText);

    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        // Enter userName on userName field
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith1");
        // Enter password on password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");
        //Click on loginButton
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();
        String expectedText = "Your username is invalid!\n×";

        WebElement actualTextElement = driver.findElement(By.id("flash"));
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Your password is invalid!\n×",expectedText,actualText );
    }
    @Test
    public void verifyThePasswordErrorMessage() {
        // Enter userName on userName field
        WebElement userNameField = driver.findElement(By.id("username"));
        userNameField.sendKeys("tomsmith");
        // Enter password on password field
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword");
        //Click on loginButton
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='radius']"));
        loginButton.click();
        String expectedText = "Your password is invalid!\n×";
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']") );
        String actualText = actualTextElement.getText();
        Assert.assertEquals("Your password is invalid!\n×",expectedText, actualText  );
    }
    @After
    public void tearDown(){
        closeBrowser();
        System.out.println("Closing browser");
    }

    }

