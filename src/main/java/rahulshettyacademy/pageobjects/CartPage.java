package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//To verify only 1 product that was at first place
//	public Boolean verifyProduct(String ProductName) {
//		WebElement CartName = driver.findElement(By.cssSelector(".cartSection h3"));
//		Boolean match = CartName.getText().equalsIgnoreCase(ProductName);
//		return match;
//	}
	
	//To verify from list of n products that our product is present
	public Boolean verifyProduct(String ProductName) {
		List<WebElement> CartProducts = driver.findElements(By.cssSelector(".cartSection h3"));
		for(int i=0;i<CartProducts.size();i++) {
			String name = CartProducts.get(i).getText();
			if(name.contains(ProductName)) {
				return true;
			}
		}
		return false;
	}
	
	public void gotoCheckout() {
		driver.findElement(By.cssSelector(".totalRow button")).click();
	}
}