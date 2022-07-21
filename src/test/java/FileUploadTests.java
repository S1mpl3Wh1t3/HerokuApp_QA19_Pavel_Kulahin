import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class FileUploadTests extends BaseTest {
    @BeforeMethod
    public void navigate() {
        driver.get("http://the-internet.herokuapp.com/upload");
    }

    @Test
    public void FileUploadTests() {

        WebElement selectFileButton = driver.findElement(By.id("file-upload"));
        selectFileButton.sendKeys(System.getProperty("user.dir") + "/src/test/java/resources/TestFile.txt");
        WebElement uploadFileButton = driver.findElement(By.id("file-submit"));
        uploadFileButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        WebElement testFile = driver.findElement(By.id("uploaded-files"));
        String uploadedFile = testFile.getText();
        Assert.assertEquals(uploadedFile, "TestFile.txt");

    }
}
