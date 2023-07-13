import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Page {

    private WebDriver driver;
    private String baseURL = "https://pudra.by/";
    private String enterBtnLocator = "//div[@class='topbar-content']/a[@href='#modalSign']";
    private String emailInputLocator = "emailSign";
    private String passwordInputLocator = "passwordSign";
    private String loginBtnLocator = "//form[@id='formSign']/div[@class='row']/div/button";
    private String errorMessageLocator = "//div[@class='form-group form-group-error']/label[@class='error' and @style='display: block;']";

    public Page(){

        this.driver = DriverSingleton.getDriver();
    }

    public Page getURL(){

        driver.get(baseURL);
        return this;
    }

    public Page clickEnterBtn(){

        WebElement enterBtn = driver.findElement(By.xpath(enterBtnLocator));
        enterBtn.click();
        return this;
    }

    public Page fillEmail(String email){

        WebElement emailInput = driver.findElement(By.name(emailInputLocator));
        emailInput.sendKeys(email);
        return this;
    }

    public Page fillPassword(String password){

        WebElement passwordInput = driver.findElement(By.name(passwordInputLocator));
        passwordInput.sendKeys(password);
        return this;
    }

    public Page clickLoginBtn(){

        WebElement loginBtn = driver.findElement(By.xpath(loginBtnLocator));
        loginBtn.click();
        return this;
    }

    public String getErrorMessage(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(errorMessageLocator)));
        String errorMessageText = errorMessage.getText();
        return errorMessageText;
    }
}
