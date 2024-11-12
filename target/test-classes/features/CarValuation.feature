#Author: pankajmaathur@gmail.com
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

@functional_test_01
Feature: Car Valuation Test Suite
  Validate car valuations against expected results.
  
  Scenario Outline: Validate car valuation for input registrations
    Given the input file "<inputFile>" and output file "<outputFile>"
    When I extract registration numbers from the input file
    And I fetch car valuation from the website for each registration
    Then I compare the valuations with the expected output
    
  Examples:
   |inputFile|outputFile|
   |src/test/resources/car_input.txt|src/test/resources/car_output.txt|