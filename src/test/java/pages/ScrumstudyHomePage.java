package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrumstudyHomePage {
    private WebDriver driver;

    // Constructor
    public ScrumstudyHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Example element
    @FindBy(xpath = "//div[@id='header-tagline']//div")
    private WebElement headerTagline;

    @FindBy(linkText = "Community")
    private WebElement communityTab;

    @FindBy(linkText = "Certification")
    private WebElement certificationTab;

    // Actions
    public String getHeaderTagline() {
        return headerTagline.getText();
    }

    public String getTitle() {
        return driver.getTitle();
    }
    public String getCommunityTab() {
        return communityTab.getText();
    }

    public void clickCommunityTab() {
        communityTab.click();
    }

    public void clickCertificationTab() {
        certificationTab.click();
    }
}
