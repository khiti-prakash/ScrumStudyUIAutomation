package pages;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;

    private ScrumstudyHomePage scrumstudyHomePage;
//    private LoginPage loginPage;
//    private CertificationPage certificationPage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public ScrumstudyHomePage getScrumstudyHomePage() {
        if (scrumstudyHomePage == null) {
            scrumstudyHomePage = new ScrumstudyHomePage(driver);
        }
        return scrumstudyHomePage;
    }

//    public LoginPage getLoginPage() {
//        if (loginPage == null) {
//            loginPage = new LoginPage(driver);
//        }
//        return loginPage;
//    }
//
//    public CertificationPage getCertificationPage() {
//        if (certificationPage == null) {
//            certificationPage = new CertificationPage(driver);
//        }
//        return certificationPage;
//    }
}
