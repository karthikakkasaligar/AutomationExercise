package karthikakkasaligar.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;

import karthikakkasaligar.PageObjectModel.SignUPorLoginPage;
import karthikakkasaligar.TestComponents.BaseTest;

public class TC_12 extends BaseTest {

	@Test
	public void VerifyProductquantityinCart() {
		
		SignUPorLoginPage signuporloginpage = homepage.Header.clickonhomepage();
		String URL=driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://automationexercise.com/");
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600);");	
		driver.findElement(By.cssSelector("[href='/product_details/1']")).click();
		driver.get("https://automationexercise.com/product_details/1");
		String URL1=driver.getCurrentUrl();
		Assert.assertEquals(URL1, "https://automationexercise.com/product_details/1");	
		driver.findElement(By.id("quantity")).clear();
		driver.findElement(By.id("quantity")).sendKeys("4");
		driver.findElement(By.cssSelector(".btn.btn-default.cart")).click();
		driver.findElement(By.xpath("(//a[@href='/view_cart'])[2]")).click();
		Assert.assertEquals(driver.findElement(By.cssSelector("[class='cart_quantity']")).getText().trim(), "4");
		

	}

}
