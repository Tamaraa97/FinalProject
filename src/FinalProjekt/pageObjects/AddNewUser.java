package FinalProjekt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddNewUser {

	public static String REG_URL="http://automationpractice.com/index.php?controller=order";
	public static String NEW_URL = "http://automationpractice.com/index.php?controller=authentication&multi-shipping=0&display_guest_checkout=0&back=http%3A%2F%2Fautomationpractice.com%2Findex.php%3Fcontroller%3Dorder%26step%3D1%26multi-shipping%3D0#account-creation";


	WebDriver driver;
	WebDriverWait wait;
	By newProceed = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
	By email = By.id("email_create");
	By submit = By.id("SubmitCreate");

	    public void typeInField(By by, String msg) {
	        WebElement element = driver.findElement(by);
	        element.click();
	        element.clear();
	        element.sendKeys(msg);
	    }

	    public void selectElement(By by, String value) {
	        Select select = new Select(driver.findElement(by));
	        select.selectByValue(value);
	    }

	    public boolean isElementPresent(By by) {
	        try {
	            driver.findElement(by);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	    }

	    public void waitForElement(By by) {
	        wait.until(ExpectedConditions.presenceOfElementLocated(by));
	    }
   
	public void newProceed(WebDriver driver) {
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		WebElement el2 = wait2.until(ExpectedConditions.elementToBeClickable(newProceed));
		el2.click();
	}
	
	public void inputEmail(WebDriver driver, String emailAdrs) {
		WebElement element = driver.findElement(email);
		element.sendKeys(emailAdrs);
	}
	
	public void clickSubmit(WebDriver driver) {
		WebElement element = driver.findElement(submit);
		element.click();
	}
	

	
}
