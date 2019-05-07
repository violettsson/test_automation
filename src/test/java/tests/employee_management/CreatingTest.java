package tests.employee_management;

import core.model.Credentials;
import core.model.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.LoginPage;
import pages.home.HomePage;
import pages.home.employee.CreatePage;
import tests.BaseTest;
import tests.Input;

public class CreatingTest extends BaseTest {

    @Test(priority = 5)
    void add_employee_to_the_list_test() throws InterruptedException {
        Credentials creds = Input.credentials.valid;
        Employee currentEmployee = Input.employees.standard;

        HomePage homePage = new LoginPage(driver).login(creds);
        int employeeSizeBeforeAdding = homePage.fetchDuplicatesCount(currentEmployee);

        CreatePage createPage = homePage.moveToCreatеPage();
        createPage.addEmployee(currentEmployee);
        int employeeSizeAfterAdding = homePage.fetchDuplicatesCount(currentEmployee);
        
        Assert.assertTrue(employeeSizeAfterAdding > employeeSizeBeforeAdding);
    }

    @Test(priority = 6)
    void cancel_add_employee_to_the_list_test() {
        Employee currentEmployee = Input.employees.standard;
        HomePage homePage = new HomePage(driver);
        int employeeSizeBeforeAdding = homePage.fetchDuplicatesCount(currentEmployee);

        homePage.moveToCreatеPage().cancelCreation();
        int employeeSizeAfterAdding = homePage.fetchDuplicatesCount(currentEmployee);

        Assert.assertEquals(employeeSizeAfterAdding, employeeSizeBeforeAdding);
    }

    @Test(priority = 7)
    void add_empty_employee_details_validation_test() {
        Employee currentEmployee = Input.employees.emptyFirstNameDetails;

        CreatePage createPage = new HomePage(driver).moveToCreatеPage();
        createPage.addEmployee(currentEmployee);

        boolean greetingsIsDisplayed = createPage.buttonAdd.isDisplayed();
        Assert.assertTrue(greetingsIsDisplayed);

        createPage.cancelCreation();
    }

    @Test(priority = 8)
    void add_invalid_employee_details_validation_test() {

        Employee currentEmployee = Input.employees.invalidEmailDetails;

        CreatePage createPage = new HomePage(driver).moveToCreatеPage();
        createPage.addEmployee(currentEmployee);

        boolean greetingsIsDisplayed = createPage.buttonAdd.isDisplayed();
        Assert.assertTrue(greetingsIsDisplayed);

        createPage.cancelCreation();
    }
}
