Feature: subscriber function

  @Subscriber
  Scenario Outline: Enter wrong email
    Given I am on the home page
    When I enter invalid email address '<email>'
    Then I see error message "* Email không đúng định dạng"

    Examples: 
      | email        |
      | anh          |
      | anh@a        |
      |              |
      | anh@qa..team |
      | anh@-qa.team |
    

  @Subscriber 
  Scenario: Enter registered email
    Given I am on the home page
    When I enter a registered email address
    Then I should see an pop up error message "đã được sử dụng, bạn hãy chọn một E-mail khác"

  @Subscriber
  Scenario: Initial extra form
    Given I am on the home page
    When I enter a valid email address and press subscriber
    Then I should see the form initial correctly

  @Subscriber
  Scenario: Empty full name in extra form
    Given I am on the extra form
    When I enter blank into the full name field
    Then I should see error message under the Fullname field "This is required field"

  @Subscriber
  Scenario: Does not chooes gender on the extra form
    Given I am on the extra form
    When I fill valid information to all field except Gender field
    Then I should see an error message under the Gender field "This is required field"

  @Subscriber @passed
  Scenario: Subscriber successfully
    Given I am on the home page
    When I enter a valid email address and press subscriber
    And I fill all required field on the extra form
    Then I should see a successfull pop up message "Bạn đã đăng ký nhận bản tin thành công. Hãy kiểm tra Email để xác nhận việc đăng ký"
    And I should receive a confirmation email
