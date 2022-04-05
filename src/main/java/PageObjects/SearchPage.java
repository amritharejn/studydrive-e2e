package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	public WebDriver driver;
	By searchBox= By.cssSelector("input[name=\"phrase\"]");
	By searchButton = By.cssSelector("button[id=\"go-to-search-page\"]");

	public SearchPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement searchBox()
	{
		return driver.findElement(searchBox);
	}

	public void search() {
		driver.findElement(searchButton).click();
	}
}
