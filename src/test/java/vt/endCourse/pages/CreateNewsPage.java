package vt.endCourse.pages;

import java.awt.event.KeyEvent;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import vt.endCourse.util.Util;

@DefaultUrl("http://testmaster.vn/Admin")
public class CreateNewsPage extends PageObject {
	@FindBy(xpath = "//a[@action='/subscription/sendnews']")
	private WebElementFacade link_sendnews;

	@FindBy(xpath = "//b[text()='CREATE NEWS']")
	private WebElementFacade lbl_create_news;

	@FindBy(id = "ddlGroup")
	private WebElementFacade btn_group;

	private By groupValue(String groupName) {
		return By.xpath("//ul//a[text()='" + groupName + "']");
	}

	@FindBy(id = "txtName")
	private WebElementFacade txt_name;

	@FindBy(id = "txtSubject")
	private WebElementFacade txt_subject;

	@FindBy(xpath = "//div[@class='note-editable panel-body']/p")
	private WebElementFacade body;

	@FindBy(xpath = "//button/span[text()='Next']")
	private WebElementFacade btn_next;

	@FindBy(xpath = "//span[@class='btn btn-sm btn-default btn-upload']")
	private WebElementFacade attach_file;

	@FindBy(xpath = "//*[@id='ddlGroup']/following-sibling::div[@class='error']")
	private WebElementFacade err_under_group;

	@FindBy(xpath = "//*[@id='ddlGroup']/span[@class='content-display']")
	private WebElementFacade displaying_group_value;

	@FindBy(xpath = "//*[@id='txtName']/following-sibling::div[@class='error']")
	private WebElementFacade err_under_name;

	@FindBy(xpath = "//*[@id='txtSubject']/following-sibling::div[@class='error']")
	private WebElementFacade err_under_subject;

	@FindBy(xpath = "//div[@class='note-editor note-frame panel panel-default error']/following-sibling::div[@class='error']")
	private WebElementFacade err_under_body;

	@FindBy(xpath = "//*[@id='input-date']/following-sibling::div[@class='error']")
	private WebElementFacade err_under_date;

	@FindBy(xpath = "//*[@id='input-time']/following-sibling::div[@class='error']")
	private WebElementFacade err_under_time;

	@FindBy(xpath = "//div[@class='user-panel']")
	private WebElementFacade username_panel;

	// this is list of file name
	@FindBy(xpath = "//td[@class='file-name']")
	private WebElementFacade file_names;

	private By file_name(String fileName) {
		String onlyFile = fileName.substring(0, fileName.lastIndexOf("."));
		return By.xpath("//td[@class='file-name'][contains(text(),'" + onlyFile + "')]");
	}

	@FindBy(xpath = "//button[@data-original-title='Picture']")
	private WebElementFacade ico_picture;

	@FindBy(xpath = "//button[@data-original-title='Video']")
	private WebElementFacade ico_video;

	@FindBy(id = "sendNow")
	private WebElementFacade btn_send_now;

	@FindBy(xpath = "not determined")
	private WebElementFacade error_attach_file;

	@FindBy(xpath = "//td[@class='file-remove']")
	private WebElementFacade ico_remove_file;

	@FindBy(xpath = "not determined")
	private WebElementFacade btn_confirm_remove;

	@FindBy(xpath = "//div[@class='note-popover popover in note-hint-popover'][contains(@style,'display: block')]//div[@class='note-hint-item active']")
	private WebElementFacade merge_tag_preselect;

	@FindBy(xpath = "//span[@class='merge-tag']")
	private WebElementFacade merge_tag_after_selected;

	@FindBy(xpath = "//div[@class='body-message']")
	private WebElementFacade pop_up_message; // on SEND NEWS page

	@FindBy(id = "input-date")
	private WebElementFacade txt_input_date;

	@FindBy(id = "input-time")
	private WebElementFacade txt_input_time;

	@FindBy(xpath = "//button[@class='btn btn-sm btn-primary btn-save-news']")
	private WebElementFacade btn_send_later;

	public void click_send_later_butotn() {
		btn_send_later.click();
	}

	public void enter_time(String time) {
		txt_input_time.type(time);
	}

	public void enter_date(String date) {
		txt_input_date.clear();
		txt_input_date.type(date);
	}

	public String get_popup_message_content() {
		return pop_up_message.getText();
	}

	public String get_selected_merge_tag_name() {
		return merge_tag_after_selected.getText();
	}

	public String get_merge_tag_name() {
		return merge_tag_preselect.getText();
	}

	public boolean mertag_is_display() {
		return merge_tag_preselect.isPresent();
	}

	public void click_on_merge_tag() {
		merge_tag_preselect.click();
	}

	public void click_send_news_link() {
		link_sendnews.click();
	}

	public boolean is_file_appears(String filename) {
		if (this.getDriver().findElement(file_name(filename)) != null)
			return true;
		return false;
	}

	public void choose_file(String path) throws InterruptedException {
		Util util = new Util();

		lbl_create_news.click();
		for (int i = 0; i < 16; i++)
			util.setKey(KeyEvent.VK_DOWN);

		attach_file.click();
		Thread.sleep(1000);
		util.coppyPaste(path);
		Thread.sleep(1000);
		util.setKey(KeyEvent.VK_ENTER);
		Thread.sleep(1000);
	}

	public void enter_body(String val) {
		body.click();
		this.getDriver().switchTo().activeElement().sendKeys(val);
	}

	public void choose_group(String val) throws InterruptedException {
		btn_group.click();
		Thread.sleep(500);
		this.getDriver().findElement(groupValue(val)).click();
	}

	public void click_next() {
		btn_next.click();
	}

	public void enter_name(String value) {
		txt_name.type(value);
	}

	public void enter_subject(String val) {
		txt_subject.type(val);
	}

	public String get_error_under_group() {
		return err_under_group.getText();
	}

	public String get_error_under_body() {
		return err_under_body.getText();
	}

	public String get_error_under_name() {
		return err_under_name.getText();
	}

	public String get_error_under_subject() {
		return err_under_subject.getText();
	}

	public String get_error_under_date() {
		return err_under_date.getText();
	}

	public String get_error_under_time() {
		return err_under_time.getText();
	}

	public boolean is_logged_in() {
		return username_panel.isPresent();
	}

	public String get_uploaded_file_name() {
		return file_names.getText();
	}

	public String get_displaying_group_value() {
		return displaying_group_value.getText();
	}

	public boolean icon_picture_appear() {
		return ico_picture.isPresent();
	}

	public boolean icon_video_appear() {
		return ico_video.isPresent();
	}

	public boolean button_send_now_is_present() {
		return btn_send_now.isPresent();
	}

	public void click_button_send_now() {
		btn_send_now.click();
	}

	public String get_attach_file_error() {
		return error_attach_file.getText();
	}

	public void click_remove_file() {
		ico_remove_file.click();
	}

	public void click_confirm_remove_button() {
		btn_confirm_remove.click();
	}
}
