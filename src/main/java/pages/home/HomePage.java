package pages.home;

import core.model.Employee;
import core.testing.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.home.employee.CreatePage;
import pages.home.employee.DetailsPage;

import java.util.List;

public class HomePage extends Page {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//ul[@id='employee-list']/li")
    public List<WebElement> employeesNames;

    /**
     * Edit employee use case
     */
    public HomePage editEmployee(String oldEmployee, Employee newEmployee) {
        return this;
//        if (!employeesNames.contains(oldEmployee.name)) {
//            createEmployee(oldEmployee);
//        }
//        return new DetailsPage().edit(oldEmployee, newEmployee).moveBackward();
    }


    /**
     * Create employee use case
     */
    public HomePage createEmployee(Employee employee) {
        return this;
    }


    /**
     * Navigation
     */
    public CreatePage moveToCreation() {
        System.out.println(employeesNames);
        return new CreatePage(driver);
    }


    public DetailsPage moveToDetails() {
        return new DetailsPage(driver);
    }


    /**
     * Service methods
     */
    public Employee findEmployee() {
        return new Employee();
    }
}
