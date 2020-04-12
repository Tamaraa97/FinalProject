package FinalProjekt.pageObjects;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePg {
	public static String HOME_URL = "http://automationpractice.com/index.php?id_category=3&controller=category";
	WebDriver driver;
	  static By womenCategory = By.cssSelector("a.sf-with-ul");
	  //static By dressCategory = By.cssSelector("a.sf-with-ul");
	  static By dressCategory = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]");
	  static By subcategory = By.cssSelector("[href*='id_category=11']");
	  static By summerSubCategory = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]");
	
	public HomePg(WebDriver driver) {
		this.driver = driver;
	}
	
	public static void	navigationToSubCategory(WebDriver driver) {
		Actions action = new Actions(driver);
		if (action.moveToElement(driver.findElement(womenCategory)) != null) {
            action.moveToElement(driver.findElement(womenCategory))
                    .build()
                    .perform();
        }
        try {
            driver.findElement(subcategory).click();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }	 
	}

	public static void navigationFromDressToSubCategory(WebDriver driver) {
		Actions action = new Actions(driver);
		if(action.moveToElement(driver.findElement(dressCategory)) != null) {
			action.moveToElement(driver.findElement(dressCategory))
				.build()
				.perform();
			
		}
		try {
			driver.findElement(summerSubCategory).click();
		} catch(NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	
    
      
}
