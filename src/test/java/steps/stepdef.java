package steps;

import java.io.FileInputStream;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.Scenario;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import utils.SeleniumDriver;


public class stepdef {

	//WebDriver driver=SeleniumDriver.getDriver();

	public WebDriverWait wait;
	public Scenario scenario = null;
	public Properties Pro;
		
	public static common.sharedatastep sharedata;
	
		public stepdef(common.sharedatastep sharedata) {
		
		stepdef.sharedata=sharedata;
	}
	
		 @Before(order=0)
		  public void method1()throws Exception
		  {
		     // this.S=S;
		  	Pro=new Properties();
		  	FileInputStream fip= new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\object.properties");
		  	Pro.load(fip);
		  }	
	
		 
				// Code for Launching the Browser and URL

	@Given("^Browser is opened and Maximized$")
	public void browser_is_opened_and_Maximized()  {
		
		System.out.println("browser is opened and maximized");
		
			
}
	
	@Then("^Open Application URL$")
	public void open_Application_URL() throws Throwable {
	
		
		SeleniumDriver.getDriver().get(Pro.getProperty("NRA_BackOffice_URL"));	
		
	    }	
	
	
//Code for Login web page
    @When("^Enter the username \"(.*)\" and password \"(.*)\"$")			
    public void enter_the_Username_and_Password(String username,String password) throws Throwable 							
    {	
    	  sharedata.usernm=username;
		 System.out.println("Usename from stepdef : "+username);
		 SeleniumDriver.getDriver().findElement(By.id("loginForm:username")).sendKeys(username);
		 SeleniumDriver.getDriver().findElement(By.id("loginForm:password")).sendKeys(password);
    }
    

    @Then("^click on login$")					
    public void	click_on_login() throws Throwable 							
    {		
		
    SeleniumDriver.getDriver().findElement(By.xpath("(//span[text()='Login'])[2]")).click();
    }
    
    
    
  // Code for Logout button of the application and verifying the Title of the page
 @Then("^Logot the application$")
 public void	click_on_logout() throws Throwable 
 {
		
 }
}
 
    //------ Register Individual Taxpayer Submit Scenario-------

