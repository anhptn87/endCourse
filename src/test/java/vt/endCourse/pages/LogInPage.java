package vt.endCourse.pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://testmaster.vn/Admin")
public class LogInPage extends PageObject {
	@FindBy(xpath = "//input[@type='email']")
	private WebElementFacade txt_email;
	@FindBy(xpath = "//input[@type='password']")
	private WebElementFacade txt_password;
	@FindBy(xpath = "//button[@type='button']")
	private WebElementFacade btn_dangnhap;

	public void enter_email(String value) {
		txt_email.type(value);
	}

	public void enter_password(String pass) {
		txt_password.type(pass);
	}

	public void click_login() {
		btn_dangnhap.click();
	}
}
