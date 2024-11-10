package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ZeroBankPage {

    public ZeroBankPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "signin_button")
    public WebElement signinButton;

    @FindBy(id = "user_login")
    public WebElement loginBox;

    @FindBy(id = "user_password")
    public WebElement passwordBox;

    @FindBy(name = "submit")
    public WebElement submitButton;

    @FindBy(className = "icon-user")
    public WebElement iconUser;

    @FindBy(id = "onlineBankingMenu")
    public WebElement onlineBankingButton;

    @FindBy(id = "pay_bills_link")
    public WebElement payBillsButton;

    @FindBy(xpath = "(//*[@class='ui-state-default ui-corner-top'])[2]")
    public WebElement purchaseForeignCurrencyButton;

    @FindBy(id = "pc_currency")
    public WebElement dropDownCurrency;




}
