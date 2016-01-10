package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	By username = By.xpath("//input[@placeholder='Username or email']");
	By password = By.xpath("//input[@placeholder = 'Password']");
	By SignIn = By.xpath(".//*[@id='AT_SignIn_Button']");
	By checkBox = By.id("remember_me_check_box");
	By titleText = By.xpath(".//*[@id='content']/div[2]/div[1]/h1");
	By errorMessage = By.xpath(".//*[@id='accountForm']/div/div/span");

	public LoginPage(WebDriver driver) {

		this.driver = driver;

	}

	public void setUserid(String userid) {
		driver.findElement(username).sendKeys(userid);

	}

	public void setPassword(String userpassword) {
		driver.findElement(password).sendKeys(userpassword);
	}

	public void ClickSignIn() {
		driver.findElement(SignIn).click();
	}

	
		 //Get the title of Login Page
	 
    public String getLoginTitle(){
 
     return    driver.findElement(titleText).getText();
 
    }
    
    public boolean ValidateCheckbox(){
    	 
        return    driver.findElement(checkBox).isSelected();
}
    public boolean ValidateAd(){
   	 
        return    driver.findElement(checkBox).isDisplayed();
}
    public boolean ValidateErrorMessage(){
      	 
        return    driver.findElement(errorMessage).isDisplayed();
}
}


