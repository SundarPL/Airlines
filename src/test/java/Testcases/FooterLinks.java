package Testcases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.test.Base;
import org.testng.annotations.Test;

import Objects.FooterObjects;

public class FooterLinks extends Base{
	String verifyLinks=null;
	@Test
	public void footerLink() throws IOException {
		test=reports.createTest("Verify_the_Footer_Links");
		PageFactory.initElements(driver, FooterObjects.class);
		Actions a=new Actions(driver);
		a.moveToElement(FooterObjects.lowView).perform();
		FooterObjects.tripPlan.click();
		List<WebElement> allFooterLinks = FooterObjects.allFooterLinks;
		for (WebElement footerLinks : allFooterLinks) {
			verifyLinks = footerLinks.getAttribute("href");
			System.out.println(verifyLinks);
			
		}
		verify(verifyLinks);

	}
	public void verify(String Links) throws IOException {
		URL url=new URL(Links);
		HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
		openConnection.setConnectTimeout(3000);
		openConnection.connect();
		if(openConnection.getResponseCode()==200)
        {
            System.out.println(Links+" - "+openConnection.getResponseMessage());
         }
       if(openConnection.getResponseCode()==400)  
        {
            System.out.println(Links+" - "+openConnection.getResponseMessage());
         }
	}

}
