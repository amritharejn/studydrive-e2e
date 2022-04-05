package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
		private WebDriver _driver;
		private LandingPage _landingPage;

		By email= By.cssSelector("input[type='email']");
		By password= By.cssSelector("input[type='password']");
		By loginButton = By.xpath("//button/span[contains(text(), 'Log in')]");
		
		public LoginPage(WebDriver driver, LandingPage landingPage) {
			_driver = driver;
			_landingPage = landingPage;
		}

		public WebElement getEmail() 
		{
			return _driver.findElement(email);
		}
	
	
		public WebElement getPassword() 
		{
			return _driver.findElement(password);
		}


		public WebElement loginClick()
		{
			return _driver.findElement(loginButton);
		}

		public void login(String email, String password) throws InterruptedException {
			_driver.manage().deleteAllCookies();

			_landingPage.navigate();
			_landingPage.getLogin().click();

			getEmail().sendKeys(email);
			getPassword().sendKeys(password);
			loginClick().click();
		}


}
