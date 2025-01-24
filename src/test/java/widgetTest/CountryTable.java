package widgetTest;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CountryTable {
//    @param row 1...N
    public SelenideElement getCountryNameByRow(int row) {
        var rowElement = $(".to-list").$("app-todo-item", row);
        return rowElement.$("#name div");
        // it will be unstable if you do it through the String like $("abc").text();
    }

    public String getCountryNameByRowString(int row) {
        return $("abc").text();
        // it will be unstable if you do it through the String like $("abc").text();
    }
}
