package pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {
	
	 WebDriver driver;
	public CartPage(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	

	public @FindBy(xpath  = "//tr[@ng-repeat='item in cart.items()']//td[1]")
	List<WebElement> ListshopButton;
	 ArrayList<String> cartProducts = new ArrayList<String>();
	
	public void verifyProductInCart(String productName)
	{
		for (WebElement webElement : ListshopButton) {
			cartProducts.add(webElement.getText());
		}
		Assert.assertTrue(cartProducts.contains(productName));
	}
	

}
