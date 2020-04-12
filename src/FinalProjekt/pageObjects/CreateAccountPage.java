package FinalProjekt.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;



public class CreateAccountPage {
	WebDriver driver;

	private static final String EMAIL_INPUTBOX = "//input[@id='email_create']";
	private static final String CREATE_ACC_BTN = "//form[@id='create-account_form']//span[1]";
	private static final String FIRST_NAME = "//input[@id='customer_firstname']";
	private static final String LAST_NAME = "//input[@id='customer_lastname']";
	private static final String PASSWORD = "//input[@id='passwd']";
	private static final String ADDRESS = "//input[@id='address1']";
	private static final String CITY = "//input[@id='city']";
	private static final String STATE = "//select[@id='id_state']";
	private static final String ZIP_CODE = "//input[@id='postcode']";
	private static final String COUNTRY = "//select[@id='id_country']";
	private static final String MOBILE_PHONE = "//input[@id='phone_mobile']";
	private static final String ADDRESS_ALIAS = "//input[@id='alias']";
	private static final String REGISTER_BTN = "//span[contains(text(),'Register')]";
	
	
	public static void inputEMail(WebDriver driver, String email) {
		driver.findElement(By.xpath(EMAIL_INPUTBOX)).sendKeys(email);
	}
	
	public static void clickCreateAnAccount(WebDriver driver) {
		driver.findElement(By.xpath(CREATE_ACC_BTN)).click();
	}
	
	public static void inputFirstName(WebDriver driver, String firstName) {
		driver.findElement(By.xpath(FIRST_NAME)).sendKeys(firstName);
	}
	
	public static void inputLastName(WebDriver driver, String lastName) {
		driver.findElement(By.xpath(LAST_NAME)).sendKeys(lastName);
	}
	
	public static void inputPassword(WebDriver driver, String password) {
		driver.findElement(By.xpath(PASSWORD)).sendKeys(password);
	}
	
	public static void inputAddress(WebDriver driver, String address) {
		driver.findElement(By.xpath(ADDRESS)).sendKeys(address);
	}
	
	public static void inputCity(WebDriver driver, String city) {
		driver.findElement(By.xpath(CITY)).sendKeys(city);
	}
	
	public static void selectState(WebDriver driver, String state) {
		Select chooseState = new Select(driver.findElement(By.xpath(STATE)));
		chooseState.selectByVisibleText(state);
	}
	
	public static void inputZipPostalCode(WebDriver driver, String zipPostalCode) {
		driver.findElement(By.xpath(ZIP_CODE)).sendKeys(zipPostalCode);
	}
	
	public static void selectCountry(WebDriver driver, String country) {
		Select chooseCountry = new Select(driver.findElement(By.xpath(COUNTRY)));
		chooseCountry.selectByValue(country);
	}
	
	public static void inputMobilePhone(WebDriver driver, String mobilePhone) {
		driver.findElement(By.xpath(MOBILE_PHONE)).sendKeys(mobilePhone);
	}
	
	public static void inputAddressAlias(WebDriver driver, String addressAlias) {
		driver.findElement(By.xpath(ADDRESS_ALIAS)).sendKeys(addressAlias);
	}
	
	public static void clickRegister(WebDriver driver) {
		driver.findElement(By.xpath(REGISTER_BTN)).click();
		
	}
}
