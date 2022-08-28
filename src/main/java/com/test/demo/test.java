package com.test.demo;


// import java.util.concurrent.TimeUnit;
// import javax.swing.Action;
// import java.io.File;
//import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.Console;
import java.util.List;
import java.util.logging.ConsoleHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import dev.failsafe.internal.util.Assert;



@SpringBootApplication
public class test{

	public static void main(String[] args) throws InterruptedException{
		SpringApplication.run(test.class, args);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRADANA\\Downloads\\chromedriver_win32\\chromedriver.exe");
		
		//open browser
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts();
		//.implicitlyWait(15,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.amazon.com/");

		Actions action = new Actions(driver);
		
		driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']")).click();
		Thread.sleep(2000);
		
		//click electronics
		WebElement electronics = driver.findElement(By.xpath("//body/div[@id='hmenu-container']/div[@id='hmenu-canvas']/div[@id='hmenu-content']/ul[@class='hmenu hmenu-visible']/li[7]/a[1]"));
		action.moveToElement(electronics);
		action.click();
		action.perform();
		Thread.sleep(3000);

		//click television and video
		driver.findElement(By.xpath("//a[normalize-space()='Television & Video']")).click();
		Thread.sleep(2000);
		
		//click television
		driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='Televisions']")).click();
		Thread.sleep(2000);

		//click 32 inches & under
		driver.findElement(By.xpath("//span[contains(text(),'32 Inches & Under')]")).click();
		Thread.sleep(2000);

		//click dropdown
		driver.findElement(By.id("a-autoid-2-announce")).click();
		Thread.sleep(2000);
		
		//click low to high
		WebElement descending = driver.findElement(By.cssSelector("#s-result-sort-select_1"));
		action.moveToElement(descending);
		action.click();
		action.perform();
		Thread.sleep(3000);
		
		//functional N
		//typing text
		WebElement myElement = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		myElement.sendKeys("2017 Model");

		//hit enter
		driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
		Thread.sleep(3000);

		//select product
		//span[normalize-space()='LG Electronics 32LJ500B 32-Inch 720p LED TV (2017 Model)']
		driver.findElement(By.partialLinkText("2017 Model")).click();
		Thread.sleep(2000);

		//click add to list
		//a[normalize-space()='Add to List']
		driver.findElement(By.xpath("//a[normalize-space()='Add to List']")).click();
		Thread.sleep(2000);
		
		//type email
		WebElement myEmaiElement = driver.findElement(By.xpath("//input[@id='ap_email']"));
		myEmaiElement.sendKeys("aji2207ok@gmail.com");

		//click continue
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		Thread.sleep(3000);

		//input password
		//input[@id='ap_password']
		WebElement myPassWebElement = driver.findElement(By.xpath("//input[@id='ap_password']"));
		myPassWebElement.sendKeys("12345678");

		//click submit/signin
		//input[@id='signInSubmit']
		driver.findElement(By.xpath("//input[@id='signInSubmit']")).click();
		Thread.sleep(3000);

		String tagName2=" ";
		tagName2 = driver.findElement(By.xpath("//h4[normalize-space()='Important Message!']")).getText();
		String expectedTitle2 = "Important Message!";
		strictEqual(expectedTitle2, tagName2);
		System.out.println(tagName2);
	
		driver.close();
		driver.quit();
		
	}

	private static boolean strictEqual(String expectedTitle2, String tagName2) {
		return false;
	}

	

}

		//locate web element
		// String tagname=" ";
		// tagname = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).getText();
		// System.out.println(tagname);
		
		//click all
		// WebElement category = driver.findElement(By.xpath("//a[@id='nav-hamburger-menu']"));
		// action.moveToElement(category).perform();
		// Thread.sleep(2000);

		// String successClaim = "Electronics";
        // Thread.sleep(2000);
        // List<WebElement> popUp = driver.findElements(By.xpath("//body[1]/div[3]/div[2]/div[1]/ul[1]/li[7]/a[1]"));
        // for (WebElement el : popUp) {
        //     String text = el.getText();
        //     if (text.contains(successClaim)) {
        //         el.click();
        //         break;
        //     }
		// }

		// String ActualTitle = driver.getTitle("//h4[normalize-space()='There was a problem']");
		// String ExpectedTitle = "There was a problem";
		// Assert.assertEquals(ExpectedTitle, ActualTitle);
		
		// System.out.print("stop");
		// String tagname=" ";
		// tagname = driver.findElement(By.xpath("//a[@id='nav-logo-sprites']")).getText();
		// String ExpectedTitle = "There was a problem";
		// Assert.state(true,ExpectedTitle, tagname);
		// System.out.println(tagname);
		// System.out.println("test passed");
		// if (tagname == ExpectedTitle) {
		// 	Wait.class.wait(2000);
		// 	driver.close();
		// 	driver.quit();

		// } else {
		// 	System.out.println("Different Notif");

		// 	String tagname2=" ";
		// 	tagname2 = driver.findElement(By.xpath("//h4[normalize-space()='Important Message!']")).getText();
		// 	String ExpectedTitle2 = "Important Message!";
		// 	Assert.state(true,ExpectedTitle2, tagname2);
		// 	System.out.println(tagname2);
		// 	driver.close();
		// 	driver.quit();
		// };
		

		// assert.strictEqual(note, "Hello Selenium");
