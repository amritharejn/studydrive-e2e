package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage {

	public WebDriver driver;

	public SearchResultsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement specificSearchResult(String expectedResult) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(getSearchResult(expectedResult)));

		return driver.findElement(getSearchResult(expectedResult));
	}

	public String getResultCount() {
		By headline = getSearchResult(" results");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(headline));

		WebElement headlineElement = driver.findElement(headline);
		String[] tokenized = headlineElement.getText().split(" ");
		return tokenized[0];
	}

	private By getSearchResult(String expectedResult) {
		return By.xpath("//*[contains(text(),'"+expectedResult+"')]");
	}
}
