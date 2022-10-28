package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "username")
	WebElement uName;

	@FindAll({ @FindBy(id = "password"), @FindBy(name = "password") })
	WebElement pwd;

	@FindAll({ @FindBy(id = "login"), @FindBy(className = "button"), @FindBy(name = "login_button") })
	WebElement loginBtn;

	public void enterUsernameAction(String user) {
		uName.clear();
		uName.sendKeys(user);
	}

	public void enterPasswordAction(String pass) {
		pwd.clear();
		pwd.sendKeys(pass);
	}

	public void clickLoginAction() {
		loginBtn.click();
	}
}
