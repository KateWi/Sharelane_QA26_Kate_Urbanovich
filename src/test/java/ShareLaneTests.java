import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShareLaneTests {
    @Test
    public void signUpPositiveTest() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://sharelane.com/cgi-bin/register.py?");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        boolean isFirstNameDisplayed = driver.findElement(By.name("first_name")).isDisplayed();
        Assert.assertTrue(isFirstNameDisplayed);
        driver.quit();

    }

    @Test
    public void signUpNegativeTest() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://sharelane.com/cgi-bin/register.py?");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("span[class=error_message]")).isDisplayed());
        driver.quit();
    }

    @Test
    public void RegistrationFormPositiveTest() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://sharelane.com/cgi-bin/register.py?");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("Ivan");
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("ivanov111@gmail.com");
        WebElement passwordFirstInput = driver.findElement(By.name("password1"));
        passwordFirstInput.sendKeys("12345qW");
        WebElement passwordConfirmInput = driver.findElement(By.name("password2"));
        passwordConfirmInput.sendKeys("12345qW");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("span[class=confirmation_message]")).isDisplayed());
        driver.quit();
    }

    @Test
    public void RegistrationFormNegativeTest() {
        RemoteWebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.navigate().to("https://sharelane.com/cgi-bin/register.py?");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("4");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("span[class=error_message]")).isDisplayed());
        driver.quit();
    }
}