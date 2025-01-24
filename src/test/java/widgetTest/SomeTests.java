package widgetTest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SomeTests {

    static String expectedPrice;

    @Test
    void example() {
        $("div:nth-child(10)");
        $("div img").sibling(3);
    }

    @Test
    void tableTest() {
        new CountryTable().getCountryNameByRow(1).shouldHave(text("Germany"));
        Assertions.assertEquals("Germany", new CountryTable().getCountryNameByRowString(1));
    }

    @BeforeAll
    static void beforeAll(){
        open("page1");
        var expectedPrice = $("price").should(attribute("value", "11")).text();
    }

    @Test
    void monitoring() {
        //arrange

        open("page2");
        var actualPriceInFrontend = $("frontendPrice").text();
        //act
        $("").click();
        //assert
        Assertions.assertEquals(expectedPrice, actualPriceInFrontend);

    }
}
