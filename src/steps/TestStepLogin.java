package steps;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepLogin {


	public static WebDriver  driver;

	@Before
	public void startBrowser() {
		System.out.println("lg 1 ");
		//System.setProperty("webdriver.gecko.driver", "<path to gecko driver executable>geckodriver.exe");
		System.setProperty("webdriver.firefox.marionette","C:\\lib\\geckodriver.exe");
		System.out.println("lg 1-2 ");
		driver = new FirefoxDriver();
		System.out.println("lg 2 ");
	}

	@After
	public void quitBrowser() {
		driver.quit();
	}   


	@Given("^User in Login Page$")
	public void user_in_Login_Page() throws Throwable {

		System.out.println("lg3 ");
		driver.navigate().to("http://the-internet.herokuapp.com/login");
		System.out.println("lg4 ");
		//driver.navigate().to("http://the-internet.herokuapp.com/login");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		System.out.println("lg 5 ");
	}

	@When("^User view Login Page Successfull$")
	public void user_view_Login_Page_Successfull() throws Throwable {
		Assert.assertTrue(driver.getTitle().contains("The Internet"));		

	}

	@When("^User enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String Username, String password) throws Throwable {

		WebElement userTxtbox = driver.findElement(By.id("username")); 
		userTxtbox.sendKeys(Username);

		WebElement passwordTxtbox = driver.findElement(By.id("password")); 
		passwordTxtbox.sendKeys(password);

		WebElement loginbtn = driver.findElement(By.className("radius")); 
		loginbtn.click();    
	}

	@Then("^Message displayed ogin Page$")
	public void message_displayed_ogin_Page() throws Throwable {
		WebElement SecureHeader = driver.findElement(By.xpath("//*[@id='content'/div/h2 ]")); 
		Assert.assertTrue(SecureHeader.isDisplayed());
		//driver.quit();
	}
}