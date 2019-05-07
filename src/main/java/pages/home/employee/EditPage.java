package pages.home.employee;

import com.paulhammant.ngwebdriver.ByAngularCssContainingText;
import core.model.Employee;
import core.testing.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.home.HomePage;

public class EditPage extends Page {

    public EditPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     Elements
     */
    @FindBy(xpath = "/html/body/div/div/div/form/fieldset/div/button[1]")
    public WebElement buttonUpdate;

    @FindBy(xpath = "/html/body/div/div/div/form/fieldset/div/p")
    public WebElement buttonDelete;

    @ByAngularCssContainingText.FindBy(cssSelector = ".bBack", searchText = "Back")
    public WebElement buttonBack;

    @FindBy(xpath = "//input[@type='text']")
    public WebElement editFirstName;

    @FindBy(xpath = "(//input[@type='text'])[2]")
    public WebElement editLastName;

    @FindBy(xpath = "(//input[@type='text'])[3]")
    public WebElement editStartDate;

    @FindBy(xpath = "//input[@type='email']")
    public WebElement editEmail;

    /**
     Actions
     */
    public HomePage moveBackToHomePage() {
        buttonBack.click();
        return new HomePage(driver);
    }

    public HomePage submitDataWithNoChanges() throws InterruptedException {
        buttonUpdate.click();
        Thread.sleep(2000);
        return new HomePage(driver);
    }

    public EditPage editDetails(Employee employee) {
        editFirstName.clear();
        editFirstName.sendKeys(employee.firstName);
        editLastName.clear();
        editLastName.sendKeys(employee.lastName);
        editStartDate.clear();
        editStartDate.sendKeys(employee.startDate);
        editEmail.clear();
        editEmail.sendKeys(employee.email);
        return this;
    }

    public HomePage submitDataChanges() throws InterruptedException {
        buttonUpdate.click();
        Thread.sleep(2000);
        return new HomePage(driver);
    }

    public EditPage cancelDeleteEmployeeOnEditPage() {
        buttonDelete.click();
        driver.switchTo().alert().dismiss();
        return new EditPage(driver);
    }

    public HomePage deleteEmployeeOnEditPage() {
        buttonDelete.click();
        driver.switchTo().alert().accept();
        return new HomePage(driver);
    }
}
