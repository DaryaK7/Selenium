import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class DragAndDropTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://learn.javascript.ru/article/mouse-drag-and-drop/ball4/");
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void drawSquare() {
        WebElement ball = driver.findElement(By.id("ball"));
        Actions drawSquare = new Actions(driver);
        drawSquare.dragAndDropBy(ball,100,0).perform();
        drawSquare.dragAndDropBy(ball,0,100).perform();
        drawSquare.dragAndDropBy(ball,-100,0).perform();
        drawSquare.dragAndDropBy(ball,0,-100).perform();
    }

    @Test
    public void contextClick() {
        WebElement goal = driver.findElement(By.id("gate"));
        Actions contextClick = new Actions(driver);
        contextClick.contextClick(goal).perform();
    }
}
