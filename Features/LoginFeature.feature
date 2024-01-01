#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login

  @Sanity
Scenario: Sucessful Login with Valid credentials
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopcommerce administration"
    When User click on Logout link
    Then Page Title should be "your store. Login"
    And Close Browser
    

 @regression 
 Scenario Outline: Sucessful Login with Valid credentials DDT
   Given User Launch Chrome Browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopcommerce administration"
    When User click on Logout link
    Then Page Title should be "your store. Login"
    And Close Browser
    

    Examples: 
      |email|password|
     |admin@yourstore.com|admin|
    |test@yourstore.com|admin|
