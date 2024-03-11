package FunctionalityTest;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Login {
	public static void main(String[] args) throws Throwable {

		FileInputStream path = new FileInputStream("./Data/LoginData.properties");
		Properties File = new Properties();
		File.load(path);
		String un = File.getProperty("username");
		String pwd = File.getProperty("password");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to("https://demo.dealsdray.com/");

		WebElement email = driver.findElement(By.name("username"));
		email.sendKeys(un);
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys(pwd);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		WebElement orderlist= driver.findElement(By.xpath("//span[text()='reorder']"));
		orderlist.click();
		
		WebElement orders= driver.findElement(By.xpath("//span[text()='Orders']"));
		orders.click();
		
		WebElement bulkorders = driver.findElement(By.xpath("//button[text()='Add Bulk Orders']"));
		bulkorders.click();
		
		WebElement choosefile = driver.findElement(By.xpath("//div[@class='MuiOutlinedInput-root MuiInputBase-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-sizeSmall css-uodm64']"));
		choosefile.click();
		Thread.sleep(2000);
		
		StringSelection root = new StringSelection("C:\\Users\\vignesh\\Desktop\\SQL CLASS\\demo-data.xlsx");
		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard(); 
		cb.setContents(root, null);
		
		Robot robo = new Robot(); 
		robo.keyPress(KeyEvent.VK_CONTROL);
		robo.keyPress(KeyEvent.VK_V);
		robo.keyRelease(KeyEvent.VK_CONTROL);
		robo.keyRelease(KeyEvent.VK_V);
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		WebElement upload = driver.findElement(By.xpath("//button[text()='Import']"));
		upload.click();
		Thread.sleep(2000);
		
		WebElement validatedata = driver.findElement(By.xpath("//button[text()='Validate Data']"));
		validatedata.click();
		Thread.sleep(3000);
		Alert a2 = driver.switchTo().alert();
		a2.accept();
		
		WebElement frame = driver.findElement(By.xpath("//button[text()='Previous']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;	
		jse.executeScript("arguments[0].scrollIntoView(true);", frame);
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Path = new File("./Data/MIS PANEL.png");
		File img = ts.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(img, Path);
		
		driver.quit();
	}
}
