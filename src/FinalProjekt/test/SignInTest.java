package FinalProjekt.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import FinalProjekt.pageObjects.Read;
import FinalProjekt.pageObjects.SignInPage;

public class SignInTest {
	
	WebDriver driver;

	@BeforeMethod
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void SignIn() {
		Read.findExcelSheet();
		for(int i = 1; i<Read.getRowNumber(); i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			//driver.findElement(By.className("login"));
			SignInPage.EMail(driver, Read.EMail(i));
			SignInPage.Password(driver, Read.Password(i));
			SignInPage.SignIn(driver);
			String user = driver.findElement(By.className("account")).getText();
			String expectedUser = Read.FirstName(i) +" "+ Read.LastName(i);
			Assert.assertEquals(user, expectedUser);
			driver.findElement(By.className("logout")).click();
	}

}
}
