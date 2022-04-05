package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DocumentPage {

	public WebDriver driver;
	By title = By.cssSelector("h1");
	By searchButton = By.cssSelector("button[id=\"go-to-search-page\"]");

	public DocumentPage(WebDriver driver) {
		this.driver = driver;
	}

	public void navigateTo(String locale, String slug, String id) {
		driver.get("https://www.studydrive.net/"+locale+"/doc/"+slug+"/"+id);
	}

	public String getTitle()
	{
		return driver.findElement(title).getText();
	}

	public WebElement getCategory(String category) {
		By element = getElementByText(category);
		return driver.findElement(element);
	}

	public WebElement getUser(String user) {
		By element = getElementByText(user);
		return driver.findElement(element);
	}

	private By getElementByText(String text) {
		return By.xpath("//*[contains(text(),'"+text+"')]");
	}

}
