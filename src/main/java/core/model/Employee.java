package core.model;

import org.openqa.selenium.chrome.ChromeDriver;

public class Employee {

    public String name;
    public String secondName;
    public String startDate;
    public String email;


    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/Purferno/Downloads/chromedriver_74");

        ChromeDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");
    }
}
