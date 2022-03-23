package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import io.cucumber.java.en.When;

public class ScenarioTestBank {
	
WebDriver driver = null;
	
	@Given("open browsers")
	public void open_browsers() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "E:\\TestAuto_DoctorHome\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
	}
	
	@Given("verify the management page")
	public void verify_the_management_page() throws Throwable {
		String manageCusPageUrl = driver.getCurrentUrl();
		Assert.assertEquals(manageCusPageUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");
		String manageCusPageTitle = driver.getTitle();
		Assert.assertEquals(manageCusPageTitle, "XYZ Bank");
		Thread.sleep(2*1000);
	}

	@When("user click on Add Customer button")
	public void user_click_on_Add_Customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Add Customer')]")).click();
		Thread.sleep(2*1000);
	}

	@When("user enter <firstName> and <lastName> and <postcode>")
	public void user_enter_firstName_and_lastName_and_postcode() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='First Name']")).sendKeys("Lu");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Ho");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("123456");
		Thread.sleep(1000);
	}
	
	@When("user enter <lastName> and <postcode>")
	public void user_enter_lastName_and_postcode() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Last Name']")).sendKeys("Ho");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Post Code']")).sendKeys("123456");
		Thread.sleep(1000);
	}
	
	@And("click on Add Customer button")
	public void click_on_Add_Customer_button() throws Throwable {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2*1000);
	}
	
	@And("click on OK button of the alert box")
	public void click_on_OK_button_of_the_alert_box() throws Throwable {
		Alert alert = driver.switchTo().alert();
	    alert.accept();
	}
	
	@And("verify data")
	public void verify_data() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Lu");
		int verifyDataAdd = driver.findElements(By.xpath("//td[contains(text(),'Lu')]")).size();
		if (verifyDataAdd > 1) {
			System.out.println(verifyDataAdd - 1 + " " + "result found");
		}else {
			System.out.println("No result");
		}
		Thread.sleep(2*1000);
	}
	
	@When("click on Open Account button")
	public void click_on_Open_Account_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Open Account')]")).click();
		Thread.sleep(2*1000);
	}
	
	@When("user select <account> and <currency>")
	public void user_select_account_and_currency() throws Throwable {
		driver.findElement(By.id("userSelect")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Harry')]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("currency")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Dollar')]")).click();
		Thread.sleep(1000);
	}

	@When("user select <account>")
	public void user_select_account() throws Throwable {
		driver.findElement(By.id("userSelect")).click();
		driver.findElement(By.xpath("//option[contains(text(),'Harry')]")).click();
		Thread.sleep(1000);
	}

	@And("click on the Process button")
	public void click_on_the_Process_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Process')]")).click();
		Thread.sleep(2*1000);
		
	}
	

	@When("click on Customers button")
	public void click_on_Customers_button() throws Throwable {
		driver.findElement(By.xpath("//button[contains(text(),'Customers')]")).click();
		Thread.sleep(2*1000);
	}
	
	@When("search customer is exist")
	public void search_customer_is_exist() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Harry");
		Thread.sleep(2*1000);
	}

	@When("search customer is not exist")
	public void search_customer_is_not_exist() throws Throwable {
		driver.findElement(By.xpath("//input[@placeholder='Search Customer']")).sendKeys("Lucy");
		Thread.sleep(2*1000);
	}
	
	@When("verify search customer")
	public void verify_search_customer() {
		int verifyDataSearch = driver.findElements(By.xpath("//td[contains(text(),'Harry')]")).size();
		if (verifyDataSearch > 0) {
			System.out.println(verifyDataSearch + " " + "result found");
		}else {
			System.out.println("No result");
		}
	}
	@Then("display the message")
	public void display_the_message() {
		driver.quit();
	    System.out.println("Successfully");
	}

}
