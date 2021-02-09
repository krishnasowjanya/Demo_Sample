package steps;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.When;
import utils.SeleniumDriver;

public class stepdefDI {

	// private static WebDriver driver;
	public WebDriverWait wait;
	public Scenario scenario = null;
	public Properties Pro = null;

	public common.sharedatastep sharedata;

	public stepdefDI(common.sharedatastep sharedata) {

		this.sharedata = sharedata;
	}

	@Before(order = 0)
	public void method1() throws Exception {
		// this.S=S;
		Pro = new Properties();
		FileInputStream fip = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\object.properties");
		Pro.load(fip);
	}

	@When("^Enter the Org Username and password \"([^\"]*)\"$")
	public void enter_the_Org_Username_and_password(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		System.out.println("sharedata username in Stepdef2 is " + sharedata.usernm);
		SeleniumDriver.getDriver().findElement(By.id("loginForm:username")).sendKeys(sharedata.usernm);
		 SeleniumDriver.getDriver().findElement(By.id("loginForm:password")).sendKeys(arg1);
	}
	// trial DI
	/*
	 * @When("^Enter Org username and password \"(.*)\"$") public void
	 * enter_Org_Username_and_Password(String password) throws Throwable {
	 * System.out.println("sharedata username in Stepdef2 is " + sharedata.usernm);
	 * 
	 * SeleniumDriver.getDriver().findElement(By.id(Pro.getProperty(
	 * "BackOffice_UserName_ID"))).sendKeys(sharedata.usernm);
	 * SeleniumDriver.getDriver().findElement(By.id(Pro.getProperty(
	 * "BackOffice_Password_ID"))).sendKeys(password); }
	 */

}
