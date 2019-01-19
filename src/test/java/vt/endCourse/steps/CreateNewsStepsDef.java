package vt.endCourse.steps;

import org.junit.Assert;
import org.junit.Test;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import vt.endCourse.steps.serenity.CreateNewsUser;

public class CreateNewsStepsDef {
	@Steps
	CreateNewsUser user;

	@Given("^I am on the create news page$")
	public void i_am_on_the_create_news_page() throws Exception {
		user.log_in("khanh.tx@live.com", "abc123");
		Assert.assertTrue(user.is_logged_in());
		user.go_to_create_news_page();
	}

	@When("^To test '(.*?)' I fill '(.*?)' '(.*?)' '(.*?)' '(.*?)' and press Next button$")
	public void to_test_field_I_fill_the_group_the_name_the_subject_the_body_and_press_Next_button(String field,
			String group, String name, String subject, String body) throws Exception {
		user.fill_news_information(group, name, subject, body, "");
	}

	@When("^I do nothing$")
	public void i_do_nothing() throws Exception {
	}

	@Then("^I should see defaul value of Group field is \"([^\"]*)\"$")
	public void i_should_see_defaul_value_of_Group_field_is(String defaulval) throws Exception {
		Assert.assertTrue(user.see_displaying_group_value().equalsIgnoreCase(defaulval));
	}

	@When("^I enter invalid value on the Name filed '(.*?)'$")
	public void i_enter_invalid_value_on_the_Name_filed(String name) throws Exception {
		String new_name;
		if (name.startsWith("@@@")) {
			new_name = name + "\n" + name;
		} else
			new_name = name;

		user.enter_name(new_name);
	}

	@Then("^I should see an error message \"([^\"]*)\" under the Name field$")
	public void i_should_see_an_error_message_under_the_Name_field(String errmaxlength) throws Exception {
		Assert.assertTrue(user.see_error_under_name().equalsIgnoreCase(errmaxlength));
	}

	@Then("^I should see media button on the body field$")
	public void i_should_see_media_button_on_the_body_field() throws Exception {
		Assert.assertTrue(user.see_icon_picture() & user.see_icon_video());
	}

	@When("^I fill all required inforation and press next button$")
	public void i_fill_all_required_inforation_and_press_next_button() throws Exception {
		user.fill_news_information("Không phân loại", "this is name", "this is subject", "this is body", "");
	}

	@Then("^I should see Send now button$")
	public void i_should_see_Send_now_button() throws Exception {
		user.see_button_send_now();
	}

	@When("^I upload a file '(.*?)'$")
	public void i_upload_a_file(String fileName) throws Exception {
		String folder_path = System.getProperty("user.dir");

		String path = folder_path + "\\data\\" + fileName;
		user.upload_file(path);
	}

	@Then("^I should see an error appears \"([^\"]*)\"$")
	public void i_should_see_an_error_appears(String arg1) throws Exception {
		Assert.assertTrue(user.see_error_attach_file().equalsIgnoreCase(arg1));
	}

	@Then("^I should see the new upload file appears with the corresponding name '(.*?)'$")
	public void i_should_see_the_new_upload_file_appears_with_the_corresponding_name(String filename) throws Exception {
		// Write code here that turns the phrase above into concrete actions
		String uploaded_full_name = user.see_the_uploaded_file_name();
		// get file extension
		String extension = uploaded_full_name.substring(uploaded_full_name.lastIndexOf("."),
				uploaded_full_name.length());
		// get file name
		String uploaded_name = uploaded_full_name.substring(0, uploaded_full_name.lastIndexOf("_"));
		String original_name = uploaded_name + extension;
		Assert.assertTrue(original_name.equals(filename));
	}

	@When("^I click on x icon to remove uploaded file$")
	public void i_click_on_x_icon_to_remove_uploaded_file() throws Exception {
		user.click_close_icon_to_remove_file();
	}

	@When("^I press Confirm delete button$")
	public void i_press_Confirm_delete_button() throws Exception {
		user.confirm_remove_file();
	}

	@Then("^I should see the uploaded file disappears '(.*?)'$")
	public void i_should_see_the_uploaded_file_disappears(String file_name) throws Exception {
		Assert.assertFalse(user.see_file_is_appeared(file_name));
	}

	@When("^I press '(.*?)' on the editor$")
	public void i_press_character_on_the_editor(String charactor) throws Exception {
		user.enter_body(charactor);
		Thread.sleep(1500);
	}

	@Then("^I should see Merge tag '(.*?)' appears$")
	public void i_should_see_Merge_tag_appears(String mergeTag) throws Exception {
		String fact = user.see_merge_tag_name();
		Assert.assertTrue(fact.equals(mergeTag));
	}

	@When("^I am choosing a tag from tag list '(.*?)' '(.*?)'$")
	public void i_am_choosing_a_tag_from_tag_list(String charactor, String tag) throws Exception {
		i_press_character_on_the_editor(charactor);
		user.choose_a_merge_tag();
	}

	@Then("^I should see selected merge tag is marked as block '(.*?)'$")
	public void i_should_see_selected_merge_tag_is_marked_as_block(String tag) throws Exception {
		Assert.assertTrue(user.see_selected_merge_tag_name().equals(tag));

	}

	@Given("^I am on the Send news page$")
	public void i_am_on_the_Send_news_page() throws Exception {
		i_am_on_the_create_news_page();
		i_fill_all_required_inforation_and_press_next_button();
	}

	@When("^I press on send now button$")
	public void i_press_on_send_now_button() throws Exception {
		user.click_send_now_button();
	}

	@When("^I choose date '(.*?)' and time '(.*?)'$")
	public void i_choose_date_and_time(String date, String time) throws Exception {
		user.enter_date(date);
		user.enter_time(time);
		user.click_send_later_button();
	}

	@Then("^I should see a successful message \"([^\"]*)\"$")
	public void i_should_see_a_successful_message(String mess) throws Exception {
		Assert.assertTrue(user.see_pop_up_message_on_send_news_page().equals(mess));
	}

	@When("^To test '(.*?)' I am choose '(.*?)' and '(.*?)'$")
	public void to_test_date_I_am_choose_and(String field, String date, String time) throws Exception {
		i_choose_date_and_time(date, time);
	}

	@Then("^I should see an error message \"([^\"]*)\" under '(.*?)' field$")
	public void i_should_see_an_error_message_under_field(String mess, String field) throws Exception {
		if (field.equalsIgnoreCase("group"))
			Assert.assertTrue(user.see_error_under_group().equalsIgnoreCase(mess));
		if (field.equalsIgnoreCase("name"))
			Assert.assertTrue(user.see_error_under_name().equalsIgnoreCase(mess));
		if (field.equalsIgnoreCase("subject"))
			Assert.assertTrue(user.see_error_under_subject().equalsIgnoreCase(mess));
		if (field.equalsIgnoreCase("body"))
			Assert.assertTrue(user.see_error_under_body().equalsIgnoreCase(mess));
		if (field.equalsIgnoreCase("date"))
			Assert.assertTrue(user.see_error_under_date().equalsIgnoreCase(mess));
		if (field.equalsIgnoreCase("time"))
			Assert.assertTrue(user.see_error_under_time().equalsIgnoreCase(mess));
	}



}
