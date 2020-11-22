package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.ContactPage;
import pageobjects.HomePage;
import pageobjects.ShopPage;

public class PlanetTestingTestScripts {
	WebDriver driver;
	HomePage homePage;
	ContactPage contactPage;
	ShopPage shopPage;
	CartPage cartPage;

	@BeforeMethod
	public void navigateToURL() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://jupiter.cloud.planittesting.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(320, TimeUnit.SECONDS);

	}

	@Test
	public void firstTestCase() throws Throwable {
		homePage = new HomePage(driver);
		contactPage = new ContactPage(driver);
		waitForPageToLoad();
		homePage.clickOnContactTab();
		contactPage.clickSubmitButton();
		waitForPageToLoad();
		contactPage.verifyValidationError("but we won't get it unless you complete the form correctly.");
		contactPage.fillContactForm();
		contactPage.verifyValidationErrorIsInvisible();
	}

	@Test
	public void secondTestCase() throws Throwable {
		homePage = new HomePage(driver);
		contactPage = new ContactPage(driver);
		waitForPageToLoad();
		homePage.clickOnContactTab();
		contactPage.clickSubmitButton();
		contactPage.verifyValidationError("but we won't get it unless you complete the form correctly.");
		contactPage.fillContactForm();
		contactPage.clickSubmitButton();
		waitForPageToLoad();
		contactPage.verifyValidationSuccessIsVisible();
	}
    @Test
    public void thirdTestCase()throws Throwable{
    	homePage = new HomePage(driver);
		contactPage = new ContactPage(driver);
		waitForPageToLoad();
		homePage.clickOnContactTab();
		contactPage.fillContactFormInvalidData();
		contactPage.verifyValidationError("but we won't get it unless you complete the form correctly.");
    }
	@Test
	public void fourthTestCase() throws Throwable {
		homePage = new HomePage(driver);
		shopPage = new ShopPage(driver);
		cartPage = new CartPage(driver);
		waitForPageToLoad();
		shopPage.clickOnShopTab();
		waitForPageToLoad();
		shopPage.buyProduct("Fluffy Bunny");
		shopPage.buyProduct("Funny Cow");
		shopPage.buyProduct("Funny Cow");
		homePage.clickCartIcon();
		waitForPageToLoad();
		cartPage.verifyProductInCart("Fluffy Bunny");
		cartPage.verifyProductInCart("Funny Cow");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	public void waitForPageToLoad() throws Throwable {
		Thread.sleep(4000);
	}

}
