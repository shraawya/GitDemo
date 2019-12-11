package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RediffLoginPage {
	public WebDriver driver;

	public RediffLoginPage(WebDriver driver) {
		super();
		this.driver = driver;
	}
	
	By userName = By.id("user_email");
	By password = By.id("user_password");
	By go = By.xpath("//input[@value='Log In']");
	
	public WebElement userName() {
		return driver.findElement(userName);
	}
	public WebElement password() {
		return driver.findElement(password);
	}
	public WebElement go() {
		return driver.findElement(go);
	}

}
