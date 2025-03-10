package rahulshettyacademy.tests;

import java.io.IOException;
//import java.time.Duration;
//import java.util.List;
import java.util.HashMap;
import java.util.List;

//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.OrderPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testComponents.BaseTest;

public class StandAloneTest extends BaseTest {
	String ProductName = "ZARA COAT 3";

	    @Test(dataProvider="getData",groups= {"Purchase"})
	    public void submitOrder(HashMap<String,String> input) throws IOException {
		
	//	LandingPage landingPage = launchApplication(); //launchApplication() called in BaseTest
	//	LandingPage landingPage = new LandingPage(driver);  //we did this in launchApplication()
                //  landingPage.goTo();
		        //    landingPage.loginPage();     //landingPage initialized in BaseTest just like driver
		            
		        //  PageFactory Method
		          landingPage.loginPage(input.get("email"),input.get("password"));
		
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		                 productCatalogue.getProductList();
		                 productCatalogue.addProductToCart(input.get("product")); //ProductName
		
		Assert.assertTrue(true);
		
		                 productCatalogue.goToCart();
		
		CartPage cartPage = new CartPage(driver);
	    Boolean match = cartPage.verifyProduct(input.get("product"));  //ProductName
	    
		Assert.assertTrue(match);
		
		                cartPage.gotoCheckout(); 
		                
		CheckoutPage checkoutPage = new CheckoutPage(driver); 
			         checkoutPage.selectCountry("india");
			         checkoutPage.submit();
		
        ConfirmationPage confirmationPage = new ConfirmationPage(driver);
        String confirm =  confirmationPage.getConfirmationMessage(); 
        
		Assert.assertEquals(confirm,"THANKYOU FOR THE ORDER.");
		
		                  confirmationPage.grabId(); 
		                  
	//	driver.quit();  //used in BaseTest as @AfterMethod                
	}
	    
	    //checking if the order is placed or not
	    @Test(dependsOnMethods= {"submitOrder"})
	    public void OrderHistoryTest() {
	    	
	    	landingPage.loginPage("pratiksingh@gmail.com","Pratik@12345");
	    	
	    	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
	    	                 productCatalogue.goToOrders();
	    	
	    	OrderPage orderPage = new OrderPage(driver);
	    	Boolean match = orderPage.getNamesList(ProductName);
	    	
	    	Assert.assertTrue(match);
	    }
	    
	    @DataProvider
	    public Object[][] getData() throws IOException {
	    	//DataProvider method
//	    	return new Object[][] {{"pratiksingh@gmail.com","Pratik@12345","ZARA COAT 3"},{"vedanshsingh@gmail.com","Vedansh@12345","ADIDAS ORIGINAL"}};
	    	
	    	//HashMap method
//	    	HashMap<String,String> map1 = new HashMap<String,String>();
//	    	map1.put("email","pratiksingh@gmail.com");
//	    	map1.put("password","Pratik@12345");
//	    	map1.put("product","ZARA COAT 3");
//	    	
//	    	HashMap<String,String> map2 = new HashMap<String,String>();
//	    	map2.put("email", "vedanshsingh@gmail.com");
//	    	map2.put("password", "Vedansh@12345");
//	    	map2.put("product", "ADIDAS ORIGINAL");
	    	
	    	List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\data\\PurchaseOrder.json");
	    	return new Object[][] {{data.get(0)},{data.get(1)},{data.get(2)}};
	    }
}