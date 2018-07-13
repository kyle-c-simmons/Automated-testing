$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/assessment.feature");
formatter.feature({
  "line": 1,
  "name": "Using OrangeHRM",
  "description": "As an administrator\r\nI want to manage the database\r\nSo that the details it holds are up-to-date and relevant",
  "id": "using-orangehrm",
  "keyword": "Feature"
});
formatter.before({
  "duration": 2782461057,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Add an employee to the CRM",
  "description": "",
  "id": "using-orangehrm;add-an-employee-to-the-crm",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 8,
  "name": "the login page",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "I login",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I click the PIM tab",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "then the Add Employee Tab",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "I fill out the Employee Details correctly",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "I choose to create Login Details by clicking the appropriate button",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "I fill out the Login Details correctly",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "I click the Save button",
  "keyword": "And "
});
formatter.step({
  "line": 16,
  "name": "I can search for the Employee I have just created",
  "keyword": "Then "
});
formatter.step({
  "line": 17,
  "name": "select them for inspection",
  "keyword": "And "
});
formatter.match({
  "location": "StackSteps.the_login_page()"
});
formatter.result({
  "duration": 2924451806,
  "status": "passed"
});
formatter.match({
  "location": "StackSteps.i_login()"
});
formatter.result({
  "duration": 3562219037,
  "status": "passed"
});
formatter.match({
  "location": "StackSteps.i_click_the_PIM_tab()"
});
formatter.result({
  "duration": 119067532,
  "status": "passed"
});
formatter.match({
  "location": "StackSteps.then_the_Add_Employee_Tab()"
});
formatter.result({
  "duration": 683650879,
  "status": "passed"
});
formatter.match({
  "location": "StackSteps.i_fill_out_the_Employee_Details_correctly()"
});
formatter.result({
  "duration": 14864615845,
  "status": "passed"
});
formatter.match({
  "location": "StackSteps.i_choose_to_create_Login_Details_by_clicking_the_appropriate_button()"
});
formatter.result({
  "duration": 176234100,
  "status": "passed"
});
formatter.match({
  "location": "StackSteps.i_fill_out_the_Login_Details_correctly()"
});
formatter.result({
  "duration": 709069935,
  "status": "passed"
});
formatter.match({
  "location": "StackSteps.i_click_the_Save_button()"
});
formatter.result({
  "duration": 13118890770,
  "status": "passed"
});
formatter.match({
  "location": "StackSteps.i_can_search_for_the_Employee_I_have_just_created()"
});
formatter.result({
  "duration": 2967455936,
  "status": "passed"
});
formatter.match({
  "location": "StackSteps.select_them_for_inspection()"
});
formatter.result({
  "duration": 537322889,
  "status": "passed"
});
formatter.after({
  "duration": 913012332,
  "status": "passed"
});
});