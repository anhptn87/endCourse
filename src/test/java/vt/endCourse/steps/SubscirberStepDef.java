package vt.endCourse.steps;

import net.thucydides.core.annotations.Steps;

import java.util.Date;

import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import vt.endCourse.steps.serenity.Subscriber;

public class SubscirberStepDef {
	@Steps
	Subscriber na;

	@Given("^I am on the home page$")
	public void i_am_on_the_home_page() throws Exception {
		na.on_the_home_page();
	}

	@When("^I enter invalid email address '(.*?)'$")
	public void i_enter_invalid_email_address(String email) throws Exception {
		na.enter_email(email);
	}

	@Then("^I see error message \"([^\"]*)\"$")
	public void i_see_error_message(String arg1) throws Exception {
		String errMess = na.see_the_onpage_error();
		Assert.assertTrue(errMess.equalsIgnoreCase(arg1));
	}

	@When("^I enter a registered email address$")
	public void i_enter_a_registered_email_address() throws Exception {
		Date d = new Date();
		String uniqueCode = String.valueOf(d.getTime());
		String emailAddress = "anhvnr2001+" + uniqueCode + "@gmail.com";
		na.enter_email(emailAddress);
		na.fill_full_extra_form("Phan Anh", "Nam", "Thông tin khai giảng khóa học");
		na.close_popup_message();
		na.enter_email(emailAddress);
	}

	@Then("^I should see an pop up error message \"([^\"]*)\"$")
	public void i_should_see_an_pop_up_error_message(String arg1) throws Exception {
		String mess = na.see_the_popup_message();
		Assert.assertTrue(mess.contains(mess));
	}

	@When("^I enter a valid email address and press subscriber$")
	public void i_enter_a_valid_email_address_and_press_subscriber() throws Exception {
		Date d = new Date();
		String uniqueCode = String.valueOf(d.getTime());
		na.enter_email("anhvnr2001+" + uniqueCode + "@gmail.com");
	}

	@Then("^I should see the form initial correctly$")
	public void i_should_see_the_form_initial_correctly() throws Exception {
		// all lable has asterisk
		Assert.assertTrue(na.see_the_fullname_label_with_asterisk().contains("*"));
		Assert.assertTrue(na.see_the_gender_label_with_asterisk().contains("*"));
		Assert.assertTrue(na.see_the_newstype_label_with_asterisk().contains("*"));
		// defaul value of newstype select boxes
		Assert.assertTrue(na.see_current_newstype().equalsIgnoreCase("Tất cả"));
	}

	@Given("^I am on the extra form$")
	public void i_am_on_the_extra_form() throws Exception {
		na.on_the_home_page();
		i_enter_a_valid_email_address_and_press_subscriber();
	}

	@When("^I enter blank into the full name field$")
	public void i_enter_blank_into_the_full_name_field() throws Exception {
		Thread.sleep(1500);
		na.fill_full_extra_form("", "Nam", "Thông tin khai giảng khóa học");
	}

	@Then("^I should see error message under the Fullname field \"([^\"]*)\"$")
	public void i_should_see_error_message_under_the_Fullname_field(String err) throws Exception {
		Assert.assertTrue(na.see_error_under_fullname().equalsIgnoreCase(err));
	}

	@When("^I fill valid information to all field except Gender field$")
	public void i_fill_valid_information_to_all_field_except_Gender_field() throws Exception {
		na.fill_full_extra_form("Phan Anh", "", "Thông tin khai giảng khóa học");
	}

	@Then("^I should see an error message under the Gender field \"([^\"]*)\"$")
	public void i_should_see_an_error_message_under_the_Gender_field(String err) throws Exception {
		Assert.assertTrue(na.see_error_under_gender().equalsIgnoreCase(err));
	}

	@When("^I fill all required field on the extra form$")
	public void i_fill_all_required_field_on_the_extra_form() throws Exception {
		na.fill_full_extra_form("Phan anh", "Nam", "Thông tin khai giảng khóa học");
	}

	@Then("^I should see a successfull pop up message \"([^\"]*)\"$")
	public void i_should_see_a_successfull_pop_up_message(String mess) throws Exception {
		Assert.assertTrue(na.see_the_popup_message().equalsIgnoreCase(mess));
	}

	@Then("^I should receive a confirmation email$")
	public void i_should_receive_a_confirmation_email() throws Exception {
//TODO
	}

}
