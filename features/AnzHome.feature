Feature: Ebay Home Page Scenarios

  Scenario: TC001_User_Adds_Working_details
    Given I am on the ANZ Home Page
    When I click on application type single button
    When I select no of dependants
    When I click on property type Home to live in
    When I enter 80000 income before tax
    When I enter 10000 income after tax
    Then I enter my expanses as
      | living expenses | current repayments | other replayements | other commitments | Total Credit card limits |
      |             500 |                  0 |                100 |                 0 |                   10000 |
	When I click on the borrow button
	Then  I validate that page values of '$508,000' is displayed
	
	Scenario:	TC002_User_clicks_start_over_button
	  Given I am on the ANZ Home Page
    When I click on application type single button
    When I select no of dependants
    When I click on property type Home to live in
    When I enter '80000' income before tax
    When I enter '10000' income after tax
    Then I enter my expanses as
      | living expenses | current repayments | other replayements | other commitments | Total Credit card limits |
      |             500 |                  0 |                100 |                 0 |                   10000 |
	When I click on the borrow button
	Then  I validate that page values of '$508,000' is displayed
	When I click on start over button 
	Then I check that the form is reset
	
	Scenario:	TC003_User_Is_Displayed_Help_Message
	  Given I am on the ANZ Home Page
    When I click on application type single button
    When I select no of dependants
    When I click on property type Home to live in
    When I enter '0' income before tax
    When I enter '0' income after tax
    Then I enter my expanses as
      | living expenses | current repayments | other replayements | other commitments | Total Credit card limits |
      |             1 |                  0 |                0 |                 0 |                   0 |
	When I click on the borrow button
	Then I validate that page message is displayed
	
	