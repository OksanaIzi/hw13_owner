package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class SelenideTest extends TestBase {


    @Test
    public void testOpenPage() {
        open("https://github.com/");
    }

    @Test
    public void secondTestOpenPage() {
        open("https://github.com/");
    }
}
