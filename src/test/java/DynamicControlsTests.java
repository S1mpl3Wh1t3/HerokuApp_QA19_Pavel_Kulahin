import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DynamicControlsTests extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
    }

    @Test
    public void DynamicControlsTests() {
        WebElement box = driver.findElement(By.cssSelector("[type='checkbox']"));
        box.click();
        WebElement button = driver.findElement(By.xpath("//button[text()='Remove']"));
        button.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        List<WebElement> boxes = driver.findElements(By.cssSelector("[type='checkbox']"));
        Assert.assertEquals(boxes.size(), 0);
        WebElement input = driver.findElement(By.cssSelector("[type='text']"));
        input.isEnabled();
        Assert.assertEquals(input.isEnabled(), false);
        WebElement enableButton = driver.findElement(By.xpath("//button[text()='Enable']"));
        enableButton.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(input.isEnabled(), true);


    }
}