package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {
	
	public WebDriver driver;
	
	
	
	public RediffHomePage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	By login= By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span");
	By title = By.cssSelector("[class='text-center']");
	By navbar = By.xpath("//*[@id=\"homepage\"]/header/div[2]");
	
	public WebElement login() {
		return driver.findElement(login);
	}
	
	public WebElement title() {
		return driver.findElement(title);
	}
	
	public WebElement navbar() {
		return driver.findElement(navbar);
	}
	

}
