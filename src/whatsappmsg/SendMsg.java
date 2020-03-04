package whatsappmsg;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver.WindowType;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SendMsg {
	static WebDriverWait wait;
	static String csvFile = "D:/SeleniumScripts/libs/Details.csv";
	static String line = " ";
	static String cvsSplitBy = ",";
	public static String [] ContactInfo = null;
	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumScripts\\libs\\chromedriver.exe"); 
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress","localhost:9014");
		 
		WebDriver driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);	
//		driver.manage().window().maximize();
		
		
/*		Robot rob = new Robot();
		rob.keyPress(KeyEvent.VK_CONTROL);
		rob.keyPress(KeyEvent.VK_T);
		rob.keyRelease(KeyEvent.VK_CONTROL);
		rob.keyRelease(KeyEvent.VK_T);
		Set<String> ids = driver.getWindowHandles();
		System.out.println(ids);*/
//		driver.switchTo().window(WindowType.TAB);
		
		//driver.findElement(By.className("web")).sendKeys(Keys.CONTROL +"t");
		/*
		 * WebElement link= driver.findElement(By.tagName("body")); String keyString =
		 * Keys.CONTROL+Keys.SHIFT.toString()+Keys.ENTER.toString();
		 * link.sendKeys(Keys.CONTROL +"t");
		 */
		
//		ArrayList<String> tabs = new ArrayList<String> (ids);
//	    driver.switchTo().window(tabs.get(2)); //switches to new tab
	    
//		driver.findElement(By.cssSelector("#side > header > div.sbcXq > div > span > div:nth-child(2)")).click();
		Thread.sleep(2000);
		
		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) 
		 {
		 	while ((line = br.readLine()) != null) 
			{
		    	ContactInfo = line.split(cvsSplitBy);
		   	   	int i = 0;
		   	   	int j = 1;
		   	// searchContact(driver, ContactInfo[i]);
				//driver.findElement(By.cssSelector("#app > div > div > div._37f_5 > div._3HZor._3kF8H > span > div > span > div > div:nth-child(2) > div > label > input")).sendKeys(ContactInfo[i]);
		   	   	WebElement elem = driver.findElement(By.xpath("//div[contains(@class, '_3u328 copyable-text selectable-text')]"));
		   	   	elem.clear();
		   	   	elem.sendKeys(ContactInfo[i]);
				Thread.sleep(2000);
				WebElement contact = driver.findElement(By.xpath("//div[contains(@class,'X7YrQ')]"));
				contact.click();
				Thread.sleep(2000);
				WebElement txtElem = driver.findElement(By.xpath("//div[contains(@class, '_3FeAD _1PRhq')]/div[contains(@class,'_3u328 copyable-text selectable-text')]"));
				txtElem.clear();
				txtElem.sendKeys("Hello");
				WebElement btnElem = driver.findElement(By.xpath("//button[contains(@class,'_3M-N-')]"));
				btnElem.click();
				Thread.sleep(2000);
/*				Actions action = new Actions(driver);
				action.sendKeys(Keys.ENTER).build().perform();
				driver.findElement(By.cssSelector("#main > footer > div._2i7Ej.copyable-area > div._13mgZ > div > div._3u328.copyable-text.selectable-text")).sendKeys(ContactInfo[j]);
				Thread.sleep(2000);
				action.sendKeys(Keys.ENTER).build().perform();
				driver.findElement(By.cssSelector("#side > header > div.sbcXq > div > span > div:nth-child(2)")).click();
				Thread.sleep(2000);*/
		        i++;
		        j++;	            	
			}
		 } 
		catch (IOException e) 
		{
		       e.printStackTrace();
		}
	}
	private static void searchContact(WebDriver driver, String contactId) {
		WebElement panel = driver.findElement(By.xpath("//div[contains(@class,'_3FeAD uu8jX')]"));
		panel.sendKeys(contactId);
		WebElement contact = driver.findElement(By.xpath("//div[contains(@class,'X7YrQ')]"));
		contact.click();
	}
}
