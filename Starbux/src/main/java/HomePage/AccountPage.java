package HomePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountPage {
	
	WebDriver driver;

	By ad = By.xpath(".//*[@id='bd_top_messenger']/div/fieldset[2]/div[2]/ul/li/button");
		By checkBox = By.id("remember_me_check_box");
	By welcomeText = By.xpath("//h2[@class='welcome-message']");

	public AccountPage(WebDriver driver) {

		this.driver = driver;

	}
	
		 //Validate Welcome text
	 
    public boolean ValidateWelcomeText(){
 
     return    driver.findElement(welcomeText).isDisplayed();
 
    }
    
    public boolean ValidateCheckbox(){
    	 
        return    driver.findElement(checkBox).isSelected();
}
    public boolean ValidateAd(){
   	 
        return    driver.findElement(ad).isDisplayed();
}

}
