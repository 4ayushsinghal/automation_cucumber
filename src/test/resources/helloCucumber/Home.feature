#User requirement:

Feature: Regression suite to ensure Website works as anticipated


  @Before
  @DoAfterScenario
  Scenario: Click functionality works on Fedex language selection Page with India
    Given I select English from India
    And I close the popup if exists
    Then I verify that the home page is visible
    And I verify that the logo is present on Page

  @Before
  @DoAfterScenario
  Scenario: Click functionality works on Fedex language selection Page with UK
    Given I select English from UK
    And I close the popup if exists
    Then I verify that the home page is visible
    And I verify that the logo is present on Page

  @Before
  @DoAfterScenario
  Scenario: Login functionality works with valid credentials
    Given I select English from UK
    And I close the popup if exists
    When I click on login icon from dropdown
    And I enter the valid login credentials
    And I click the login button
    Then I verify the login is successful

  @Before
  @DoAfterScenario
  Scenario: Login functionality works with invalid credentials
    Given I select English from UK
    And I close the popup if exists
    When I click on login icon from dropdown
    And I enter the invalid login credentials
    And I click the login button
    Then I verify the error message is shown

  @Before
  @DoAfterScenario
  Scenario: Valid Tracking id lands on a Tracking Details Page
    Given I select English from UK
    And I close the popup if exists
    When I enter any valid tracking id
    And I click on Track button
    Then I verify that the tracking details are displayed

  @Before
  @DoAfterScenario
  Scenario: Invalid Tracking id lands on a error page
    Given I select English from UK
    And I close the popup if exists
    When I enter any invalid tracking id
    And I click on Track button
    Then I verify that the error page with no records is displayed

  @Before
  @DoAfterScenario
  Scenario: Reset Password is clickable
    Given I select English from UK
    And I close the popup if exists
    When I click on login icon from dropdown
    And I click on Forgot Your userid or password
    And I land on the forgot password page
    And I click on Reset Password button
    Then I land on the Reset Password Page

  @Before
  @DoAfterScenario
  Scenario: Retrieve User ID is clickable
    Given I select English from UK
    And I close the popup if exists
    When I click on login icon from dropdown
    And I click on Forgot Your userid or password
    And I land on the forgot password page
    And I click on Retrieve User ID button
    Then I land on Retrieve User ID Page

  @Before
  @DoAfterScenario
  Scenario: Navigation toolbar shows all the website features
    Given I select English from UK
    And I close the popup if exists
    When I navigate through the toolbar
    Then I verify all the options are available

  @DoAfterScenario
  @Before
  Scenario: Search functionality works
    Given I select English from UK
    And I close the popup if exists
    When I click on Search button
    And Click on search input field
    And I enter any invalid tracking id in search
    And I press enter
    Then I verify that the error page with no records is displayed
