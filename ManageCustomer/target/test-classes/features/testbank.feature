Feature:  Manage Customer feature

  Scenario: add a customer with valiad data 
  Given open browsers 
  And verify the management page
  When user click on Add Customer button
  And user enter <firstName> and <lastName> and <postcode> 
  And click on Add Customer button
  And click on OK button of the alert box
  And verify data
  Then display the message
  
  Scenario: add a customer with invaliad data 
  Given open browsers 
  And verify the management page
  When user click on Add Customer button
  And user enter <lastName> and <postcode>
  And click on Add Customer button
  Then display the message
  
  Scenario: open an account is successful
  Given open browsers 
  And verify the management page
  When click on Open Account button
  And user select <account> and <currency>
  And click on the Process button
  And click on OK button of the alert box
  Then display the message
  
  Scenario: open an account is not successful
  Given open browsers 
  And verify the management page
  When click on Open Account button
  And user select <account>
  And click on the Process button
  Then display the message
  
  Scenario: search account is successful
    Given open browsers 
    And verify the management page
    When click on Customers button
    And search customer is exist
    And verify search customer
    Then display the message

  Scenario: search account is not exist
    Given open browsers
    And verify the management page
    When click on Customers button
    And search customer is not exist
    And verify search customer
    Then display the message
