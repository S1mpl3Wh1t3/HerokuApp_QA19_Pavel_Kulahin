import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class NotificationMessageTest extends BaseTest {

    By ClickHere = By.linkText("Click here");

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
    }

    @Test
    public void notificationMessageTest() throws InterruptedException {
        String textExpected = "Action successful";
        WebElement clickHere = driver.findElement(ClickHere);
        clickHere.click();
        WebElement notificationMessage = (new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("flash"))));
        String textActual = notificationMessage.getText();
        Assert.assertEquals(textActual, textExpected, " ");
    }
}
