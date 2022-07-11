import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropdownTest extends BaseTest {
    By dropdownElements = By.id("dropdown");

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
    }

    @Test
    public void selectDropdownTest() throws InterruptedException {
        WebElement dropdownElement = driver.findElement(dropdownElements);
        Select select = new Select(dropdownElement);
        List<WebElement> options = select.getOptions();
        List<String> expectedOptions = new ArrayList<String>();
        List<String> actualOptions = options.stream().map(option -> option.getText()).toList();
        expectedOptions.add("Please select an option");
        expectedOptions.add("Option 1");
        expectedOptions.add("Option 2");
        Assert.assertEquals(actualOptions, expectedOptions, "Checking for the presence of all drop-down elements");
        select.selectByVisibleText("Option 1");
        String actualResultFirst = select.getFirstSelectedOption().getText();
        String expectedResultFirst = "Option 1";
        Assert.assertEquals(actualResultFirst, expectedResultFirst, "Select the first element, check that it is selected");
        select.selectByVisibleText("Option 2");
        String actualResultSecond = select.getFirstSelectedOption().getText();
        String expectedResultSecond = "Option 2";
        Assert.assertEquals(actualResultSecond, expectedResultSecond, "Select the second element, check that it is selected");
    }
}

