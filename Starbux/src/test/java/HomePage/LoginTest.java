package HomePage;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginTest {

	WebDriver driver;

	@Before
	public void setup() {

		driver = new FirefoxDriver();
		driver.get("https://www.starbucks.com/account/signin");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Test
	public void LoginApp() {

		LoginPage lp = new LoginPage(driver);
		String loginPageTitle = lp.getLoginTitle();

		// Verify Page Title
		Assert.assertTrue(loginPageTitle.contains("Sign In or Create a Starbucks Account"));

		// Validate checkbox is checked
		boolean verifycheckBox = lp.ValidateCheckbox();
		assertTrue("Checkbox is not checked", verifycheckBox);

		// Enter Username
		lp.setUserid("singh.nyc1@gmail.com");
		// Enter Password
		lp.setPassword("Testing1#");
		// Click on SignIn
		lp.ClickSignIn();

		// Validate the user is signed in successfully and My Account page appears

		AccountPage ap = new AccountPage(driver);
		boolean validateWelcometextdisplay = ap.ValidateWelcomeText();
		assertTrue("Login Failed", validateWelcometextdisplay);
		System.out.println("Login successful");

		// wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// Validate the presence of ad
		boolean validateAdDisplay = ap.ValidateAd();
		assertTrue("Login Failed", validateAdDisplay);
		System.out.println("Ad appears as expected");

		// validate the link names in the header section

		List<WebElement> links = driver.findElements(By.xpath(".//*[@id='header']"));

		for (WebElement linkname : links)
			System.out.println(linkname.getText());

		// close browser
		driver.quit();

	}

	// Validate Error message displays when user try to login with Invalid
	// Credentials

	@Test
	public void validateErrorMessage() {
		LoginPage lp = new LoginPage(driver);
		lp.setUserid("12345ffsf");
		lp.setPassword("?&*008jjij");
		lp.ClickSignIn();
		boolean ErrorMessage = lp.ValidateErrorMessage();
		assertTrue("Login Failed", ErrorMessage);
		System.out.println("Error message is displayed");
		// close browser
		driver.quit();

	}

}
