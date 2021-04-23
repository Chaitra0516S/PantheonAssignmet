package generic;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements IAutoConst {
	public static String getPropertyValue(String path, String key) {
		String v ="";
		
		try {
			Properties p = new Properties();
			p.load(new FileInputStream(path));
			v=p.getProperty(key);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return v;
		
	}
	
	public WebDriver driver=new  ChromeDriver();
	static {
		System.setProperty(CHROME_KEY,CHROME_VALUE );
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@BeforeTest
	public void openBrowser() {
		Utility.launch(driver, "localhost", "chrome");
		driver.get("http://www.demoblaze.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}
	
	@AfterTest
	public void closeApplication() {
		driver.quit();
	}
	
}