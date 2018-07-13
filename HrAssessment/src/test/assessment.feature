Feature: Using OrangeHRM
  As an administrator
  I want to manage the database
  So that the details it holds are up-to-date and relevant
 
Scenario: Add an employee to the CRM

  Given the login page
  When I login
  And I click the PIM tab
  And then the Add Employee Tab
  And I fill out the Employee Details correctly
  And I choose to create Login Details by clicking the appropriate button
  And I fill out the Login Details correctly
  And I click the Save button
  Then I can search for the Employee I have just created    
  And select them for inspection







  




