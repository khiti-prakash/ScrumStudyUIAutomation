Feature: Scrumstudy Website Validation

  Background:
    Given I open the Scrumstudy website

  Scenario: Verify Scrumstudy home page loads correctly

    Then I should see the "Global Accreditation Body for Scrum and Agile Certifications" text
    And  Verify the Title "Transform Your Career with SCRUMstudy Certifications" text

  Scenario: Verify all menus are present and navigation works

    Then I should see 8 menus present with names "Why Scrum?", "Certification", "Classes", "Partners", "SBOK® Guide", "Free Resources", "Popular Scrum Tools", "About Us"
    When I navigate to each menu one by one
    Then I should verify the page loads correctly for each menu

  Scenario: Verify Language and country

    Then Verify Bydefault "English" should show in language dropdown
    Then Verify Bydefault "India" should show in country dropdown
    When i click on language dropdwon
    Then I should see 6 language are present in dropdown
    And Language "English", "French", "German", "Italian", "Portuguese", "Spanish"


  Scenario: Verify header button verification

    Then I should see "Home", "Contact", "Register", "Login"
