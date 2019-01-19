package vt.endCourse.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class ExtraForm extends PageObject {
	@FindBy(xpath = "//input[@type='text']")
	private WebElementFacade txt_HoVaTen;

	@FindBy(xpath = "//div[contains(text(),'Họ và tên')]/span")
	private WebElementFacade lbl_HoVaTen_asterisk;

	@FindBy(id = "ddlGender")
	private WebElementFacade btn_Gender;

	@FindBy(xpath = "//div[contains(text(),'Giới tính')]/span")
	private WebElementFacade lbl_Gender_asterisk;

	@FindBy(xpath = "//*[@id='ddlGender']/span[@class='content-display']")
	private WebElementFacade lbl_DisplayingGender;

	@FindBy(id = "ddlNewsType")
	private WebElementFacade btn_NewsType;

	@FindBy(xpath = "//div[contains(text(),'Loại tin muốn nhận')]/span")
	private WebElementFacade lbl_NewsType_asterisk;

	@FindBy(xpath = "//*[@id='ddlNewsType']/span[@class='content-display']")
	private WebElementFacade lbl_DisplayingNewsType;

	@FindBy(css = "#allow-button")
	private WebElementFacade btn_agree;

	@FindBy(xpath = "//*[@id='fullname']/following-sibling::div")
	private WebElementFacade lbl_error_message_fullname;
	
	@FindBy(xpath = "//*[@id='ddlGender']/following-sibling::div")
	private WebElementFacade lbl_error_message_gender;
	

	private By genderValue(String gender) {
		return By.xpath("//ul[@aria-labelledby='ddlGender']//a[text()='" + gender + "']");
	}

	private By newsTypeValue(String type) {
		return By.xpath("//ul[@aria-labelledby='ddlNewsType']//a[text()='" + type + "']");
	}

	public void enter_fullname(String fullname) {
		txt_HoVaTen.type(fullname);
	}

	public void choose_gender(String gender) {
		btn_Gender.click();
		this.getDriver().findElement(genderValue(gender)).click();
	}

	public void chooes_news_type(String type) {
		btn_NewsType.click();
		this.getDriver().findElement(newsTypeValue(type)).click();
	}

	public void click_agree_button() {
		btn_agree.click();
	}

	public String getSelectingGender() {
		return lbl_DisplayingGender.getText();
	}

	public String getSelectingNewstype() {
		return lbl_DisplayingNewsType.getText();
	}

	public String getAsteriskInFullnameLabel() {
		return lbl_HoVaTen_asterisk.getText();
	}

	public String getAsteriskInGenderLabel() {
		return lbl_Gender_asterisk.getText();
	}

	public String getAsteriskInNewsTypeLabel() {
		return lbl_NewsType_asterisk.getText();
	}

	public String getErrorMessageUnderFullnameField() {
		return lbl_error_message_fullname.getText();
	}
	public String getErrorMessageUnderGenderField() {
		return lbl_error_message_gender.getText();
	}
}
