package Testcases;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.test.Base;
import org.testng.annotations.Test;

import Objects.HeaderObjects;

public class HeaderLink extends Base{
	@Test
	public void Header() {
		test=reports.createTest("Verify_the_Header_Links");
		PageFactory.initElements(driver, HeaderObjects.class);
		Actions a=new Actions(driver);
		a.moveToElement(HeaderObjects.move).perform();
		List<WebElement> heroImage = HeaderObjects.heroImage;
		for (WebElement image : heroImage) {
			image.click();
		}

	}

}
