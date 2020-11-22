package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShopPage {

	WebDriver driver;
	WebDriverWait wait;

	public ShopPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public @FindBy(linkText = "Start Shopping »") WebElement shopButton;
	public String productName = "//h4[text()='product']//following-sibling::p//a";

	public void clickOnShopTab() {
		wait = new WebDriverWait(this.driver, 30);
		wait.until(ExpectedConditions.visibilityOf(shopButton));
		shopButton.click();
	}

	public void buyProduct(String productNameOnCart) {
		wait = new WebDriverWait(this.driver, 30);
		String productNameTxt =productName.replace("product", productNameOnCart);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(productNameTxt))));
		driver.findElement(By.xpath(productNameTxt)).click();
	}

}
