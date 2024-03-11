package UITestingChrome;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class MobileResolution {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		//1.Resolution 360×640
		Dimension dim = new Dimension(360, 640);
		driver.manage().window().setSize(dim);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.getcalley.com/");

		TakesScreenshot ts = (TakesScreenshot)driver;
		File Path = new File("./Snaps/mobile/360x640.png");
		File img = ts.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img, Path);
		//2.Resolution 414×896
		Dimension dim1 = new Dimension(414, 896);
		driver.manage().window().setSize(dim1);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.getcalley.com/calley-call-from-browser/");

		TakesScreenshot ts1 = (TakesScreenshot)driver;
		File Path1 = new File("./Snaps/mobile/414x896.png");
		File img1 = ts1.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img1, Path1);
		//3.Resolution 375×667
		Dimension dim2 = new Dimension(375, 667);
		driver.manage().window().setSize(dim2);
		driver.get("https://www.getcalley.com/calley-pro-features/");
		
		TakesScreenshot ts2 = (TakesScreenshot)driver;
		File Path2 = new File("./Snaps/mobile/375x667.png");
		File img2 = ts2.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(img2, Path2);
		driver.quit();
	}

}
