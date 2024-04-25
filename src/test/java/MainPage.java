import Pages.MainPageElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainPage {

   WebDriver driver;
   MainPageElements MainPageElements;
   String  successMessage = "Спасибо за запрос.\n" +
           "Мы обязательно с Вами свяжемся в ближайшее время.\n" +
           "Подписывайтесь на наши социальные сети. Там много интересного и полезного!";

   String repeatedMessage = "Ваша заявка уже находится в обработке. В ближайшее время с вами свяжется наш менеджер.";
   String actualUrl = "https://ryazan.top-academy.ru/";
   String titleInset = "Компьютерная Академия TOP | Рязань";
   String errorMessage = "Такого канала не существует.";
   String callMessage = "Ожидайте звонка";
   String linkYoutube = "https://www.youtube.com/channel/UCQRZA1Bq1kUbzQTmuKqhwjA";
   String linkLoginVK = "https://vk.com/login?to=YWthZGVtaWEudG9wLnJ5YXphbg--";
   String linkWhatsapp = "https://api.whatsapp.com/send?phone=79308848400&text=%D0%94%D0%BE%D0%B1%D1%80%D1%8B%D0%B9%20%D0%B4%D0%B5%D0%BD%D1%8C%2C%20%D0%BC%D0%B5%D0%BD%D1%8F%20%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D0%B5%D1%81%D1%83%D0%B5%D1%82%20%D0%BA%D1%83%D1%80%D1%81";
   String linkLesson = "https://ryazan.top-academy.ru/demo_lessons" ;
   String inputError = "input_error";
   String linkChannelTelegram = "https://t.me/s/itTOPrzn";


    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\athre\\IdeaProjects\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("https://ryazan.top-academy.ru/");
        MainPageElements = new MainPageElements(driver);

    }

    @AfterMethod
    public void close() {
        driver.close();

    }
        @Test
        public void checkInvalidUserFormHeadder() {
        assert MainPageElements.invalidiUserFormHeadder().contains(inputError);
    }
        @Test
        public void checkRepeatedValidUserFormHeadder() {
        assert MainPageElements.validUserFormHeadder().contains(repeatedMessage);
    }
        @Test
        public void checkValidUserFormHeadder() {
        assert MainPageElements.validUserFormHeadder().contains(successMessage);
    }
        @Test
        public void checkRepeatedValidUserFormFooter() {
        assert MainPageElements.validUserFormFooter().contains(repeatedMessage);
    }
        @Test
        public void checkCorrectLinkYoutube() {
        assert MainPageElements.iconYoutube().equals(linkYoutube);
    }
        @Test
        public void checkInvalidUserFormFooter() {
        assert MainPageElements.invalidUserFormFooter().contains(inputError);
    }
        @Test
        public void checkRegionList() {
        assert !MainPageElements.regionList().equals("https://ryazan.top-academy.ru/");
    }
        @Test
        public void checkWidgetOnlineChat() {
        assert MainPageElements.widgetOnlineChat().isDisplayed();
    }
        @Test
        public void checkSuccessMessageFeedbackForm() {
        assert MainPageElements.validFeedbackForm().isDisplayed();
    }
        @Test
        public void checkValidUserFormFooter() {
        assert MainPageElements.validUserFormFooter().contains(successMessage);
    }
        @Test
        public void checkErrorFeedbackForm() {
        assert MainPageElements.invalidFeedbackForm().isDisplayed();
    }
        @Test
        public void checkUrl() {
        assert MainPageElements.expectedUrl().equals(actualUrl);
    }
        @Test
        public void checkTitleSite() {
        assert MainPageElements.titleSite().equals(titleInset);
    }
        @Test
        public void checkCorrectContentVK() {
        assert MainPageElements.iconVK().equals(linkLoginVK);
    }
        @Test
        public void checkCorrectContentTelegram() {
        assert MainPageElements.iconTelegram().equals(linkChannelTelegram);
    }
        @Test
        public void checkInvalidGetLessonForm() {
        assert MainPageElements.invalidGetLessonForm().contains(inputError);
    }
        @Test
        public void checkValidGetLessonForm() {
        assert MainPageElements.validGetLessonForm().equals(linkLesson);
    }
        @Test
        public void checkWidgetWhatsapp() {
        assert MainPageElements.widgetWhatsapp().equals(linkWhatsapp);
    }
        @Test
        public void checkActiveLogo() {
        assert MainPageElements.activeLogo().equals(actualUrl);
    }
        @Test
        public void checkCorrectContentYoutube() {
        assert MainPageElements.contentYoutube().equals(errorMessage);
    }
        @Test
        public void checkButtonCareerPartner() {
        assert MainPageElements.buttonCareerPartner().isDisplayed();
    }

    @Test
    public void checkValidConsultForm() {

        assert MainPageElements.validConsultForm().equals(callMessage);
    }
        @Test
        public void checkInvalidConsultForm() {
        assert MainPageElements.invalidConsultForm().contains(inputError);
        }
}
// serve .\allure-results\