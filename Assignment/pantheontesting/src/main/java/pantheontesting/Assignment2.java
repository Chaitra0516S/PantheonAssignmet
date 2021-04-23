package pantheontesting; //failed testcase

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class Assignment2 extends BaseTest{
	@Test (priority = 1)
	public void initiatePurchase() throws InterruptedException {
	driver.findElement(By.xpath ("//a[contains(text(), 'Nexus 6')]")).click();
	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(), 'Add to cart')]")).click();
	Thread.sleep(2000);
	driver.switchTo().alert().accept();	
	driver.findElement(By.id("cartur")).click();
	Assert.fail();
	driver.findElement(By.xpath("//button[contains(text(), 'Place Order')]")).click();
	Reporter.log("Order has been placed", true);
	Reporter.log("Purchase has been initiated", true);
	
	}


}
