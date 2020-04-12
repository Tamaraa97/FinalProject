package FinalProjekt.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import FinalProjekt.pageObjects.AddNewUser;
import FinalProjekt.pageObjects.CreateAccountPage;
import FinalProjekt.pageObjects.Read;


public class ReadTest {
	AddNewUser add;
	WebDriver driver;
	

	@BeforeMethod
	public void BeforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}


	@Test
	public void test30UsersReg() {
		Read.findExcelSheet();
		for(int i = 1; i<Read.getRowNumber(); i++) {
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");
			CreateAccountPage.inputEMail(driver, Read.EMail(i));
			driver.findElement(By.id("SubmitCreate")).click();
			CreateAccountPage.inputFirstName(driver, Read.FirstName(i));
			CreateAccountPage.inputLastName(driver, Read.LastName(i));
			CreateAccountPage.inputPassword(driver, Read.Password(i));
			CreateAccountPage.inputAddress(driver, Read.Address(i));
			CreateAccountPage.inputCity(driver, Read.City(i));
			CreateAccountPage.selectState(driver, Read.State(i));
			CreateAccountPage.inputZipPostalCode(driver, Read.Zip(i));
			CreateAccountPage.inputMobilePhone(driver, Read.getMobilePhone(i));
			CreateAccountPage.clickRegister(driver);	
			String user = driver.findElement(By.className("account")).getText();
			String expectedUser = Read.FirstName(i) +" "+ Read.LastName(i);
			Assert.assertEquals(user, expectedUser);
			driver.findElement(By.className("logout")).click();
		}
		Read.closeFis();
	}
}

