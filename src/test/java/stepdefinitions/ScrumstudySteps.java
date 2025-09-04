package stepdefinitions;

import config.ConfigReader;
import driver.DriverManager;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.ScrumstudyHomePage;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ScrumstudySteps {
    private WebDriver driver;
    private ScrumstudyHomePage homePage;

    public ScrumstudySteps() {
        // Always reuse driver from DriverManager
        this.driver = DriverManager.getDriver();
        this.homePage = new ScrumstudyHomePage(driver); // ✅ Reuse common page object
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
    public void iShouldSeeMenusPresentWithNames(int arg0, String arg1, String arg2, String arg3, String arg4, String arg5, String arg6, String arg7, String arg8) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("I navigate to each menu one by one")
    public void iNavigateToEachMenuOneByOne() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("I should verify the page loads correctly for each menu")
    public void iShouldVerifyThePageLoadsCorrectlyForEachMenu() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
