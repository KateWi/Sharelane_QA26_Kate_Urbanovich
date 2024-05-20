import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ShareLaneTests {
    private WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        this.driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        this.driver.quit();
    }

    @Test
    public void signUpPositiveTest() {
        driver.navigate().to("https://sharelane.com/cgi-bin/register.py?");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        boolean isFirstNameDisplayed = driver.findElement(By.name("first_name")).isDisplayed();
        Assert.assertTrue(isFirstNameDisplayed, "firstNameInput is displayed");


    }

    @Test
    public void signUpNegativeTest() {
        driver.navigate().to("https://sharelane.com/cgi-bin/register.py?");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("123");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("span[class=error_message]")).isDisplayed(), "firstNameInput isn't displayed");
        Assert.assertEquals(driver.findElement(By.cssSelector("span[class=error_message]")).getText(), "Oops, error on page. ZIP code should have 5 digits");

    }

    @Test
    public void RegistrationFormPositiveTest() {
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
        Assert.assertTrue(driver.findElement(By.cssSelector("span[class=confirmation_message]")).isDisplayed(), "account created");
        Assert.assertEquals(driver.findElement(By.cssSelector("span[class=confirmation_message]")).getText(), "Account is created!");
    }

    @Test
    public void RegistrationFormNegativeTest() {
        driver.navigate().to("https://sharelane.com/cgi-bin/register.py?");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        driver.findElement(By.cssSelector("input[value=Continue]")).click();
        WebElement firsNameInput = driver.findElement(By.name("first_name"));
        firsNameInput.sendKeys("4");
        driver.findElement(By.cssSelector("input[value=Register]")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("span[class=error_message]")).isDisplayed(), "RegistrationForm invalid");
        Assert.assertEquals(driver.findElement(By.cssSelector("span[class=error_message]")).getText(), "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }
}