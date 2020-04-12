package FinalProjekt.test;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import FinalProjekt.pageObjects.AddSummerDresses;




public class AddDressesTest extends HomePgTest{
	JavascriptExecutor js;
	AddSummerDresses add;
	AddSummerDresses shop;
	
	@Test(priority=4)
	   public void testAdd() {
		//testiramo da li mozemo da dodamo zeljenu haljinu
	   js = (JavascriptExecutor) driver;
		driver.navigate().to(AddSummerDresses.URL);
		add = new AddSummerDresses();
		js.executeScript("window.scrollBy(0,500)");
		add.view(driver);
		add.plus(driver);
		add.size(driver);
		add.color(driver);
		js.executeScript("window.scrollBy(0,500)");
		add.add(driver);
		
		String acctualUrl = driver.getCurrentUrl();
		String expectedUrl = "http://automationpractice.com/index.php?id_product=5&controller=product";
		Assert.assertTrue(acctualUrl.contains(expectedUrl));
		
	   }
	
	@Test(priority=5)
	   public void testProceed() {
		   driver.navigate().to(AddSummerDresses.NEW_URL);
		   shop = new AddSummerDresses();
		   shop.proceed(driver);
		   
		   String acttualUrl = driver.getCurrentUrl();
		   String expectedUrl = "http://automationpractice.com/index.php?controller=order";
		   Assert.assertTrue(acttualUrl.contains(expectedUrl));
	   }
}
