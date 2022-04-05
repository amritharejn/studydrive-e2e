package StudyDrive;

import PageObjects.*;
import Resources.Base;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DocumentTests extends Base {

    private DocumentPage _document;
	private LandingPage _landingPage;
	private LoginPage _loginPage;

	private WebDriver _driver;

	public DocumentTests() {
		_driver = getDriver();
        _document = new DocumentPage(_driver);
		_landingPage = new LandingPage(_driver);
		_loginPage = new LoginPage(_driver);

	}

	@Test
	public void DocumentVerification() throws InterruptedException {
		_landingPage.navigate();
		_landingPage.getLogin().click();

		_loginPage.getEmail().sendKeys("testemailSD1@gmail.com");
		_loginPage.getPassword().sendKeys("Password@SD1");
		_loginPage.loginClick().click();

		_document.navigateTo("en", "amritha-coverletter-1", "1296521");

        String title = _document.getTitle();
        Assert.assertNotNull(_document.getCategory("Assignments"));
		Assert.assertNotNull(_document.getUser("Anonymous User"));

		Assert.assertEquals(title, "Amritha_CoverLetter (1).docx");
	}

}
