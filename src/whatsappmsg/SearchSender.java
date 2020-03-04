package whatsappmsg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SearchSender {
	private WebDriver driver;
	public SearchSender() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress","localhost:9014");
		 
		driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);			
	}
	private void send(String contactId, String message)throws Exception {
   	   	WebElement elem = driver.findElement(By.xpath("//div[contains(@class, '_3u328 copyable-text selectable-text')]"));
   	   	elem.clear();
   	   	elem.sendKeys(contactId);
		Thread.sleep(2000);
		WebElement contact = driver.findElement(By.xpath("//div[contains(@class,'X7YrQ') and contains(@style, 'z-index: 0')]"));
		contact.click();
		Thread.sleep(2000);
		WebElement txtElem = driver.findElement(By.xpath("//footer/div/div/div[contains(@class, '_3FeAD _1PRhq')]/div[contains(@class,'_3u328 copyable-text selectable-text')]"));
		txtElem.clear();
		txtElem.sendKeys(message);
		WebElement btnElem = driver.findElement(By.xpath("//button[contains(@class,'_3M-N-')]"));
		btnElem.click();
		Thread.sleep(2000);		
	}
	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumScripts\\libs\\chromedriver.exe"); 
		SearchSender sender = new SearchSender();
		sender.send("+919573725223", "Hello");
	}
}
