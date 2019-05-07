package tests.employee_management;

import core.model.Credentials;
import core.model.Employee;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.authorization.LoginPage;
import pages.home.HomePage;
import tests.BaseTest;
import tests.Input;

public class EditingTest extends BaseTest {

    @Test(priority = 9)
    void edit_employee_data_test() throws InterruptedException {
        Credentials creds = Input.credentials.valid;
        Employee johan = Input.employees.standard;
        Employee jari = Input.employees.alter;
        Employee newEmployee;

        HomePage homePage = new LoginPage(driver).login(creds);

        String oldEmployeeFullName = homePage.firstEmployeePosition.getText();
        String jariFullName = jari.firstName + " " + jari.lastName;

        if (oldEmployeeFullName.equals(jariFullName)) {
            newEmployee = johan;
        } else {
            newEmployee = jari;
        }

        int oldEmployeeDuplicatesBeforeEdit = homePage.fetchDuplicatesCount(oldEmployeeFullName);
        int newEmployeeDuplicatesBeforeEdit = homePage.fetchDuplicatesCount(newEmployee);

        homePage.moveToEditPage().editDetails(newEmployee).submitDataChanges();

        int oldEmployeeDuplicatesAfterEdit = homePage.fetchDuplicatesCount(oldEmployeeFullName);
        int newEmployeeDuplicatesAfterEdit = homePage.fetchDuplicatesCount(newEmployee);

        Assert.assertTrue(oldEmployeeDuplicatesAfterEdit < oldEmployeeDuplicatesBeforeEdit);
        Assert.assertTrue(newEmployeeDuplicatesAfterEdit > newEmployeeDuplicatesBeforeEdit);
    }

    @Test(priority = 10)
    void edit_employee_with_unchanged_data_test() throws InterruptedException {
        HomePage homePage = new HomePage(driver);

        String oldEmployeeFullName = homePage.firstEmployeePosition.getText();
        int oldEmployeeDuplicatesBeforeEdit = homePage.fetchDuplicatesCount(oldEmployeeFullName);

        homePage.moveToEditPage().submitDataWithNoChanges();
        int oldEmployeeDuplicatesAfterEdit = homePage.fetchDuplicatesCount(oldEmployeeFullName);

        Assert.assertEquals(oldEmployeeDuplicatesAfterEdit, oldEmployeeDuplicatesBeforeEdit);
    }
}
