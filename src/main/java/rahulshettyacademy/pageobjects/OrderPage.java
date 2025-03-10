package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OrderPage {
    WebDriver driver;
	
	public OrderPage(WebDriver driver) {
		this.driver=driver;
	}
	
	//To check only 1st order from all list
//	public Boolean getNamesList(String ProductName) {
//		WebElement names = driver.findElement(By.cssSelector("tr td:nth-child(3)"));
//		Boolean match = names.getText().equalsIgnoreCase(ProductName);
//		return match;
//	}
	
	//To check from whole list that our order is present
	public Boolean getNamesList(String ProductName) {
		List<WebElement> Ordernames = driver.findElements(By.cssSelector("tr td:nth-child(3)"));
		for(int i=0;i<Ordernames.size();i++) {
			String name = Ordernames.get(i).getText();
			if(name.contains(ProductName)) {
				return true;
			}
		}
		return false;
	}
}
