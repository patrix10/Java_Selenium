package rahulshettyacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmationPage {
	WebDriver driver;
	
	public ConfirmationPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getConfirmationMessage() {
		String confirm = driver.findElement(By.tagName("h1")).getText();
		return confirm;
	}
	
	public void grabId() {
		System.out.println(driver.findElement(By.cssSelector("label[class='ng-star-inserted']")).getText());
	}
}