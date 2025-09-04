package stepdefinitions;

import config.ConfigReader;
import driver.DriverManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PageObjectManager;
import pages.ScrumstudyHomePage;


import java.util.Arrays;
import java.util.List;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ScrumstudySteps {
    private WebDriver driver;
    private ScrumstudyHomePage homePage;
    private PageObjectManager pageObjectManager;

    public ScrumstudySteps() {
        // Always reuse driver from DriverManager
        this.driver = DriverManager.getDriver();
        this.pageObjectManager = new PageObjectManager(driver);
        this.homePage = pageObjectManager.getScrumstudyHomePage(); // ✅ Reuse common page object
    }

    @Given("I open the Scrumstudy website")
    public void i_open_the_scrumstudy_website() {
        String baseUrl = ConfigReader.getProperty("base.url");
        // Validate URL
        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            throw new RuntimeException("❌ base.url is not set in config.properties");
        }
        // Launch application
        driver.get(baseUrl);
        //driver.manage().window().maximize();
    }

    @Then("I should see the {string} text")
    public void i_should_see_the_text(String expectedText) {
        String bodyText= homePage.getHeaderTagline();
        assertThat(bodyText).contains(expectedText);
    }
    @And("Verify the Title {string} text")
    public void verifyTheTitleText(String arg0) {
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);

        // Example validation
        assertThat(actualTitle).isEqualTo("Transform Your Career with SCRUMstudy Certifications");
    }

    @When("I click on {string} tab")
    public void i_click_on_tab(String tabName) {
        if (tabName.equalsIgnoreCase("Community")) {
            homePage.clickCommunityTab();
        } else if (tabName.equalsIgnoreCase("Certification")) {
            homePage.clickCertificationTab();
        }
    }

    @Then("I should see the Certification page")
    public void i_should_see_the_certification_page() {
        assertThat(driver.getTitle()).contains("Certification");
    }

    @When("I click on {string}")
    public void i_click_on(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    @Then("the SBOK Guide page should open")
    public void the_sbok_guide_page_should_open() {
        assertThat(driver.getCurrentUrl()).contains("sbokguide");
    }

    @Then("I should see the Scrum Master Certification page")
    public void i_should_see_the_scrum_master_certification_page() {
        assertThat(driver.getTitle()).contains("Scrum Master");
    }


    @Then("I should see {int} menus present with names {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void iShouldSeeMenusPresentWithNames(int expectedCount, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) {
        // Write code here that turns the phrase above into concrete actions
        List<String> expectedMenus = Arrays.asList(arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8);
        List<String> actualMenus = homePage.getMenuNames();

        // Count check
        Assert.assertEquals(actualMenus.size(), expectedCount, "Menu count mismatch!");

        // Value check (order-sensitive)
        Assert.assertEquals(actualMenus, expectedMenus, "Menu names do not match!");
    }

    @When("I navigate to each menu one by one")
    public void iNavigateToEachMenuOneByOne() {
        // Write code here that turns the phrase above into concrete actions
        List<String> menus = homePage.getMenuNames();
        for (String menu : menus) {
            homePage.clickMenu(menu);

            // Wait for page load
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {

            }
        }
    }

    @Then("I should verify the page loads correctly for each menu")
    public void iShouldVerifyThePageLoadsCorrectlyForEachMenu() {
        // Write code here that turns the phrase above into concrete actions
        List<String> menus = homePage.getMenuNames();
        for (String menu : menus) {
            homePage.clickMenu(menu);

            assertThat(homePage.getTitle()).isNotEmpty(); // Just ensure page loads
        }
    }

    @Then("Verify Bydefault {string} should show in language dropdown")
    public void verifyBydefaultShouldShowInLanguageDropdown(String expectedLanguage) {
        // Write code here that turns the phrase above into concrete actions
        String actualLanguage= homePage.getDefaultLanguage();

        assertThat(actualLanguage).isEqualTo(expectedLanguage);

    }

    @Then("Verify Bydefault {string} should show in country dropdown")
    public void verifyBydefaultShouldShowInCountryDropdown(String expectedCountry) {
        // Write code here that turns the phrase above into concrete actions
        String actualCountry= homePage.getDefaultCountry();

        assertThat(actualCountry).isEqualTo(expectedCountry);

    }

    @When("i click on language dropdwon")
    public void iClickOnLanguageDropdwon() {
        // Write code here that turns the phrase above into concrete actions
        homePage.clickOnLanguageDropdown();

    }

    @Then("I should see {int} language are present in dropdown")
    public void iShouldSeeLanguageArePresentInDropdown(int expectedDropdownValue) {
        // Write code here that turns the phrase above into concrete actions
        int actualDropdownValue = homePage.verifyLanguageDropdown();

        assertThat(actualDropdownValue).isEqualTo(expectedDropdownValue);

    }

    @And("Language {string}, {string}, {string}, {string}, {string}, {string}")
    public void language(String lang1, String lang2, String lang3, String lang4, String lang5, String lang6) {
        List<String> expectedLanguages = Arrays.asList(lang1, lang2, lang3, lang4, lang5, lang6);

        List<String> actualLanguages = homePage.getLanguageDropdownItems();

        assertThat(actualLanguages).isEqualTo(expectedLanguages);

    }

    @Then("I should see {string}, {string}, {string}, {string}")
    public void iShouldSee(String arg0, String arg1, String arg2, String arg3) {
        // Write code here that turns the phrase above into concrete actions
        List<String> expectedHeaderButtonNames = Arrays.asList(arg0, arg1, arg2, arg3);
        List<String> actualHeaderButtonNames = homePage.getHeaderButtonNames();

        assertThat(actualHeaderButtonNames).isEqualTo(expectedHeaderButtonNames);
    }
}
