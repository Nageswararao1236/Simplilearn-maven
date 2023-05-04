package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	// ============================ Objects ======================================

	@FindBy(linkText = "Log in")
	WebElement loginLink;

	@FindBy(name = "user_login")
	WebElement userName;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(className = "rememberMe")
	WebElement RememberMe;

	@FindBy(name = "btn_login")
	WebElement loginBtn;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void LoginFunction(String UserName, String Password) throws InterruptedException {

		PageFactory.initElements(driver, this);
		Thread.sleep(4000);
		loginLink.click();
		userName.sendKeys(UserName);
		password.sendKeys(Password);
		RememberMe.click();
		loginBtn.click();
		Thread.sleep(4000);

//		driver.findElement(By.linkText("Log in")).click();
//		driver.findElement(By.name("user_login")).sendKeys(UserName);
//		driver.findElement(By.id("password")).sendKeys(Password);
//		driver.findElement(By.className("rememberMe")).click();
//		driver.findElement(By.name("btn_login")).click();

	}
}
