package FinalProjekt.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import FinalProjekt.pageObjects.HomePg;

public class HomePgTest {
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	HomePg homePage;
	

	@BeforeClass
	public void openBrowser() {
		  System.setProperty(".webdriverchrome.driver", "chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void testNavigateWomen() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        wait = new WebDriverWait(driver, 20);

        // ** Hover Women Category **  - done
        WebElement women = driver.findElement(By.cssSelector("a.sf-with-ul"));
        Actions action = new Actions(driver);
        action.moveToElement(women).build().perform();

        // ** Choose Summer Dresses Category ** - done
        WebElement option = driver.findElement(By.cssSelector("[href*='id_category=11']"));
        option.click();
	}
	
	
	@Test(priority = 2)
	public void testNavigateDress() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        wait = new WebDriverWait(driver, 20);

        // ** Hover dress Category **  - done
        WebElement dress = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]"));
        Actions action = new Actions(driver);
        action.moveToElement(dress).build().perform();

        // ** Choose Summer Dresses Category ** - done
        WebElement summer = driver.findElement(By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]//a[contains(text(), \"Summer Dresses\")]"));
        summer.click();
	}
	
	
	@Test(priority = 3)
	public void testContained() {
		//proveravamo da li i women category i dress category vode na istu stranicu
		driver.navigate().to(HomePg.HOME_URL);
		homePage = new HomePg(driver);
		homePage.navigationToSubCategory(driver);
		homePage.navigationFromDressToSubCategory(driver);
		
		String actUrl = driver.getCurrentUrl();
		String expdUrl = "http://automationpractice.com/index.php?id_category=11&controller=category";
		Assert.assertTrue(actUrl.contains(expdUrl));
	}
}
