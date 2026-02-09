package karthikakkasaligar.Test;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.ProductsPage;
import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_20 extends BaseTest {

	@Test
	public void SearchProductsandVerifyCartAfterLogin() throws InterruptedException {
		Actions action = new Actions(driver);
		// Navigating to Products Page
		ProductsPage productspage = homepage.Header.productsbuttonclick();

		// redirect to products page to bypass adds
		homepage.redirecttoproductspage();

		driver.findElement(By.id("search_product")).sendKeys("T-Shirt");
		driver.findElement(By.id("submit_search")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='title text-center']")));
		Assert.assertEquals(driver.findElement(By.cssSelector("[class='title text-center']")).getText(),"SEARCHED PRODUCTS");
				

		productspage.scrolldown();
		
		// To Verify all the products related to search are visible
		List<WebElement> Products = driver.findElements(By.xpath("(//div[@class='productinfo text-center']//p)"));
		for (int i = 0; i < Products.size(); i++) {
			String Product = Products.get(i).getText().trim();
			if (!Product.contains("T-Shirt")) {
				Assert.fail();
			}
		}

		List<WebElement> searchedproducts = driver.findElements(By.cssSelector("[class='single-products']"));
		for (int j = 0; j < searchedproducts.size(); j++) {
			WebElement product = searchedproducts.get(j);
			action.moveToElement(product).build().perform();
			WebElement addtocart = product.findElement(By.cssSelector(".btn.btn-default.add-to-cart"));
			action.moveToElement(addtocart).click().build().perform();
			if (j == searchedproducts.size() - 1) {
				product.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();
			}
			 else 
			 {
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".btn.btn-success.close-modal.btn-block"))).click();
			}
		}
		
		homepage.SignUporLogin();
		SignUPorLoginPage signuporloginpage = new SignUPorLoginPage(driver, wait);
		signuporloginpage.login("karthikkihtrak@yopmail.com","Test@123");
		signuporloginpage.clickheadercarticon();
		
		List<WebElement> cartitems=driver.findElements(By.cssSelector(".cart_description"));
		for(int k=0;k<cartitems.size();k++)
		{
			String name= cartitems.get(k).getText();
			if(!name.contains("T-Shirt"))
			{
				Assert.fail();
			}
		}

	}

}
