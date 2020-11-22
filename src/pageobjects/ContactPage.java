package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utilities.PropertyFileReader;

public class ContactPage {
	WebDriver driver;
	WebDriverWait wait;
	
	public ContactPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Submit")
	WebElement submitButton;
	@FindBy(id = "forename")
	WebElement foreName;
	@FindBy(id = "surname")
	WebElement surName;

	@FindBy(css = "#email")
	WebElement emailId;

	@FindBy(xpath = "//input[@name='telephone']")
	WebElement telephone;
	@FindBy(id = "message")
	WebElement message;

	@FindBy(id = "header-message")
	WebElement validationError;
	@FindBy(xpath = "//div[@class='alert alert-success']")
	WebElement validationSuccess;
	PropertyFileReader propertyFile  = new PropertyFileReader();
	public void clickSubmitButton() {
		wait = new WebDriverWait(this.driver, 60);
		wait.until(ExpectedConditions.visibilityOf(submitButton));
		submitButton.click();
	}

	public void verifyValidationError(String validationErrorMsg) {
		wait = new WebDriverWait(this.driver, 60);
		wait.until(ExpectedConditions.visibilityOf(validationError));
		Assert.assertTrue(validationError.getText().contains(validationErrorMsg));

	}

	public void verifyValidationErrorIsInvisible() {
		wait = new WebDriverWait(this.driver, 60);
		wait.until(ExpectedConditions.visibilityOf(validationError));
		Assert.assertTrue(validationError.isDisplayed());
	}

	public void verifyValidationSuccessIsVisible() {
		wait = new WebDriverWait(this.driver, 60);
		wait.until(ExpectedConditions.visibilityOf(validationSuccess));
		Assert.assertTrue(validationSuccess.isDisplayed());
	}

	public void fillContactForm() throws Exception {
		wait = new WebDriverWait(this.driver, 60);
		foreName.sendKeys(propertyFile.getProperty("ForceName"));
		surName.sendKeys(propertyFile.getProperty("SurName"));
		emailId.sendKeys(propertyFile.getProperty("EmailId"));
		telephone.sendKeys(propertyFile.getProperty("TelePhone"));
		message.sendKeys(propertyFile.getProperty("Message"));

	}
	public void fillContactFormInvalidData() throws Exception {
		wait = new WebDriverWait(this.driver, 60);
		foreName.sendKeys(propertyFile.getProperty("InvalidForceName"));
		surName.sendKeys(propertyFile.getProperty("InvalidSurName"));
		emailId.sendKeys(propertyFile.getProperty("InvalidEmailId"));
		message.sendKeys(propertyFile.getProperty("InvalidMessage"));

	}

}
