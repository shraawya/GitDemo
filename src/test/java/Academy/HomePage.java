package Academy;
import org.apache.logging.log4j.LogManager;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Resources.Base;
import pageObjects.RediffHomePage;
import pageObjects.RediffLoginPage;

public class HomePage extends Base {
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void Initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is initiated");
		
	}
	
	@Test(dataProvider="getData")
	public void basePageNvigation(String userName,String password) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("navigated to home page");
		
		
		RediffHomePage home = new RediffHomePage(driver);
		Assert.assertEquals(home.title().getText(), "FEATURED COURSES123");
		Assert.assertTrue(home.navbar().isDisplayed());
		
		home.login().click();
		
		
		RediffLoginPage logPage = new RediffLoginPage(driver);
		logPage.userName().sendKeys(userName);
		logPage.password().sendKeys(password);
		
		logPage.go().click();
		
		
	}
	
	@AfterTest
	public void closeBrowser() {
		driver.close();
		driver=null;
	}
	
	@DataProvider
	public Object[][] getData() {
		//username - restricted and non restricted users
		//password -  ,,
		//text     - print if its restricted or non restricted
		
		//1st set of data
		Object[][] ob = new Object[3][2];
		ob[0][0]= "Sweeya@gmail.com";
		ob[0][1]="1234";
	//ob[0][2]="Restricted user";
		
		//2nd set of data
		ob[1][0]= "Shravyaa@gmail.com";
		ob[1][1]="123456";
		//ob[1][2]="Non Restricted user";
		
		//3rd set of data
		ob[2][0]= "Sridhar@gmail.com";
		ob[2][1]="1234_56";
		//ob[1][2]="Non Restricted user";
		return ob;
		
	}

}
