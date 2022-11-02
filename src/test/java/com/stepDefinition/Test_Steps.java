package com.stepDefinition;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

public class Test_Steps {
	WebDriver driver;
	LoginPage loginPg;
	String expectedOutput = "Hello vasuvespag!";
	String expectedTitle = "Adactin.com - Select Hotel";
	String expectedTitle2 = "Adactin.com - Book A Hotel";
	JavascriptExecutor jse;
	String script = "arguments[0].scrollIntoView();";

	@Given("User is on HotelApp homepage")
	public void user_is_on_hotel_app_homepage() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		jse = (JavascriptExecutor) driver;
		driver.get("http://adactinhotelapp.com");
		driver.manage().window().maximize();
		System.out.println("Inside HotelApp homepage");
	}

	@When("User enters username")
	public void user_enters_username() {
//		WebElement uname = driver.findElement(By.id("username"));
//		uname.clear();
//		uname.sendKeys("vasuvespag");
		loginPg = new LoginPage(driver);
		loginPg.enterUsernameAction("vasuvespag");
		System.out.println("Username entered");
	}

	@When("User enters password")
	public void user_enters_password() {
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys("vasu1234");
		loginPg.enterPasswordAction("vasu1234");
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {
//		driver.findElement(By.className("login_button")).click();
		loginPg.clickLoginAction();
	}

	@Then("Login is successful")
	public void login_is_successful() {
		WebElement greeting = driver.findElement(By.id("username_show"));
		String actualOutput = greeting.getAttribute("value");
		assertEquals(expectedOutput, actualOutput);
	}

	@When("User selects location from dropdown")
	public void user_selects_location_from_dropdown() {
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"location\"]")));
		new Select(driver.findElement(By.xpath("//*[@id=\"location\"]"))).selectByVisibleText("Los Angeles");
	}

	@When("User clicks on search button")
	public void user_clicks_on_search_button() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@id=\"Submit\"]")));
		driver.findElement(By.xpath("//*[@id=\"Submit\"]")).click();
	}

	@Then("List of hotels is displayed")
	public void list_of_hotels_is_displayed() {
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle, actualTitle);
	}

	@When("User selects a radio button")
	public void user_selects_a_radio_button() {
		jse.executeScript(script, driver.findElement(By.xpath("//*[@id=\"radiobutton_1\"]")));
		driver.findElement(By.xpath("//*[@id=\"radiobutton_1\"]")).click();
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {
		jse.executeScript(script, driver.findElement(By.xpath("//*[@id=\"continue\"]")));
		driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
	}

	@Then("Book a Hotel page is displayed")
	public void book_a_hotel_page_is_displayed() {
		String actualTitle = driver.getTitle();
		assertEquals(expectedTitle2, actualTitle);
	}

//	@When("User enters username as {string}")
//	public void user_enters_username_as(String string) {
//		WebElement uname = driver.findElement(By.id("username"));
//		uname.clear();
//		uname.sendKeys(string);
//	}
//
//	@When("User enters password as {string}")
//	public void user_enters_password_as(String string) {
//		driver.findElement(By.name("password")).clear();
//		driver.findElement(By.name("password")).sendKeys(string);
//	}

	@When("User enters username as <{string}>")
	public void user_enters_username_as(String string) {
		WebElement uname = driver.findElement(By.id("username"));
		uname.clear();
		uname.sendKeys(string);
	}

	@When("User enters password as <{string}>")
	public void user_enters_password_as(String string) {
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(string);
	}

	@When("user enters username and password")
	public void user_enters_username_and_password(io.cucumber.datatable.DataTable userCredentials) {
//		List<List<String>> data = userCredentials.asLists();		
//		for (List<String> credentials : data) {
//			WebElement uname = driver.findElement(By.id("username"));
//			uname.clear();
//			uname.sendKeys(credentials.get(0));
//			driver.findElement(By.name("password")).clear();
//			driver.findElement(By.name("password")).sendKeys(credentials.get(1));
//		}
		List<Map<String, String>> data = userCredentials.asMaps();
		for (Map<String, String> data1 : data) {
			WebElement uname = driver.findElement(By.id("username"));
			uname.clear();
			uname.sendKeys(data1.get("username"));
			driver.findElement(By.name("password")).clear();
			driver.findElement(By.name("password")).sendKeys(data1.get("password"));
		}
	}
}
