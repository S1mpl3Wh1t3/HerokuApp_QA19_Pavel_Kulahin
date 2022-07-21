import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;

public class ContextMenuTests extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/context_menu");
    }

    @Test
    public void ContextMenuTests() {
        Actions actions = new Actions(driver);
        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).build().perform();
        Alert alert = driver.switchTo().alert();
        String actualResult = alert.getText();
        alert.accept();
        driver.switchTo().defaultContent();
        String expectedResult = "You selected a context menu";
        Assert.assertEquals(actualResult, expectedResult);
    }


}
