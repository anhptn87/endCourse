Feature: Create news, attachment, merge tag

  @CreateNews
  Scenario Outline: Check mandatory field
    Given I am on the create news page
    When To test '<field>' I fill '<group>' '<name>' '<subject>' '<body>' and press Next button
    Then I should see an error message "This is required field" under '<field>' field

    Examples: 
      | field   | group                        | name     | subject     | body     |
      | group   |                              | the name | the subject | the body |
      | name    | Lịch khai giảng các khóa học |          | the subject | the body |
      | subject | Lịch khai giảng các khóa học | the name |             | the body |
      | body    | Lịch khai giảng các khóa học | the name | the subject |          |

  @CreateNews
  Scenario: Check the defaut value of Group field
    Given I am on the create news page
    When I do nothing
    Then I should see defaul value of Group field is "Không xác định"

  @CreateNews
  Scenario Outline: The Name information has Max 100 characters, Printable character and no line breaks
    Given I am on the create news page
    When I enter invalid value on the Name filed '<name>'
    Then I should see an error message "The Name information has Max 100 characters, Printable character and no line breaks" under the Name field

    Examples: 
      | name                                                                                                           |
      #more than 100 characters
      | Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum. |
      | @@@Lorem ipsum dolor sit amet                                                                                  |

  @CreateNews
  Scenario: Check The body field: the Body is HTML content, it may be included some media content such as Image, Video
    Given I am on the create news page
    When I do nothing
    Then I should see media button on the body field

  @CreateNews
  Scenario: Create new successfully
    Given I am on the create news page
    When I fill all required inforation and press next button
    Then I should see Send now button

  @CreateNews
  Scenario Outline: wrong attachment type
    Given I am on the create news page
    When I upload a file '<file_name>'
    Then I should see an error appears "Your selected file (s) are invalid"

    Examples: 
      | file_name    |
      | exe_file.exe |
      | jar_file.jar |

  @CreateNews
  Scenario Outline: Correct attachment
    Given I am on the create news page
    When I upload a file '<file_name>'
    Then I should see the new upload file appears with the corresponding name '<file_name>'

    Examples: 
      | file_name              |
      | document_under_2M.docx |
      | document_under_2M.xlsx |

  @CreateNews
  Scenario Outline: Doccument bigger than 2MB
    Given I am on the create news page
    When I upload a file '<file_name>'
    Then I should see an error appears "Your selected file (s) are invalid"

    Examples: 
      | file_name              |
      | document_above_2M.docx |

  @CreateNews
  Scenario Outline: : Remove uploaded file
    Given I am on the create news page
    When I upload a file '<file_name>'
    And I click on x icon to remove uploaded file
    And I press Confirm delete button
    Then I should see the uploaded file disappears '<file_name>'

    Examples: 
      | file_name              |
      | document_under_2M.docx |

  @CreateNews
  Scenario Outline: Merge tag list displayed after the first letter is typed on editor
    Given I am on the create news page
    When I press '<charactor>' on the editor
    Then I should see Merge tag '<tag>' appears

    Examples: 
      | charactor | tag      |
      | F         | FullName |
      | T         | Title    |
      | E         | Email    |

  @CreateNews
  Scenario Outline: The merge tag will be marked as block after merge tag is selected from list
    Given I am on the create news page
    When I am choosing a tag from tag list '<charactor>' '<tag>'
    Then I should see selected merge tag is marked as block '<tag>'

    Examples: 
      | charactor | tag      |
      | F         | FullName |

  @SendNews
  Scenario: The Send now will deliver the Newsletter to corresponding subscribed immediately
    Given I am on the Send news page
    When I press on send now button
    Then I should see a successful message "The News has been sent successfully."

  @SendNews
  Scenario Outline: Send later successfull after fill require the date end time
    Given I am on the Send news page
    When I choose date '<date>' and time '<time>'
    Then I should see a successful message "The News has been sent successfully."

    Examples: 
      | date       | time  |
      | 07/01/2019 | 12:20 |

  @SendNews
  Scenario Outline: time or date field is mandatory when choose Send later function
    Given I am on the Send news page
    When To test '<field>' I am choose '<date>' and '<time>'
    Then I should see an error message "This is required field" under '<field>' field

    Examples: 
      | field | date       | time  |
      | date  |            | 12:20 |
      | time  | 07/01/2019 |       |
