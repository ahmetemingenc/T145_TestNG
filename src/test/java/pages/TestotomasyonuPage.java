package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestotomasyonuPage {

    public TestotomasyonuPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "global-search")
    public WebElement searchBox;

    @FindBy(className = "prod-img")
    public List<WebElement> productsFoundElementsList;

    @FindBy(xpath = "//*[@class = ' heading-sm mb-4']")
    public WebElement firstProductName;

    @FindBy(xpath = "(//*[@class='menu-icon-text'])[1]")
    public WebElement accountLink;

    @FindBy(id = "email")
    public WebElement emailBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "submitlogin")
    public WebElement signInButton;

    @FindBy(xpath = "//span[text()='Logout']")
    public WebElement logoutButton;

    @FindBy(className = "product-count-text")
    public WebElement resultWebElement;
}
