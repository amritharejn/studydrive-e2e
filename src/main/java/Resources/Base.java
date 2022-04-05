package Resources;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public Base() {
		try {
			initializeDriver();
		}
		catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	private WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public void initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		String resource_path = Paths.get(
				new java.io.File(".").getCanonicalPath(),
				"src", "data.properties").toString();

		FileInputStream fis= new FileInputStream(resource_path);
		prop.load(fis);

		String browserName = prop.getProperty("browser");

		switch (browserName) {
			case "chrome":
			    String browserPath = prop.getProperty("path");
				System.setProperty("webdriver.chrome.driver",browserPath);
				driver = new ChromeDriver();
				break;
			case "firefox":
			case "IE":
			default: break;
		}

		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
}
