import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LitecartTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://litecart.stqa.ru/en/");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void homeLink() {
        WebElement homeLink = driver.findElement(By.cssSelector("i[class='fa fa-home']"));
        homeLink.click();
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(), "Online Store | My Store1");
    }

    @Test
    public void rubberDucksLink() {
        WebElement rubberDucksLink = driver.findElement(By.cssSelector("#site-menu .category-1>a"));
        rubberDucksLink.click();
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(), "Rubber Ducks | My Store1");
    }

    @Test
    public void deliveryLink() {
        WebElement deliveryLink = driver.findElement(By.cssSelector("#site-menu .page-2>a"));
        deliveryLink.click();
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(), "Delivery Information | My Store1");
    }
    @Test
    public void termsConditionsLink() {
        WebElement deliveryLink = driver.findElement(By.cssSelector("#site-menu .page-4>a"));
        deliveryLink.click();
        driver.getTitle();
        Assert.assertEquals(driver.getTitle(), "Terms & Conditions | My Store1");
    }
}
