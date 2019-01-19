package vt.endCourse.steps.serenity;

import net.thucydides.core.annotations.Step;
import vt.endCourse.pages.CreateNewsPage;
import vt.endCourse.pages.LogInPage;

public class CreateNewsUser {
	LogInPage login;
	CreateNewsPage createNews;

	@Step
	public void log_in(String email, String password) {
		login.open();
		login.enter_email(email);
		login.enter_password(password);
		login.click_login();
	}

	@Step
	public boolean is_logged_in() {
		return createNews.is_logged_in();
	}

	@Step
	public void go_to_create_news_page() {
		createNews.click_send_news_link();
	}

	@Step
	public void fill_news_information(String group, String name, String subject, String body, String attachPath)
			throws InterruptedException {
		if (group != null & !group.equals(""))
			createNews.choose_group(group);
		if (name != null & !name.equals(""))
			createNews.enter_name(name);
		if (subject != null & !subject.equals(""))
			createNews.enter_subject(subject);
		if (body != null & !body.equals(""))
			createNews.enter_body(body);
		if (attachPath != null & !attachPath.equals(""))
			createNews.choose_file(attachPath);
		createNews.click_next();
	}

	@Step
	public String see_error_under_group() {
		return createNews.get_error_under_group();
	}

	@Step
	public String see_error_under_name() {
		return createNews.get_error_under_name();
	}

	@Step
	public String see_error_under_subject() {
		return createNews.get_error_under_subject();
	}

	@Step
	public String see_error_under_body() {
		return createNews.get_error_under_body();
	}

	@Step
	public String see_displaying_group_value() {
		return createNews.get_displaying_group_value();
	}

	@Step
	public String see_error_under_date() {
		return createNews.get_error_under_date();
	}

	@Step
	public String see_error_under_time() {
		return createNews.get_error_under_time();
	}

	@Step
	public void enter_name(String name) {
		createNews.enter_name(name);
		createNews.click_next();
	}

	@Step
	public boolean see_icon_picture() {
		return createNews.icon_picture_appear();
	}

	@Step
	public boolean see_icon_video() {
		return createNews.icon_video_appear();
	}

	@Step
	public boolean see_button_send_now() {
		return createNews.button_send_now_is_present();
	}

	@Step
	public void upload_file(String path) throws InterruptedException {
		createNews.choose_file(path);

	}

	@Step
	public String see_error_attach_file() {
		return createNews.get_attach_file_error();
	}

	@Step
	public String see_the_uploaded_file_name() {
		return createNews.get_uploaded_file_name();
	}

	@Step
	public void click_close_icon_to_remove_file() {
		createNews.click_remove_file();
	}

	@Step
	public void confirm_remove_file() {
		createNews.click_confirm_remove_button();
	}

	@Step
	public boolean see_file_is_appeared(String fileName) {
		return createNews.is_file_appears(fileName);
	}

	@Step
	public void enter_body(String body) {
		createNews.enter_body(body);
	}

	@Step
	public String see_merge_tag_name() {
		return createNews.get_merge_tag_name();
	}

	@Step
	public void choose_a_merge_tag() {
		createNews.click_on_merge_tag();
	}

	@Step
	public String see_selected_merge_tag_name() {
		return createNews.get_selected_merge_tag_name();
	}

	@Step
	public void click_send_now_button() {
		createNews.click_button_send_now();
	}

	@Step
	public String see_pop_up_message_on_send_news_page() {
		return createNews.get_popup_message_content();
	}

	@Step
	public void enter_date(String date) {
		createNews.enter_date(date);
	}

	@Step
	public void enter_time(String time) {
		createNews.enter_time(time);
	}

	@Step
	public void click_send_later_button() {
		createNews.click_send_later_butotn();
	}
	/*
	 * @Step public boolean see_uploaded_file(String fileName) { return null; }
	 */
}
