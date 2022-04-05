package StudyDrive;

import java.io.IOException;

import PageObjects.SearchPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class HomePage extends Base {


	@Test
	public void basePageNavigation() throws InterruptedException {
	
	WebDriver driver = getDriver();


	LandingPage l = new LandingPage(driver);

	l.navigate();
	l.getLogin().click();
	
	 LoginPage lp = new LoginPage(driver);
	 lp.getEmail().sendKeys("testemailSD1@gmail.com");
	 lp.getPassword().sendKeys("Password@SD1");
	 lp.loginClick().click();

	}
}
