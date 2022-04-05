package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

		public WebDriver driver;
		By searchBox= By.cssSelector("form[id=\"search-form\"]");


				public SearchPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;

		}

		public WebElement searchData()
		{
			return driver.findElement(searchBox);
			
		}
	
	

	
	
	
	

}
