package StepDefs;

import Init.DriverInit;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class StepDefinitons extends DriverInit {
    public WebDriver driver;


    @Given("{string} and user is on Main Page")
    public void Navigate(String browser) {
        if (browser.equalsIgnoreCase("chrome")) {
            driver = GetChromeDriver();
            driver.get("https://www.yemeksepeti.com/en/ankara");
        } else {
            driver = GetGeckoDriver();
            driver.get("https://www.yemeksepeti.com/en/ankara");
        }
    }

    @When("user enters username as {string}")
    public void UsernameEntry(String username) {
        driver.findElement(By.id("UserName")).sendKeys(username);
    }

    @And("user enters password as {string}")
    public void PasswordEntry(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("user hits login")
    public void Proceed() {
        driver.findElement(By.id("ys-fastlogin-button")).click();
    }
    @And("user searchs for {string} selects with home address")
    public void SearchForPlace(String place){
        WebElement staticDropDown = driver.findElement(By.id("ys-areaSelector"));
        Select dropdown = new Select(staticDropDown);
        dropdown.selectByVisibleText("Yenimahalle (Ragıp Tüzün Mah.)");
        driver.findElement(By.id("search-loading-wrapper")).sendKeys(place);
        driver.findElement(By.xpath("(//button[@type='button'])[1]")).click();


    }
    @And("user adds place to favourites")
    public void AddPlace(){
        driver.findElement(By.className("ys-result-header")).click();
        driver.findElement(By.className("social_action")).click();

    }

    @Then("username should be {string}")
    public void LoginCheck(String expected) {
        String actual = driver.findElement(By.id("ysUserName")).getText();
        Assert.assertEquals(actual, expected);
    }
    @Then("favourite places include {string}")
    public void FavouriteCheck(String expected){
        driver.findElement(By.className("ys-pullRight")).click();
        driver.findElement(By.xpath("//a[text()='Favorilerim']")).click();
        String actual = "";
        if(expected.equalsIgnoreCase("Good Beef")){
            actual = driver.findElement(By.xpath("//b[contains(text(),'Good Beef')]")).getText();
        }
        else{
            actual = driver.findElement(By.xpath("//b[contains(text(),'Ekrem Coşkun')]")).getText();
        }
        boolean doesInclude = actual.contains(expected);
        Assert.assertTrue(doesInclude);
    }


    @After()
    public void teardown() {
        driver.quit();
    }


}

