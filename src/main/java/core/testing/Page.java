package core.testing;

import org.openqa.selenium.WebDriver;

public class Page {

    protected WebDriver driver;

    private Page() {
    }

    public Page(WebDriver driver) {
        this.driver = driver;
    }
}
