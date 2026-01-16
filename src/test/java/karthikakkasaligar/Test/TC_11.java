package karthikakkasaligar.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.AllProductsPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_11 extends BaseTest {

	@Test
	public void AddProductstocart() throws InterruptedException {

		AllProductsPage signuporloginpage ;
		
		// Scroll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600);");

		// Actions
		Actions actions = new Actions(driver);

		// ------------------- PRODUCT 1 -------------------
		WebElement product1 = driver.findElements(By.cssSelector(".productinfo.text-center")).get(0);
		actions.moveToElement(product1).perform();

		// Click Add to Cart for Product 1
		WebElement addToCart1 = product1.findElement(By.cssSelector(".add-to-cart"));
		addToCart1.click();

		// Click Continue Shopping
		driver.findElement(By.cssSelector(".btn.btn-success.close-modal.btn-block")).click();

		// ------------------- PRODUCT 2 -------------------
		WebElement product2 = driver.findElements(By.cssSelector(".productinfo.text-center")).get(1);
		actions.moveToElement(product2).perform();

		// Click Add to Cart for Product 2
		WebElement addToCart2 = product2.findElement(By.cssSelector(".add-to-cart"));
		addToCart2.click();

		// Click View Cart
		driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();

		// ------------------- CART VALIDATIONS -------------------
		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cart_description h4 a"));

		String name1 = cartProducts.get(0).getText().trim();
		String name2 = cartProducts.get(1).getText().trim();

		Assert.assertEquals(name1, "Blue Top", "First product name mismatch");
		Assert.assertEquals(name2, "Men Tshirt", "Second product name mismatch");

		// Price validation
		List<WebElement> prices = driver.findElements(By.cssSelector(".cart_price"));

		Assert.assertEquals(prices.get(0).getText().trim(), "Rs. 500");
		Assert.assertEquals(prices.get(1).getText().trim(), "Rs. 400");

		// Quantity validation
		List<WebElement> quantities = driver.findElements(By.cssSelector(".cart_quantity"));

		Assert.assertEquals(quantities.get(0).getText().trim(), "1");
		Assert.assertEquals(quantities.get(1).getText().trim(), "1");

		// Total price validation
		List<WebElement> totals = driver.findElements(By.cssSelector(".cart_total"));

		Assert.assertEquals(totals.get(0).getText().trim(), "Rs. 500");
		Assert.assertEquals(totals.get(1).getText().trim(), "Rs. 400");

//		AllProductsPage signuporloginpage ;
//		//driver.navigate().refresh();
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,600);");
//		Actions A = new Actions(driver);
//		WebElement product1 = driver.findElements(By.cssSelector(".productinfo.text-center")).get(0);
//		A.moveToElement(product1).build().perform();
//		WebElement Addtocart = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class*='add-to-cart']")));
//		Addtocart.click();
//		driver.findElement(By.cssSelector("[class*='btn-block']")).click();
//		WebElement product2 = driver.findElements(By.cssSelector(".productinfo.text-center")).get(1);
//		A.moveToElement(product2).build().perform();
//		WebElement Addtocart1  = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[class*='add-to-cart']")));
//		Addtocart1.click();	
//		driver.findElement(By.xpath("(//*[@href='/view_cart'])[2]")).click();
//	    List<WebElement> cartproducts=	driver.findElements(By.cssSelector("[class='cart_description'] h4 a"));
//	    String name1= cartproducts.get(0).getText().trim();
//	    String name2=cartproducts.get(1).getText().trim();
//	    Assert.assertEquals(name1, "Blue Top", "First product name mismatch");
//	    Assert.assertEquals(name2, "Men Tshirt", "Second product name mismatch");
//	    String priceitem1= driver.findElements(By.cssSelector("[class='cart_price']")).get(0).getText().trim();
//	    Assert.assertEquals(priceitem1, "Rs. 500");
//	    String priceitem2= driver.findElements(By.cssSelector("[class='cart_price']")).get(1).getText().trim();
//	    Assert.assertEquals(priceitem2, "Rs. 400");
//	    String Qunatityitem1= driver.findElements(By.cssSelector("[class='cart_quantity']")).get(0).getText().trim();
//	    Assert.assertEquals(Qunatityitem1, "1");
//	    String Qunatityitem2= driver.findElements(By.cssSelector("[class='cart_quantity']")).get(1).getText().trim();
//	    Assert.assertEquals(Qunatityitem2, "1");
//	    String totalprice1= driver.findElements(By.cssSelector("[class='cart_total']")).get(0).getText().trim();
//	    Assert.assertEquals(totalprice1, "Rs. 500");
//	    String totalprice2= driver.findElements(By.cssSelector("[class='cart_total']")).get(1).getText().trim();
//	    Assert.assertEquals(totalprice2, "Rs. 400"); 
	}

}
