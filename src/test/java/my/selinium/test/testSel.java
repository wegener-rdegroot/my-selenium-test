package my.selinium.test;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
 
import org.junit.Assert.*;
import junit.framework.AssertionFailedError;
 
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
 
public class testSel {
   private WebDriver driver;
   private String baseUrl="";
   private StringBuffer verificationErrors = new StringBuffer();
   @Before
   public void setUp() throws Exception {
	 System.setProperty("webdriver.chrome.driver", "C:\\Webdrivers\\chromedriver.exe");  
     driver = new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   }
 
   @Test
   public void testUntitled() throws Exception {
     driver.get("http://seleniumhq.org/");
     driver.findElement(By.linkText("Projects")).click();
     driver.findElement(By.linkText("Selenium IDE")).click();
     System.out.println(driver.findElement(By.xpath("//*[@id='mainContent']/table/tbody/tr/td[1]/p[1]/b")).getText());
   
     
     Assert.assertEquals("Text Found", "Selenium IDE", driver.findElement(By.xpath("//div[@id='mainContent']/table/tbody/tr/td[1]/p[1]/b")).getText());
   }
   @After
   public void tearDown() throws Exception {
     driver.quit();
     String verificationErrorString = verificationErrors.toString();
     if (!"".equals(verificationErrorString)) {
       fail(verificationErrorString);
     }
   }
 
   private boolean isElementPresent(By by) {
     try {
       driver.findElement(by);
       return true;
     } catch (NoSuchElementException e) {
       return false;
     }
   }
 }
