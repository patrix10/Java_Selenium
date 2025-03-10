package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {
	WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By country = By.cssSelector("[placeholder='Select Country']");
	By results = By.cssSelector(".ta-results");
	
	@FindBy(css=".action__submit")
	WebElement PlaceOrder;
	
	public void selectCountry(String countryName) {
		Actions a = new Actions(driver);
		a.sendKeys(driver.findElement(country),countryName).build().perform();
		waitforElementVisibility(results);
		driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
	}
	
	public void submit() {
	//	driver.findElement(By.cssSelector(".action__submit")).click();
		PlaceOrder.click();
	}
}