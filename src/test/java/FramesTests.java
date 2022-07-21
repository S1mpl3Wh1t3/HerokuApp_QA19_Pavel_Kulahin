import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FramesTests extends BaseTest {

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/frames");
    }

    @Test
    public void FramesTests() {
        WebElement iFrame = driver.findElement(By.xpath("//a[text()='iFrame']"));
        iFrame.click();
        driver.switchTo().frame("mce_0_ifr");
        WebElement text = driver.findElement(By.xpath("//p[text()='Your content goes here.']"));
        Assert.assertEquals(text.getText(), "Your content goes here.");


    }
}
