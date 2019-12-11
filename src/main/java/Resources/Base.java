package Resources;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.apache.commons.io.FileUtils;


public class Base {
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		
		 prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\Sridhar\\Project\\src\\main\\java\\Resources\\dataDriven.properties");
		prop.load(fis);
		
		
		String browserName = prop.getProperty("browser");
		
		if(browserName.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sridhar\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.contains("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Sridhar\\geckodriver.exe");
			driver= new FirefoxDriver();
		}
		/*else {
			System.setProperty("webdriver.ie.driver", "C:\\Users\\Sridhar\\IESdriver.exe");
			driver = new InternetExplorerDriver();
		}*/
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}
	
	public void getScreenShots(String result) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C://test//"+result+"screenshot.png"));
		
	}
	

}
