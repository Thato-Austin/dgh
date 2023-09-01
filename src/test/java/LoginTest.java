import com.pages.HomePage;
import com.pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginTest  extends BaseTest{
    SoftAssert softAssert = new SoftAssert();
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Test
    public void testLogin(){
        loginPage = homePage.clickLogin();
        loginPage.enterEmail("austinsickthoughts50@gmail.com");
        loginPage.enterPassword("123459876");
        loginPage.clickSubmit();
    }
}
