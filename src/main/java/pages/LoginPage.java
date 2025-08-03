package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    By userIdLocator = By.id("formEmail"); 
    By passwordLocator = By.id("formPassword");  
    By loginButtonLocator = By.xpath("//button[@class = 'login-button']");
    By eyeIconLocator = By.xpath("//div[@class= 'passowrd-div']/img");
    By errorMsgLocator = By.className("invalid-credential-div"); 

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUserId(String userId) {
        driver.findElement(userIdLocator).sendKeys(userId);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordLocator).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButtonLocator).click();
    }

    public boolean isLoginButtonEnabled() {
        return driver.findElement(loginButtonLocator).isEnabled();
    }

    public boolean testPasswordMaskedbutton(){
        String type = driver.findElement(passwordLocator).getAttribute("type");
        return type.equals("password");
    }

    public void togglePasswordVisibility() {
        driver.findElement(eyeIconLocator).click();
    }

    public String testInvalidLoginShowErrorMsg() {
        return driver.findElement(errorMsgLocator).getText();
    }

//    public boolean isElementDisplayed(By locator) {
//        return driver.findElement(locator).isDisplayed();
//    }

    public boolean isPageLoaded() {
        return driver.findElement(userIdLocator).isDisplayed() &&
               driver.findElement(passwordLocator).isDisplayed() &&
               driver.findElement(eyeIconLocator).isDisplayed();
    }
    
    public boolean testLoginButtonDisabledWhenFieldAreEmpty() {
    	if(isPageLoaded()) {
    		String userIdValue= driver.findElement(userIdLocator).getAttribute("value");
    		String passwordValue = driver.findElement(passwordLocator).getAttribute("value");
    		if(userIdValue.isEmpty() && passwordValue.isEmpty()) {
    			return isLoginButtonEnabled();
    			
    		} else {
    			System.out.println("Either userId or passowrd field is not empty");
    			return false;
    		}
    	}else {
    		System.out.println("Page is not loaded properly");
    		return false;
    	}
    }
    
    
}