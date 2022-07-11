import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InputsTest extends BaseTest {
    By input = By.tagName("input");

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/inputs");
    }

    @Test
    public void inputsTest() throws InterruptedException {
        WebElement inputs = driver.findElement(input);
        inputs.click();
        inputs.sendKeys("wwwwww{];:");
        String actualResult = inputs.getAttribute("value");
        String expectedResult = "";
        Assert.assertEquals(actualResult, expectedResult, " ");
        inputs.sendKeys("8");
        inputs.sendKeys(Keys.ARROW_UP);
        inputs.sendKeys(Keys.ARROW_UP);
        inputs.sendKeys(Keys.ARROW_UP);
        inputs.sendKeys(Keys.ARROW_DOWN);
        inputs.sendKeys(Keys.ARROW_DOWN);
        inputs.sendKeys(Keys.ARROW_DOWN);
        inputs.sendKeys(Keys.ARROW_DOWN);
        actualResult = inputs.getAttribute("value");
        expectedResult = "7";
        Assert.assertEquals(actualResult, expectedResult, " ");
    }
}
