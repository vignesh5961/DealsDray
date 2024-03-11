package UITestingChrome;

import java.io.File;
import java.time.Duration;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;


public class DesktopResolution {

	public static void main(String[] args) throws Throwable {
		WebDriver driver = new ChromeDriver();
		//1.Resolution 1920x1080
		Dimension dim = new Dimension(1920, 1080);
		driver.manage().window().setSize(dim);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.getcalley.com/");

		TakesScreenshot ts = (TakesScreenshot)driver;
		File Path = new File("./Snaps/Desktop/1920x1080.png");
		File img = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img, Path);
		//2.Resolution 1366x768
		Dimension dim1 = new Dimension(1366, 768);
		driver.manage().window().setSize(dim1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.getcalley.com/calley-call-from-browser/");

		TakesScreenshot ts1 = (TakesScreenshot)driver;
		File Path1 = new File("./Snaps/Desktop/1366x768.png");
		File img1 = ts1.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img1, Path1);
		//3.Resolution 1536x864
		Dimension dim2 = new Dimension(1536, 864);
		driver.manage().window().setSize(dim2);
		driver.get("https://www.getcalley.com/calley-pro-features/");
		
		TakesScreenshot ts2 = (TakesScreenshot)driver;
		File Path2 = new File("./Snaps/Desktop/1536x864.png");
		File img2 = ts2.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img2, Path2);
		
		driver.quit();
	}

}
