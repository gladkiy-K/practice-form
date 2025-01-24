package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBrowserConfiguration {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.timeout = 5000;
//        Configuration.browserSize = "1920x1080";
//        Configuration.browser = "chrome";
//        Configuration.holdBrowserOpen = true;
    }
}
