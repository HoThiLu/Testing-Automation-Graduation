package DoctorHome.DoctorHome;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
// org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Login {
	 	WebDriver driver;
		@BeforeClass
		public void beforeClass() {
			System.setProperty("webdriver.chrome.driver", "E:\\TestAuto_DoctorHome\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		
		@Test
		public void TC_01_Login_Empty_Email_Data() {
			driver.get("http://localhost:3000/");
			
			driver.findElement(By.xpath("//input[@id='basic_email']")).sendKeys("");
			driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys("123456");
			driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]")).click();
			sleepInSecond(2);
			
			//Verify error message as expected			
			driver.findElement(By.xpath("//*[contains(text(),'Vui lòng nhập email liên hệ')]"));
			sleepInSecond(2);
			
		}
		
		@Test
		public void TC_02_Login_Empty_Password_Data() {
			driver.get("http://localhost:3000/");
			
			driver.findElement(By.xpath("//input[@id='basic_email']")).sendKeys("thilu6801@gmail.com");
			driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys("");
			driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]")).click();
			sleepInSecond(2);
			
			//Verify error message as expected
			driver.findElement(By.xpath("//*[contains(text(),'Vui lòng điền mật khẩu')]"));
			sleepInSecond(2);
			
		}
		
		@Test
		public void TC_03_Login_Invalid_Email() {
			driver.get("http://localhost:3000/");
			driver.findElement(By.xpath("//input[@id='basic_email']")).sendKeys("thilu");
			driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys("123456");
			driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]")).click();
			sleepInSecond(2);	
			//Verify error message as expected
			
			driver.findElement(By.xpath("//*[contains(text(), 'Vui lòng nhập đúng format email']"));
			sleepInSecond(2);
			
		}

//		@Test
//		public void TC_04_Login_Incorrect_Email() {
//			driver.get("http://localhost:3000/");
//			driver.findElement(By.xpath("//input[@id='basic_email']")).sendKeys("thilu@gmail.com");
//			driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys("123456");
//			driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]")).click();
//			sleepInSecond(2);
//			//Verify error message as expected
//			
//			//Assert.assertEquals(driver.findElement(By.xpath("//p[@class='cred']")).getText(), "Email này chưa được đăng ký.");
//		}

//		@Test
//		public void TC_05_Login_Incorrect_Password() {
//			driver.get("http://localhost:3001/");
//			driver.findElement(By.xpath("//input[@id='basic_email']")).sendKeys("thilu6801@gmail.com");
//			driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys("123");
//			driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]")).click();
//			sleepInSecond(2);
//			
//	
//			//Verify error message as expected
//			//Assert.assertEquals(driver.findElement(By.xpath("//p[@class='cred']")).getText(), "Mật khẩu sai.");
//		}
//		
//		@Test
//		public void TC_06_Login_Incorrect_Email_Pass() {
//			driver.get("http://localhost:3001/");
//			
//			driver.findElement(By.xpath("//input[@id='basic_email']")).sendKeys("thilu@gmail.com");
//			driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys("123");
//			driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]")).click();
//			sleepInSecond(2);
//			
//			//Verify error message as expected
//			
//			//Assert.assertEquals(driver.findElement(By.xpath("//p[@class='cred']")).getText(), "Email này chưa được đăng ký.");
//			
//		}
		
//		@Test
//		public void TC_07_Login_Successfully() {
//			driver.get("http://localhost:3001/");
//			
//			driver.findElement(By.xpath("//input[@id='basic_email']")).sendKeys("thilu6801@gmail.com");
//			driver.findElement(By.xpath("//input[@id='basic_password']")).sendKeys("123456");
//			driver.findElement(By.xpath("//span[contains(text(),'Đăng nhập')]")).click();
//			sleepInSecond(2);
//			
//			
//		}

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
