package vt.endCourse.steps.serenity;

import vt.endCourse.pages.ExtraForm;
import vt.endCourse.pages.LandingPage;
import net.thucydides.core.annotations.Step;

public class Subscriber {
	LandingPage landingPage;
	ExtraForm extraForm;

	@Step
	public void on_the_home_page() {
		landingPage.open();
	}

	@Step
	public void enter_email(String val) {
		landingPage.enter_subcriber_email(val);
		landingPage.click_subscriber_button();
	}

	@Step
	public String see_the_onpage_error() {
		return landingPage.get_error_content_on_form();
	}

	@Step
	public String see_the_popup_message() {
		return landingPage.get_error_content_on_popup_message();
	}

	@Step
	public void fill_full_extra_form(String fullname, String gender, String newstype) {
		extraForm.enter_fullname(fullname);
		if (!gender.equals("") & gender != null)
			extraForm.choose_gender(gender);
		if (newstype != null & !newstype.equals(""))
			extraForm.chooes_news_type(newstype);
		extraForm.click_agree_button();
	}

	@Step
	public String see_the_fullname_label_with_asterisk() {
		return extraForm.getAsteriskInFullnameLabel();
	}

	@Step
	public String see_the_gender_label_with_asterisk() {
		return extraForm.getAsteriskInGenderLabel();
	}

	@Step
	public String see_the_newstype_label_with_asterisk() {
		return extraForm.getAsteriskInNewsTypeLabel();
	}

	@Step
	public String see_current_gender() {
		return extraForm.getSelectingGender();
	}
	@Step
	public String see_current_newstype() {
		return extraForm.getSelectingNewstype();
	}
	@Step
	public String see_error_under_fullname() {
		return extraForm.getErrorMessageUnderFullnameField();
	}
	@Step
	public String see_error_under_gender() {
		return extraForm.getErrorMessageUnderGenderField();
	}
	
	@Step
	public void close_popup_message() {
		landingPage.click_allow_button();
	}
}
