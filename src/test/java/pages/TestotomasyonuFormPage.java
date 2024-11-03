package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TestotomasyonuFormPage {

    public TestotomasyonuFormPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//select[@class='form-control'])[1]")
    public WebElement gunDropdown;

    @FindBy(xpath = "(//select[@class='form-control'])[2]")
    public WebElement ayDropdown;

    @FindBy(xpath = "(//select[@class='form-control'])[3]")
    public WebElement yilDropdown;

}
