package rahulshettyacademy.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;
import rahulshettyacademy.testComponents.BaseTest;
import rahulshettyacademy.testComponents.Retry;

public class ErrorValidationsTest extends BaseTest {

	    @Test(groups= {"ErrorHandling"},retryAnalyzer=Retry.class)
	    public void loginErrorValidation() {
            //giving wrong credentials
	    	landingPage.loginPage("priksingh@gmail.com","Prak@12345"); 
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());            
	}
	    
	    @Test(groups= {"ErrorHandling"})
	    public void productErrorValidation() {
	    	String ProductName = "ZARA COAT 3";
	    	
	    	landingPage.loginPage("vedanshsingh@gmail.com","Vedansh@12345"); 
	    	ProductCatalogue productCatalogue = new ProductCatalogue(driver);
            productCatalogue.getProductList();
            productCatalogue.addProductToCart(ProductName); 
            productCatalogue.goToCart();

            CartPage cartPage = new CartPage(driver);
            Boolean match = cartPage.verifyProduct("ZARA GOAT 33");
            Assert.assertFalse(match);
	    }
}