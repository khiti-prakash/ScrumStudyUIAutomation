package pages;

import io.qameta.allure.Allure;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScrumstudyHomePage {
    private static final Logger log = LogManager.getLogger(ScrumstudyHomePage.class);
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

    // Menu list (top navigation bar)
    @FindBy(xpath = "//div[@class='container clearfix']//ul[@class='sf-menu clearfix']//li//a[@class='sf-with-ul']")
    private List<WebElement> menuItems;

    @FindBy(name = "languageid")
    private WebElement languageDropdown;

    @FindBy(id = "countryid")
    private WebElement countryDropdown;

    @FindBy(xpath = "//ul[@class='list-inline']//li//a")
    private List<WebElement> headerButtons;

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

    // ✅ Get all menu names as text
    public List<String> getMenuNames() {
        List<String> menus = menuItems.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());

        System.out.println("Menus found: " + menus);
        log.info("Menus found: " + menus);

        return menus;
    }

    // ✅ Click on a menu by visible text
    public void clickMenu(String menuName) {
        for (WebElement menu : menuItems) {
            String menuText = menu.getText().trim();
            if (menuText.equalsIgnoreCase(menuName)) {
                menu.click();
                log.info("Page Title is: " + menuText);
                return;
            }
        }
        throw new RuntimeException("Menu not found: " + menuName);
    }

    // ✅ Get current URL (to validate navigation)
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    // Method to get default language
    public String getDefaultLanguage() {
        Select select = new Select(languageDropdown);
        String selected = select.getFirstSelectedOption().getText().trim();
        log.info("Default language shown: " + selected);
        return selected;
    }

    // Method to get default country
    public String getDefaultCountry() {
        Select select = new Select(countryDropdown);
        String selected = select.getFirstSelectedOption().getText().trim();
        log.info("Default country shown: " + selected);
        return selected;
    }

    public void clickOnLanguageDropdown() {
        languageDropdown.click();
        log.info("clink on language dropdown ");

    }
    public int verifyLanguageDropdown() {
        Select select = new Select(languageDropdown);
        List<WebElement> options = select.getOptions();

        log.info("Language dropdown Size: " + options.size());

        return options.size();

    }
    public List<String> getLanguageDropdownItems() {
        Logger log = LogManager.getLogger(this.getClass());  // logger for this class

        Select select = new Select(languageDropdown);
        List<String> dropdownItems = select.getOptions()
                .stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        log.info("Language dropdown items fetched: " + dropdownItems);


        return dropdownItems;
    }

    public List<String> getHeaderButtonNames() {
        List<String> headerButtonsItems = headerButtons.stream()
                .map(WebElement::getText)
                .map(String::trim)
                .collect(Collectors.toList());

        log.info("Language dropdown items fetched: " + headerButtonsItems);

        return headerButtonsItems;
    }
}
