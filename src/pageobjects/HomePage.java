package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public @FindBy(linkText = "Contact") WebElement contactButton;

	public @FindBy(xpath = "//a[contains(@href,'cart')]") WebElement cartIcon;

	public void clickOnContactTab() {
		wait = new WebDriverWait(this.driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(contactButton));
		contactButton.click();
	}

	public void clickCartIcon() {
		wait = new WebDriverWait(this.driver, 30);
//		wait.until(ExpectedConditions.visibilityOf(cartIcon));
		cartIcon.click();
	}

}
