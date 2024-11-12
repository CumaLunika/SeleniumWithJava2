import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class saucedemocheckout {

    WebDriver driver;

    @Test
    public void LoginWithValidDetails() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
        driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

        String Header = driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/span")).getText();

        Assert.assertEquals(Header, "Products");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a/span")).click();
        driver.findElement(By.xpath("//div[@id='header_container']/div[2]")).isDisplayed();
        driver.findElement(By.id("checkout")).click();

        driver.findElement(By.xpath("//span[contains(.,'Checkout: Your Information')]")).isDisplayed();
        driver.findElement(By.id("first-name")).sendKeys("Don");
        driver.findElement(By.id("last-name")).sendKeys("Dada");
        driver.findElement(By.id("postal-code")).sendKeys("1632");
        driver.findElement(By.id("continue")).click();

        driver.findElement(By.xpath("//span[contains(.,'Checkout: Overview')]")).isDisplayed();
        driver.findElement(By.id("finish")).click();

        driver.findElement(By.xpath("//span[contains(.,'Checkout: Complete!')]")).isDisplayed();

        driver.quit();




    }


}
