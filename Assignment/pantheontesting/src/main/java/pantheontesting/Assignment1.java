package pantheontesting; //pass testcase

import org.openqa.selenium.By;
import org.testng.Reporter;
import org.testng.annotations.Test;

import generic.BaseTest;

public class Assignment1 extends BaseTest{
	@Test (priority = 1)
		public void initiatePurchase() throws InterruptedException {
		driver.findElement(By.xpath ("//a[contains(text(), 'Nexus 6')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(), 'Add to cart')]")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();	
		Reporter.log("Purchase has been initiated", true);
		}
	
	@Test (priority = 2)
	   public void placeOrder() {
		driver.findElement(By.id("cartur")).click();
		driver.findElement(By.xpath("//button[contains(text(), 'Place Order')]")).click();
		Reporter.log("Order has been placed", true);
	}
	
	@Test (priority = 3)
	   public void completeOrder()  {
  //  	String name = BaseTest.getPropertyValue("/pantheontesting/config.properties", "name");  
//    	String country = BaseTest.getPropertyValue("/pantheontesting/config.properties", "country");
//		String city= BaseTest.getPropertyValue("/pantheontesting/config.properties", "city");
//    	String card = BaseTest.getPropertyValue("/pantheontesting/config.properties", "card");
//		String month = BaseTest.getPropertyValue("/pantheontesting/config.properties", "month");
//    	String year = BaseTest.getPropertyValue("/pantheontesting/config.properties", "year");
//	
		
		driver.findElement(By.id("name")).sendKeys("Chaitra");
		driver.findElement(By.id("country")).sendKeys("India");
		driver.findElement(By.id("city")).sendKeys("Bangalore");
		driver.findElement(By.id("card")).sendKeys("4811 1111 1111 1114");
		driver.findElement(By.id("month")).sendKeys("Dec-24");
		driver.findElement(By.id("year")).sendKeys("123");
		driver.findElement(By.xpath("//button[contains(text(), 'Purchase')]")).click();	
		Reporter.log("Order has been completed", true);
	}
	
	
}
