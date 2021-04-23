package generic;

import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Utility {
	public static WebDriver launch(WebDriver driver,String ip,String browser)   {
		if (ip.equals("localhost")) {
			if (browser.equals("chrome")) {
				driver = new ChromeDriver();
			}else {
				driver = new FirefoxDriver();
			}
		}
		else {
			try {
				URL u =new URL("http://"+ip+":4444/wd/hub");
				DesiredCapabilities d = new DesiredCapabilities();
				d.setBrowserName(browser);
				driver = new RemoteWebDriver(u,d);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return driver;
	}
}
		
		

