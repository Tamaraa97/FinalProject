package FinalProjekt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSummerDresses {
	public static String URL= "http://automationpractice.com/index.php?id_category=11&controller=category";
	public static String NEW_URL = "http://automationpractice.com/index.php?id_product=5&controller=product#/color-blue/size-m";

	By view = By.linkText("Printed Summer Dress");
	By plus = By.className("icon-plus");
	By size = By.id("group_1");
	By color = By.id("color_14");
	By add = By.xpath("//p[@id='add_to_cart']/button/span");
	By proceed = By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
	By newProceed = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]/span");
	
	
	public void view(WebDriver driver) {
		WebElement element1 = driver.findElement(view);
		element1.click();
	}
	
	public void plus(WebDriver driver) {
		WebElement element2 = driver.findElement(plus);
		element2.click();
	}
	
	public void size(WebDriver driver) {
		Select dropdown  = new Select(driver.findElement(size));
		dropdown.selectByValue("2");
	}
	
	public void color(WebDriver driver) {
		WebElement element4 = driver.findElement(color);
		element4.click();
	}
	
	public void add(WebDriver driver) {
		WebElement element5 = driver.findElement(add);
		element5.click();
	}
	
	public void proceed(WebDriver driver) {
		//WebElement shop = driver.findElement(proceed);
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		WebElement el1 = wait1.until(ExpectedConditions.elementToBeClickable(proceed));
		el1.click();
		//shop.click();
	}
	
	

}
