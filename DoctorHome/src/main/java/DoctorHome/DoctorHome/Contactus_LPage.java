package DoctorHome.DoctorHome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Contactus_LPage {
	 	WebDriver driver;
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", "E:\\TestAuto_DoctorHome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}

		@Test
		public void TC_01_ContactUS_Empty_Data() {
			driver.get("http://localhost:3000/index.html");
			
			driver.findElement(By.xpath("//input[@placeholder='Tên của bạn']")).sendKeys("");
			driver.findElement(By.xpath("//input[@placeholder='Email của bạn']")).sendKeys("");
			driver.findElement(By.xpath("//textarea[@placeholder='Nhập...']")).sendKeys("");
			driver.findElement(By.xpath("//button[contains(text(),'LIÊN HỆ VỚI CHÚNG TÔI')]")).click();
			sleepInSecond(2);
			
			Assert.assertEquals(driver.findElement(By.xpath("//body//div[@id='root']//div[@class='row']//div[@class='row']//div[1]//div[1]//div[1]//small[1]")).getText(), "Trường này không được để trống");
			Assert.assertEquals(driver.findElement(By.xpath("//div[@class='col-lg-6']//div[2]//div[1]//div[1]//small[1]")).getText(), "Trường này không được để trống");
			Assert.assertEquals(driver.findElement(By.xpath("//div[3]//div[1]//div[1]//small[1]")).getText(), "Trường này không được để trống");
			
		}
		
		@Test
		public void TC_02_ContactUS_Empty_Name_Data() {
			driver.get("http://localhost:3000/index.html");
			
			driver.findElement(By.xpath("//input[@placeholder='Tên của bạn']")).sendKeys("");
			driver.findElement(By.xpath("//input[@placeholder='Email của bạn']")).sendKeys("thilu6801@gmail.com");
			driver.findElement(By.xpath("//textarea[@placeholder='Nhập...']")).sendKeys("Demo contact us");
			driver.findElement(By.xpath("//button[contains(text(),'LIÊN HỆ VỚI CHÚNG TÔI')]")).click();
			sleepInSecond(2);
			
			//Verify error message as expected		
			Assert.assertEquals(driver.findElement(By.xpath("//small[@class='form-text text-danger']")).getText(), "Trường này không được để trống");
			
		}
		
		@Test
		public void TC_03_ContactUs_Empty_Email_Data() {
			driver.get("http://localhost:3000/index.html");
			
			driver.findElement(By.xpath("//input[@placeholder='Tên của bạn']")).sendKeys("Lucy");
			driver.findElement(By.xpath("//input[@placeholder='Email của bạn']")).sendKeys("");
			driver.findElement(By.xpath("//textarea[@placeholder='Nhập...']")).sendKeys("Demo contact us");
			driver.findElement(By.xpath("//button[contains(text(),'LIÊN HỆ VỚI CHÚNG TÔI')]")).click();
			sleepInSecond(2);
			
			//Verify error message as expected
			
			Assert.assertEquals(driver.findElement(By.xpath("//small[@class='form-text text-danger']")).getText(), "Trường này không được để trống");
			
		}
		
		@Test
		public void TC_04_ContactUs_Invalid_Email() {
			driver.get("http://localhost:3000/index.html");
			driver.findElement(By.xpath("//input[@placeholder='Tên của bạn']")).sendKeys("Lucy");
			driver.findElement(By.xpath("//input[@placeholder='Email của bạn']")).sendKeys("lalala");
			driver.findElement(By.xpath("//textarea[@placeholder='Nhập...']")).sendKeys("Demo contact us");
			driver.findElement(By.xpath("//button[contains(text(),'LIÊN HỆ VỚI CHÚNG TÔI')]")).click();
			sleepInSecond(2);
	
			//Verify error message as expected
			
			Assert.assertEquals(driver.findElement(By.xpath("//small[@class='form-text text-danger']")).getText(), "Địa chỉ email không hợp lệ! Vui lòng nhập lại");
			
		}

		@Test
		public void TC_05_ContactUs_Empty_Message_Data() {
			driver.get("http://localhost:3000/index.html");
			driver.findElement(By.xpath("//input[@placeholder='Tên của bạn']")).sendKeys("Lucy");
			driver.findElement(By.xpath("//input[@placeholder='Email của bạn']")).sendKeys("thilu6801@gmail.com");
			driver.findElement(By.xpath("//textarea[@placeholder='Nhập...']")).sendKeys("");
			driver.findElement(By.xpath("//button[contains(text(),'LIÊN HỆ VỚI CHÚNG TÔI')]")).click();
			sleepInSecond(2);
			
	
			//Verify error message as expected
			Assert.assertEquals(driver.findElement(By.xpath("//small[@class='form-text text-danger']")).getText(), "Trường này không được để trống");
			
		}
		
		
		@Test
		public void TC_06_ContactUs_Successfully() {
			driver.get("http://localhost:3000/index.html");
			
			driver.findElement(By.xpath("//input[@placeholder='Tên của bạn']")).sendKeys("Lucy");
			driver.findElement(By.xpath("//input[@placeholder='Email của bạn']")).sendKeys("thilu6801@gmail.com");
			driver.findElement(By.xpath("//textarea[@placeholder='Nhập...']")).sendKeys("Demo contact us");
			driver.findElement(By.xpath("//button[contains(text(),'LIÊN HỆ VỚI CHÚNG TÔI')]")).click();
			sleepInSecond(2);
			
			
		}

		@AfterClass
		  public void afterTest() {
		      driver.quit();
		  }

		public void sleepInSecond(long second) {
			try {
				Thread.sleep(second * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

}
