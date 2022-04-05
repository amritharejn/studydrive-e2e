package StudyDrive;

import PageObjects.SearchPage;
import PageObjects.SearchResultsPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;

public class SearchTests extends Base {
	private LandingPage _landingPage;
	private LoginPage _loginPage;
	private SearchPage _searchPage;
	private SearchResultsPage _resultPage;

	private WebDriver _driver;

	public SearchTests() {
		_driver = getDriver();
		_landingPage = new LandingPage(_driver);
		_loginPage = new LoginPage(_driver);
		_searchPage = new SearchPage(_driver);
		_resultPage = new SearchResultsPage(_driver);
	}

	@Test
	public void LoginDocumentSearch_Success() throws InterruptedException {
		_landingPage.navigate();
		_landingPage.getLogin().click();

		_loginPage.getEmail().sendKeys("testemailSD1@gmail.com");
		_loginPage.getPassword().sendKeys("Password@SD1");
		_loginPage.loginClick().click();

		_searchPage.searchBox().sendKeys("amritha");
		_searchPage.search();

		_resultPage.specificSearchResult("Amritha_CoverLetter (1).docx").click();
	}

	@Test
	public void LoginDocumentSearch_NotFound_Success() throws InterruptedException {
		_landingPage.navigate();
		_landingPage.getLogin().click();

		_loginPage.getEmail().sendKeys("testemailSD1@gmail.com");
		_loginPage.getPassword().sendKeys("Password@SD1");
		_loginPage.loginClick().click();

		_searchPage.searchBox().sendKeys("qwerty");
		_searchPage.search();

		String results = _resultPage.getResultCount();
		Assert.assertEquals(results, "0");
	}


}
