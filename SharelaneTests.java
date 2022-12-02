import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;


public class SharelaneTests {WebDriver driver;

    @AfterMethod(alwaysRun = true)
    public void closeDriver() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    public void positiveZipCodeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("12345");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertEquals(zipCodeInput.isDisplayed(), false);

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);
    }
    @Test
    public void negativZipCodeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.sharelane.com/cgi-bin/register.py");
        WebElement zipCodeInput = driver.findElement(By.name("zip_code"));
        zipCodeInput.sendKeys("1111");
        WebElement continueButton = driver.findElement(By.cssSelector("[value=Continue]"));
        continueButton.click();
        zipCodeInput = driver.findElement(By.name("zip_code"));
        Assert.assertEquals(zipCodeInput.isDisplayed(), false);

        WebElement firstNameInput = driver.findElement(By.name("first_name"));
        Assert.assertEquals(firstNameInput.isDisplayed(), true);





}
 @Test
    public void PozitivSignUp(){
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
     WebElement FirstNameInput = driver.findElement(By.name("first_name"));
     FirstNameInput.sendKeys("Alex");
     WebElement LastNameInput = driver.findElement(By.name("last_name"));
     LastNameInput.sendKeys("Vereshako");
     WebElement EmailInput = driver.findElement(By.name("email"));
     EmailInput.sendKeys("sobaka@gmail.ru");
     WebElement PasswordInput = driver.findElement(By.name("password1"));
     PasswordInput.sendKeys("qwe123qwe123");
     WebElement DoublePasswordInput = driver.findElement(By.name("password2"));
     DoublePasswordInput.sendKeys("qwe123qwe123");
     WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
     registerButton.click();
     WebElement RigesterInput = driver.findElement(By.cssSelector("span.confirmation_message"));
     Assert.assertEquals(RigesterInput.getText(), "Account is created!");
 }
 @Test
    public void   NegativSignUp(){
     WebDriverManager.chromedriver().setup();
     driver = new ChromeDriver();
     driver.manage().window().maximize();
     driver.get("https://www.sharelane.com/cgi-bin/register.py?page=1&zip_code=11111");
     WebElement FirstNameInput = driver.findElement(By.name("first_name"));
     FirstNameInput.sendKeys("Alex");
     WebElement LastNameInput = driver.findElement(By.name("last_name"));
     LastNameInput.sendKeys("Vereshako");
     WebElement EmailInput = driver.findElement(By.name("email"));
     EmailInput.sendKeys("1sdasdasd");
     WebElement PasswordInput = driver.findElement(By.name("password1"));
     PasswordInput.sendKeys("qwe123qwe123");
     WebElement DoublePasswordInput = driver.findElement(By.name("password2"));
     DoublePasswordInput.sendKeys("qwe123qwe123");
     WebElement registerButton = driver.findElement(By.cssSelector("[value=Register]"));
     registerButton.click();
     WebElement RigesterInput = driver.findElement(By.cssSelector("span.error_message"));
     Assert.assertEquals(RigesterInput.getText(), "Oops, error on page. Some of your fields have invalid data or email was previously used");
    }



}
