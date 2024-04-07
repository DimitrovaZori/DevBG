import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Pagnation {
    @Test
    public void paginationTest() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pagination.js.org/");

        WebElement demo1 = driver.findElement(By.id("demo1"));

        List<WebElement> items = demo1.findElements(By.cssSelector(".data-container ul li"));
        List <WebElement> pagination = demo1.findElements(By.cssSelector(".paginationjs-pages ul li"));

        pagination.get(2).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.stalenessOf(items.get(0)));

        items = demo1.findElements(By.cssSelector(".data-container ul li"));
        assertTrue(items.get(0).getText().equals("11"));

    }

    @Test

    public void dynamic(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        // WebElement button = driver.findElement(By.xpath("//*[contains(text(), 'Start')]"));
        WebElement button = driver.findElement(By.xpath("//div[@id ='start']/button"));
        button.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement helloWorldText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id ='finish']/h4")));

        assertEquals("Hello World!",helloWorldText.getText());
    }

    @Test

    public void sliderTest(){
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        WebElement slider = driver.findElement(By.cssSelector(".form-range"));
        Actions moveSlider = new Actions(driver);
        moveSlider.clickAndHold(slider).moveByOffset(40,0).perform();



    }
}
