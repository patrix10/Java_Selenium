package rahulshettyacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import rahulshettyacademy.AbstractComponents.AbstractComponent;

public class ProductCatalogue extends AbstractComponent {
	WebDriver driver;
	
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	By findBy = By.cssSelector(".mb-3");
	By addToCart = By.xpath("//button[text()=' Add To Cart']");
	By toastContainer = By.cssSelector("#toast-container");
	By ele = By.cssSelector(".ng-animating");//we can give any name here(ele)
	
	public List<WebElement> getProductList() {
		List<WebElement> products = driver.findElements(By.cssSelector(".card-body b"));
		waitforElementVisibility(findBy);
		return products;
	}
	
	public void addProductToCart(String ProductName) {
		List<WebElement> products = getProductList();
		for(int i=0; i<products.size(); i++) {
			String name=products.get(i).getText();
			if(name.contains(ProductName)) {
				driver.findElements(addToCart).get(i).click();
			}
		}
		//toast container that is coming after we click add to cart
		waitforElementVisibility(toastContainer);
		//loader that is coming for 3s then dissappear
		waitforElementInvisibility(ele);
	}
}