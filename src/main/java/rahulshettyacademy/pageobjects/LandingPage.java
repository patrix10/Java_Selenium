package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {
	WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
//	public void loginPage() {
//		driver.findElement(By.id("userEmail")).sendKeys("pratiksingh@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Pratik@12345");
//		driver.findElement(By.id("login")).click();
	
	//we can also do this with PageFactory
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement passwordEle;
	
	@FindBy(id="login")
	WebElement submit;
	
	public void loginPage(String email,String password) {
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
	}
	
	By errorMessage = By.cssSelector("[class*='flyInOut']");
	
	public String getErrorMessage() {
		waitforElementVisibility(errorMessage);
		return driver.findElement(By.cssSelector("[class*='flyInOut']")).getText();
	}
}