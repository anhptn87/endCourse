package vt.endCourse.pages;

import org.openqa.selenium.support.FindBy;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("http://testmaster.vn/")
public class LandingPage extends PageObject {
	@FindBy(xpath = "//input")
	private WebElementFacade txtSubEmail;
	@FindBy(xpath = "//input/../following-sibling::div[2]/span")
	private WebElementFacade errorOnPage;
	@FindBy(xpath = "//button[@class='next-btn-primary']")
	private WebElementFacade btn_sub;
	@FindBy(css = "#allow-button")
	private WebElementFacade btn_allow;
	@FindBy(xpath = "//div[@class='body-message']")
	private WebElementFacade popUpMess;

	public void enter_subcriber_email(String val) {
		txtSubEmail.type(val);
	}

	public void click_subscriber_button() {
		btn_sub.click();
	}

	public String get_error_content_on_form() {
		return errorOnPage.getText();
	}

	public String get_error_content_on_popup_message() {
		return popUpMess.getText();
	}
	
	public void click_allow_button() {
		btn_allow.click();
	}
	
}
