package whatsappmsg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Listener {
	private WebDriver driver;
	public Listener() {
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("debuggerAddress","localhost:9014");
		 
		driver= new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);			
	}
	private void assignListener(String contactId)throws Exception {
		while (true) {
			List<WebElement> contacts = driver.findElements(By.xpath("//span[contains(@class,'P6z4j')]"));
			for(WebElement contact : contacts) {
				contact.click();
				break;
			}
		}
	}
	public static void main(String[] args) throws Exception{
		Listener listener = new Listener();
		listener.assignListener("");
	}

}
