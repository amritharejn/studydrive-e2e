package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage {
	By signIn = By.xpath("//button[text()=\"Log in\"]");
	By cookiePopup =  By.xpath("//*[@id=\"uc-center-container\"]");
	By cookieAcceptAll = By.cssSelector("button[data-testid=\"uc-accept-all-button\"]");

	private WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void navigate()
	{
		driver.get("https://www.studydrive.net/");
	}

	public void removeCookiePopup() throws InterruptedException {
		Thread.sleep(5000);

		//source: https://serveanswer.com/questions/i-cant-click-a-button-with-selenium-python
		WebElement acceptCookie = (WebElement)((JavascriptExecutor)driver)
				.executeScript("return document.querySelector(\"#usercentrics-root\").shadowRoot.querySelector(\"#uc-center-container > div:nth-child(2) div > button:nth-child(3)\")");
		if(acceptCookie != null) acceptCookie.click();
	}

	public WebElement getLogin() throws InterruptedException {
		removeCookiePopup();
		return driver.findElement(signIn);
	}
}
