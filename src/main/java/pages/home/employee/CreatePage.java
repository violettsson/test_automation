package pages.home.employee;

import com.paulhammant.ngwebdriver.ByAngularCssContainingText;
import core.model.Employee;
import core.testing.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.home.HomePage;

public class CreatePage extends Page {

    public CreatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     Elements
     */
    @FindBy(xpath = "//input[@type='text']")
    public WebElement inputFirstName;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement inputLastName;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement inputStartDate;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement inputEmail;

    @ByAngularCssContainingText.FindBy(cssSelector = ".main-button:nth-child(2)", searchText = "Add")
    public WebElement buttonAdd;

    @ByAngularCssContainingText.FindBy(cssSelector = ".bCancel", searchText = "Cancel")
    public WebElement buttonCancel;


    /**
     Actions
     */
    public CreatePage inputNewDetails(Employee employee) {

        inputFirstName.sendKeys(employee.firstName);
        inputLastName.sendKeys(employee.lastName);
        inputStartDate.sendKeys(employee.startDate);
        inputEmail.sendKeys(employee.email);
        return this;
    }

    public HomePage addEmployee(Employee employee) {
        inputNewDetails(employee);
        buttonAdd.click();
        return new HomePage(driver);
    }

    public HomePage cancelCreation() {
        buttonCancel.click();
        return new HomePage(driver);
    }

}
