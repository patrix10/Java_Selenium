package rahulshettyacademy.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	//All the reusable stuffs we will implement here such as explicit wait
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
	}
	
	public void waitforElementVisibility(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitforElementInvisibility(By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(ele)));
	}
	
	public void goToCart() {
		driver.findElement(By.cssSelector("[routerlink='/dashboard/cart']")).click();
	}
	
	public void goToOrders() {
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/myorders']")).click();
	}
}