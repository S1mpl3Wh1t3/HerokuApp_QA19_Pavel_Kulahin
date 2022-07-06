import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddRemoveElementsTests extends BaseTest {
    By addButtons = By.xpath("//button[text()='Add Element']");
    By deleteButton = By.xpath("//button[text()='Delete']");

    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
    }

    @Test
    public void addRemoveElementsTest() throws InterruptedException {
        WebElement addButton = driver.findElement(addButtons);
        List<WebElement> deleteButtons = driver.findElements(deleteButton);
        deleteButtons.isEmpty();
        addButton.click();
        addButton.click();
        deleteButtons = driver.findElements(deleteButton);
        deleteButtons.get(0).click();
        deleteButtons = driver.findElements(deleteButton);
        int actualResult = deleteButtons.size();
        int expectedResult = 1;
        Assert.assertEquals(actualResult, expectedResult, "Checking for the number of elements");


    }


}


