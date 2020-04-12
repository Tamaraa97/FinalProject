package FinalProjekt.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;
import FinalProjekt.pageObjects.CreateAccountPage;
import FinalProjekt.pageObjects.SignInPage;



public class CreateAccountTest  {

	WebDriver driver;
	SoftAssert sa;
	SignInPage user;
	@BeforeClass
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		sa = new SoftAssert();
		driver.manage().window().maximize();
	}

	@Test(priority=7)
	public void RegisterCustomert() {
		//proveravamo da li mozemo da popunimo informacije na stranici personal information
		driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0#account-creation");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//trebalo bi promeniti adresu kako bi korisnik mogao da se uloguje,svaki put kada pokrecemo
		CreateAccountPage.inputEMail(driver, "jjovanovicc@gmail.com");
		CreateAccountPage.clickCreateAnAccount(driver);
		CreateAccountPage.inputFirstName(driver, "Tamara");
		CreateAccountPage.inputLastName(driver, "Pecnik");
		CreateAccountPage.inputPassword(driver, "hdjjdk");
		CreateAccountPage.inputAddress(driver, "Mladena Mitrica");
		CreateAccountPage.inputCity(driver, "New York");
		CreateAccountPage.selectState(driver, "New York");
		CreateAccountPage.inputZipPostalCode(driver, "11000");
		CreateAccountPage.inputMobilePhone(driver, "06925373737");
		CreateAccountPage.clickRegister(driver);	
		String user = driver.findElement(By.className("account")).getText();
		System.out.println(user);
		Assert.assertEquals(user, "Tamara Pecnik");

	}
	
	   @Test(priority=8)
	   public void testX() {
		   //odlazimo na nas account nakon sto smo se ulogovali,idemo na signout,i pokusavamo opet da se ulogujemo
		   driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		   driver.findElement(By.className("logout")).click();
		   user = new SignInPage();
		   user.EMail(driver, "pecniktamara1997@yahoo.com");
		   user.Password(driver, "sjsjsdd");
		   driver.findElement(By.id("SubmitLogin")).click();
		   
		   String acttualUrl = driver.getCurrentUrl();
		   String expectedUrl = "http://automationpractice.com/index.php?controller=my-account";
		   Assert.assertTrue(acttualUrl.contains(expectedUrl));
	   }
	
}
