package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void test1() throws InterruptedException {
		LoginPage login = new LoginPage(driver);

		login.LoginFunction("abc@test1.com", "Password@1234");
		WebElement error = driver.findElement(By.id("msg_box"));

		String ActError = error.getText();
		String ExpError = "The email or password you have entered is invalid.";

		Assert.assertEquals(ActError, ExpError);

	}

	@Test
	public void test2() throws InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.LoginFunction("abc@test2.com", "Password@2");

	}
	
	@Test
	public void test4() throws InterruptedException, FilloException {
		LoginPage login = new LoginPage(driver);
		Recordset recordset = connection.executeQuery("Select * from Sheet1 where TestName = 'test4'");
		recordset.next();
		String username = recordset.getField("UserName");
		String password = recordset.getField("Password");
		login.LoginFunction(username, password);

	
	}
}
