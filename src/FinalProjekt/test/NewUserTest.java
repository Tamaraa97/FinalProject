package FinalProjekt.test;

import org.testng.annotations.Test;
import org.testng.Assert;
import FinalProjekt.pageObjects.AddNewUser;

public class NewUserTest extends AddDressesTest{
	AddNewUser reg;
	AddNewUser user;
	
	 @Test(priority=6)
	   public void testNewProceed() {
		 //testiramo sledece dugme proceed
		   driver.navigate().to(AddNewUser.REG_URL);
		   reg = new AddNewUser();
		   reg.newProceed(driver);
		   reg.inputEmail(driver, "pecnikje@yahoo.com");
		   reg.clickSubmit(driver);
	
	
		  String acttualUrl = driver.getCurrentUrl();
		   String expectedUrl = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0";
		   Assert.assertTrue(acttualUrl.contains(expectedUrl));
	   }
	 

}
