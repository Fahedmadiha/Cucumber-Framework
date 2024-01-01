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
Feature: Customers
Background: Steps common for all scenarios
Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and password as "admin"
    And Click on Login
    Then User can view Dashboard

  @Sanity
  Scenario: Add New Customer
     
    When User clicks on Customers menu
    And Click on customers menu item
    And Click on Add new button
    Then User can view Add new customer page
    When User enter customer info
    And Click on save button
    Then User can view confirmation message "The new customer has been added successfully."
    And Close Browser    
    
    @Sanity
    Scenario: Search customer by Email
 
    When User clicks on Customers menu
    And Click on customers menu item
    And Enter customer Email
    When Click on Search button
    Then User should find Email in the Search table
    And Close Browser
    

  #@tag2
  #Scenario Outline: Title of your scenario outline
   # Given I want to write a step with <name>
   # When I check for the <value> in step
   # Then I verify the <status> in step

    #Examples: 
    #  | name  | value | status  |
    #  | name1 |     5 | success |
    #  | name2 |     7 | Fail    |
