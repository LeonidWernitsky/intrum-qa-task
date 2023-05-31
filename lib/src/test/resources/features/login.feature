@login
Feature: Login


  @smoke
  Scenario: Submit with wrong values
    Given I open Initial Page
    When I click on acceptCookies
    And I click on formButton
    And I fill the nameFamilyName with "a$!"
    And I fill the personalCode with "_#?"
    And I fill the debtCaseNumber with "!#{"
    And I fill the phoneNumber with "ABC"
    And I fill the emailAddress with "123abc@abc"
    And I fill the postAddress with "&&?"
    And I fill the comment with "$};"
    And I click on submitButton
    Then I see "Lūdzu, aizpildiet lauku" text

  Scenario: Submit with empty fields
    Given I open Initial Page
    When I click on acceptCookies
    And I click on formButton
    And I click on submitButton
    Then I see "Lūdzu, aizpildiet lauku" notification

  Scenario: Submit with valid values except one field
    Given I open Initial Page
    When I click on acceptCookies
    And I click on formButton
    And I fill the nameFamilyName with "Michael Luger"
    And I fill the personalCode with "301185-13291"
    And I fill the debtCaseNumber with "ABC-Test Skip this Form"
    And I fill the phoneNumber with "+1 (415) 555‑0132"
    And I fill the emailAddress with "mail.address@domain.name"
    And I fill the postAddress with "Gustava Zemgala gatve 74a, Rīga, LV-1039"
    And I fill the comment with "Test? Comment!"
    And I click on communicationOptionBlank
    And I click on submitButton
    Then I see "Lūdzu, aizpildiet lauku" text

  Scenario: Submit with valid values except another field
    Given I open Initial Page
    When I click on acceptCookies
    And I click on formButton
    And I fill the nameFamilyName with "Michael Luger"
    And I fill the personalCode with "301185-13291"
    And I fill the debtCaseNumber with "ABC-Test Skip this Form"
    And I fill the phoneNumber with "+1 (415) 555‑0132"
    And I fill the emailAddress with "mail.address@domain.name"
    And I fill the comment with "Test? Comment!"
    And I click on communicationOptionPost
    And I click on submitButton
    Then I see "Lūdzu, aizpildiet lauku" message
