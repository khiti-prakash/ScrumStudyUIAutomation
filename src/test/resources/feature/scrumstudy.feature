Feature: Scrumstudy Website Validation

  Background:
    Given I open the Scrumstudy website

  Scenario: Verify Scrumstudy home page loads correctly

    Then I should see the "Global Accreditation Body for Scrum and Agile Certifications" text
    And  Verify the Title "Transform Your Career with SCRUMstudy Certifications" text

  Scenario: Verify all menus are present and navigation works

    Then I should see 8 menus present with names "Why Scrum?", "Certification", "Class", "Partners", "SBOK Guide", "Free Resources", "Popular Scrum Tools", "About Us"
    When I navigate to each menu one by one
    Then I should verify the page loads correctly for each menu

  Scenario: Verify SBOK Guide download option

    When I click on "Download Free SBOK Guide"
    Then the SBOK Guide page should open

  Scenario: Verify Get Scrum Master Certified button

    When I click on "Get Scrum Master Certified"
    Then I should see the Scrum Master Certification page
