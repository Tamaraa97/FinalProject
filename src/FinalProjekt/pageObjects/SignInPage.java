package FinalProjekt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage {
	private static final String MAIL = "#email";
	//private static final String EMAIL = "//input[@id='email']";
	private static final String PASSWORD = "//input[@id='passwd']";
	private static final String SIGN_IN = "//p[@class='submit']//span[1]";
	
	public static void EMail(WebDriver driver, String email) {
		driver.findElement(By.cssSelector(MAIL)).sendKeys(email);
		//driver.findElement(By.xpath(EMAIL)).sendKeys(email);
	}
	
	public static void Password(WebDriver driver, String password) {
		driver.findElement(By.xpath(PASSWORD)).sendKeys(password);
	}
	
	public static void SignIn(WebDriver driver) {
		driver.findElement(By.xpath(SIGN_IN)).click();
	}
}
