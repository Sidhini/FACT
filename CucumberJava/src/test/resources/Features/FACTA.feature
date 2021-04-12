Feature: FACT simulator testing

  @browserTest
  Scenario: Validate FACT simulator flow
    Given Browser is open
    And at QA FACT simulator homepage
    When user enters the PII data in simluator page
    And clicks on the submit button in simulator page
    And clicks on the POST TO FACT button in knapsack page
    And enters last four digits of SSN
    And clicks CONTINUE button    
    And select KBA answers
    And clicks KBA CONTINUE button
    And Result popup
    And clicks DOWNLOAD REPORT button
    And clicks on all sections
    Then user gets a page
