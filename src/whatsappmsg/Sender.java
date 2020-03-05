package whatsappmsg;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Sender {
	private WebDriver driver;
	public Sender() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress","localhost:9014");
		 
		driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);			
	}
	private void send(String contactId, String message)throws Exception {
		driver.get("https://api.whatsapp.com/send?phone="+contactId+"&text="+message);
		Thread.sleep(2000);
   	   	WebElement elem = driver.findElement(By.xpath("//div[contains(@class, '_whatsapp_www__block_action')]/a"));
   	   	elem.click();
		Thread.sleep(2000);
   	   	WebElement sendElem = driver.findElement(By.xpath("//div/a[contains(text(),'use WhatsApp Web')]"));
   	   	sendElem.click();
   	   	Thread.sleep(8000);
		WebElement txtElem = driver.findElement(By.xpath("//footer/div/div/div[contains(@class, '_3FeAD _1PRhq')]/div[contains(@class,'_3u328 copyable-text selectable-text')]"));
		txtElem.clear();
		txtElem.sendKeys(message);
		WebElement btnElem = driver.findElement(By.xpath("//button[contains(@class,'_3M-N-')]"));
		btnElem.click();
		Thread.sleep(2000);		
	}
	private void sendAttach(String contactId, String message, String attachType, String attachFile)throws Exception {
		String apiUrl = "https://api.whatsapp.com/send?phone="+contactId;		
		if("image".equalsIgnoreCase(attachType))
			apiUrl += "&text="+message;
		driver.get(apiUrl);
		Thread.sleep(2000);
   	   	WebElement elem = driver.findElement(By.xpath("//div[contains(@class, '_whatsapp_www__block_action')]/a"));
   	   	elem.click();
		Thread.sleep(2000);
   	   	WebElement sendElem = driver.findElement(By.xpath("//div/a[contains(text(),'use WhatsApp Web')]"));
   	   	sendElem.click();
   	   	Thread.sleep(2000);
   	   	WebElement attachElem = driver.findElement(By.xpath("//div[contains(@title, 'Attach')]"));
   	   	attachElem.click();
	   	Thread.sleep(2000);
	   	WebElement docAttachElem = driver.findElement(By.xpath("//span/div/div/ul/li/button[contains(@class, 'Ijb1Q')]/input"));
	   	docAttachElem.sendKeys(attachFile);
	   	WebElement btnAttachElem = driver.findElement(By.xpath("//div[contains(@class, '_10V4p _1jxtm')]/span/div/span/div/div/div/span/div/div"));
	   	btnAttachElem.click();
	   	Thread.sleep(2000);

	}
	public static void main(String[] args)throws Exception {
		System.setProperty("webdriver.chrome.driver", "D:\\SeleniumScripts\\libs\\chromedriver.exe"); 
		Sender sender = new Sender();
		sender.sendAttach("919573725223", "Hello", "image", "C:\\Users\\KIT313\\Downloads\\IMG-20191030-WA0001.jpg");
		//sender.sendAttach("919573725223", "Hello", "pdf", "C:\\Users\\KIT313\\Downloads\\Manager Engineering Java.pdf");
	}
}
