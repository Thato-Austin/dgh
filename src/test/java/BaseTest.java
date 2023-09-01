import com.pages.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

public class BaseTest {
    private WebDriver driver;

    protected HomePage homePage;

    private final String URL = "https://ecommerce-playground.lambdatest.io/index.php?route=common/home";

    @BeforeClass
    public void setUp() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass
    public void QuitBrowser() {
        driver.quit();
    }

    @BeforeMethod
    public void loadSite(){
        driver.get(URL);
        homePage = new HomePage();
    }

    @AfterMethod
    public void testFailScreenshot(ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()){
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File source = screenshot.getScreenshotAs(OutputType.FILE);
            File destination = new File(System.getProperty("user.dir") +
                    "/resources/screenshot/" + testResult.getName() + ".png");

            try{
                FileHandler.copy(source, destination);
            } catch (IOException e){
                e.printStackTrace();
            }

        }
    }
}
