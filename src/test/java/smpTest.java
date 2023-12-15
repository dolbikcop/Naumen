import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class smpTest {
    @Test
    public void addFavoritePage() {
        open("https://test-m.sd.nau.run/sd/");

        // залогиниться
        $(By.id("username")).sendKeys("polyabikka");
        $(By.id("password")).sendKeys("123");
        By element = By.xpath("//input[@id='submit-button']");
        $(element).click();

        // открыть карточку пользователя
        open("/sd/operator/");

        // Добавить в любимые
        $(By.id("favorite")).click();
        $(By.cssSelector(".GIEYS3IPL")).click();
        $(By.id("gwt-debug-apply")).click();

        // Открыть панель любимых страниц
        $(By.cssSelector(".e044")).click();

        // Проверка
        $(By.xpath("//a[@id='gwt-debug-title']/div")).shouldBe(exist);
    }
    @Test
    public void deleteFavoritePage() {
        open("https://test-m.sd.nau.run/sd/");

//         залогиниться
        $(By.id("username")).sendKeys("polyabikka");
        $(By.id("password")).sendKeys("123");
        By element = By.xpath("//input[@id='submit-button']");
        $(element).click();

//         Открыть панель любимых страниц
        $(By.cssSelector(".e044")).click();

//        Удалить из любимых
        $(By.xpath("//div[contains(@class, \"gwt-TreeItem gwt-TreeItem-selected\")]")).hover();
        $(By.xpath("//div[contains(@class, \"GIEYS3IM4\")]/div[1]/span")).click();
        $(By.id("gwt-debug-YES")).click();

        // Проверка
        $(By.xpath("//*[contains(@class, 'gwt-Anchor GIEYS3IB5')]")).shouldNotBe(exist);
    }
}
