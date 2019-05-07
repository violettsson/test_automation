package pages.home;

import com.paulhammant.ngwebdriver.ByAngularCssContainingText;
//import com.sun.istack.internal.Nullable;
import core.model.Employee;
import core.testing.Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.authorization.LoginPage;
import pages.home.employee.CreatePage;
import pages.home.employee.EditPage;

import java.util.List;
import java.util.stream.Collectors;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    /**
     * Elements
     */
    @FindBy(xpath = "//ul[@id='employee-list']/li")
    public List<WebElement> employeesNamesWebElements;

    @FindBy(id = "greetings")
    public WebElement greetings;

    @FindBy(id = "bAdd")
    public WebElement buttonCreate;

    @FindBy(id = "bEdit")
    public WebElement buttonEdit;

    @FindBy(id = "bDelete")
    public WebElement buttonDeleteFromHomePage;

    @ByAngularCssContainingText.FindBy(cssSelector = ".main-button", searchText = "Logout")
    public WebElement buttonLogout;

    @FindBy(xpath = "//div/div/div/div/ul/li")
    public WebElement firstEmployeePosition;

    public List<String> getEmployeesNames() {
        return employeesNamesWebElements.stream().map(WebElement::getText).collect(Collectors.toList());
    }

    /**
     * Actions
     */
    public CreatePage moveToCreatеPage() {
        buttonCreate.click();
        return new CreatePage(driver);
    }

    public EditPage moveToEditPage() {
        firstEmployeePosition.click();
        buttonEdit.click();
        return new EditPage(driver);
    }

    public EditPage moveToEditPageByDoubleClick() {
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//div/div/div/div/ul/li")))
                .doubleClick().build().perform();
        return new EditPage(driver);
    }

    public HomePage deleteEmployee() throws InterruptedException {
        firstEmployeePosition.click();
        buttonDeleteFromHomePage.click();

        driver.switchTo().alert().accept();
        Thread.sleep(3000);
        return new HomePage(driver);
    }

    public HomePage cancelToDeleteEmployee() throws InterruptedException {
        firstEmployeePosition.click();
        buttonDeleteFromHomePage.click();
        Thread.sleep(3000);

        driver.switchTo().alert().dismiss();
        return new HomePage(driver);
    }

    public LoginPage logout() {
        buttonLogout.click();
        return new LoginPage(driver);
    }

    /**
     * Finds matches for specified employee in employees list
     * and than returns matches count.
     */
    public int fetchDuplicatesCount(Employee employee) {
        String employeeFullName = employee.firstName + " " + employee.lastName;
        return fetchDuplicatesCount(employeeFullName);
    }

    public int fetchDuplicatesCount(String employeeFullName) {
        return getEmployeesNames().stream()
                .filter(fullName -> fullName.equals(employeeFullName))
                .collect(Collectors.toList())
                .size();
    }
}
