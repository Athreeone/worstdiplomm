package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageElements {
    private WebDriver driver;
    private WebDriverWait wait;

    public MainPageElements(WebDriver driver) {
        this.driver = driver;
    }

    public String invalidiUserFormHeadder() {
        wait = new WebDriverWait(driver, 15);
        driver.findElement(By.cssSelector("#form-call-popup")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header-contact-form__input.input-fio.hide-field"))).sendKeys(" ");
        driver.findElement(By.cssSelector(".header-contact-form__input.input-email.hide-field")).sendKeys(" ");
        driver.findElement(By.cssSelector(".header-contact-form__input.phone-mask.input-phone.hide-field")).sendKeys(" ");
        driver.findElement(By.cssSelector("#send_consultation")).click();
        WebElement ErrorArea = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header-contact-form__input.phone-mask.input-phone.hide-field.input_error")));
        ErrorArea.getAttribute("class");
        System.out.println(ErrorArea.getAttribute("class"));
        return ErrorArea.getAttribute("class");

    }

    public String validUserFormHeadder() {
        wait = new WebDriverWait(driver, 15);
        driver.findElement(By.cssSelector("#form-call-popup")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[type = 'text']"))).sendKeys("aaaa");
        driver.findElement(By.cssSelector("input[type = 'email']")).sendKeys("bbb@mail.ru");
        driver.findElement(By.cssSelector("input[type = 'tel']")).sendKeys("79999999999");
        driver.findElement(By.cssSelector(".gdpr-policy__checkbox-icon.checkbox-policy")).click();
        driver.findElement(By.cssSelector("#send_consultation")).click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup__message")));
        System.out.println(message.getText());
        return message.getText();
    }

    public String invalidUserFormFooter() {
        wait = new WebDriverWait(driver,20);
        driver.findElement(By.xpath("//form/input[@type='text']")).sendKeys(" ");
        driver.findElement(By.xpath("//form/input[@type='tel']")).sendKeys(" ");
        driver.findElement(By.xpath("//form/input[@type='email']")).sendKeys(" ");
        driver.findElement(By.xpath("//form/button")).click();
        WebElement invalidClass = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".application-contact-form-input.phone-mask.input-phone.hide-field.input_error")));
        System.out.println(invalidClass.getAttribute("class"));
        return invalidClass.getAttribute("class");
    }

    public String validUserFormFooter() {
        wait = new WebDriverWait(driver,20);
        driver.findElement(By.xpath("//form/input[@type='text']")).sendKeys("aaaa");
        driver.findElement(By.xpath("//form/input[@type='tel']")).sendKeys("79999999999");
        driver.findElement(By.xpath("//form/input[@type='email']")).sendKeys("bbb@mail.ru");
        driver.findElement(By.xpath("//form/button")).click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup__message")));
       // WebElement message = driver.findElement(By.cssSelector(".popup__message"));
        System.out.println(message.getText());
        return message.getText();
    }
    public String expectedUrl() {
       return driver.getCurrentUrl();

    }

    public String titleSite() {
      return driver.getTitle();
    }

    public String regionList() {
        wait = new WebDriverWait(driver, 20);
        driver.findElement(By.cssSelector(".right-menu__countries")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href = 'https://murmansk.top-academy.ru']"))).click();
        return driver.getCurrentUrl();

    }
    public WebElement widgetOnlineChat() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leadia_widget_textarea"))).sendKeys("Мне нужна помощь");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leadia_widget_send"))).click();
        WebElement feedbackForm = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leadia_msg_form_input")));
        return feedbackForm;

    }
    public WebElement validFeedbackForm() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leadia_widget_textarea"))).sendKeys("Мне нужна помощь");
        driver.findElement(By.cssSelector(".leadia_widget_send")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leadia_msg_form_input"))).sendKeys("79999999999");
        driver.findElement(By.cssSelector("#sendLeadBtn")).click();
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".success_send")));
        return successMessage;

    }
    public WebElement invalidFeedbackForm() {
        wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leadia_widget_textarea"))).sendKeys("Need you help");
        driver.findElement(By.cssSelector(".leadia_widget_send")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".leadia_msg_form_input"))).sendKeys(" ");
        driver.findElement(By.cssSelector("#sendLeadBtn")).click();
        WebElement errorClass = driver.findElement(By.cssSelector(".leadia_msg_form_input.leadia_input_error"));
        return errorClass;

    }
    public String iconYoutube() {
        wait = new WebDriverWait(driver,10);
        String originalWindow = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".cookies-confirm")).click();
       WebElement youtubeWindow = driver.findElement(By.cssSelector("a[href = 'https://www.youtube.com/channel/UC61YsUyQlT8B8s8deVZQuJA']"));
        youtubeWindow.click();

        for (String currentWindow : driver.getWindowHandles()) {
            if (!currentWindow.equals(originalWindow)) {
                driver.switchTo().window(currentWindow);
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
      return driver.getCurrentUrl();

    }

    public String contentYoutube() {
        wait = new WebDriverWait(driver,10);
        String originalWindow = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".cookies-confirm")).click();
        WebElement youtubeWindow = driver.findElement(By.cssSelector("a[href = 'https://www.youtube.com/channel/UC61YsUyQlT8B8s8deVZQuJA']"));
        youtubeWindow.click();

        for (String currentWindow : driver.getWindowHandles()) {
            if (!currentWindow.equals(originalWindow)) {
                driver.switchTo().window(currentWindow);
                break;
            }
        }

        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".style-scope.yt-alert-renderer")));
        System.out.println(errorMessage.getText());
        return errorMessage.getText();
    }
    public String iconVK() {
        wait = new WebDriverWait(driver,10);
        String originalWindow = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".cookies-confirm")).click();
        WebElement vkWindow = driver.findElement(By.cssSelector(".social__link.social__link--vk"));
        vkWindow.click();

        for (String currentWindow : driver.getWindowHandles()) {
            if (!currentWindow.equals(originalWindow)) {
                driver.switchTo().window(currentWindow);
                break;
            }
        }

      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href = 'https://vk.com/wall-192150450_8124']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".quick_login_button.flat_button.button_wide"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".VkIdForm__input"))).sendKeys("aaaaaa");
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }
    public String iconTelegram() {
        wait = new WebDriverWait(driver,10);
        String originalWindow = driver.getWindowHandle();
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".cookies-confirm")).click();
        WebElement telegramWindow = driver.findElement(By.cssSelector(".social__link.social__link--telega"));
        telegramWindow.click();

        for (String currentWindow : driver.getWindowHandles()) {
            if (!currentWindow.equals(originalWindow)) {
                driver.switchTo().window(currentWindow);
                break;
            }
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tgme_page_context_link"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tgme_channel_info_header_title_wrap"))).click();
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();

    }

    public String invalidGetLessonForm() {
        wait = new WebDriverWait(driver,70);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#demo_confirm"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-form__demo-btn.btn.btn-primary.btn-animate.btn-submit"))).click();
        WebElement inputError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-form__input.popup-form__input--trapeze.input-fio.hide-field.input_error")));
        System.out.println(inputError.getAttribute("class"));
        return inputError.getAttribute("class");

    }
    public String validGetLessonForm() {
        wait = new WebDriverWait(driver,70);
        driver.manage().window().maximize();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#demo_confirm"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".popup-form__input.popup-form__input--trapeze-down.input-email.hide-field"))).sendKeys("bb@mail.ru");
        driver.findElement(By.cssSelector(".popup-form__input.popup-form__input--trapeze.input-fio.hide-field")).sendKeys("aaaa");
        driver.findElement(By.cssSelector(".popup-form__input.popup-form__input--trapeze.phone-mask.input-phone.hide-field")).sendKeys("79999999999");
        driver.findElement(By.cssSelector(".gdpr-policy__label.gdpr-policy__label--demo")).click();
        driver.findElement(By.cssSelector(".popup-form__demo-btn.btn.btn-primary.btn-animate.btn-submit")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".demo-banner__block"))).click();
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();

    }

    public String widgetWhatsapp() {
        wait = new WebDriverWait(driver,10);
        String originalWindow = driver.getWindowHandle();
        WebElement whatsappWindow = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[href = 'https://api.whatsapp.com/send?phone=79308848400&text=%D0%94%D0%BE%D0%B1%D1%80%D1%8B%D0%B9%20%D0%B4%D0%B5%D0%BD%D1%8C%2C%20%D0%BC%D0%B5%D0%BD%D1%8F%20%D0%B8%D0%BD%D1%82%D0%B5%D1%80%D0%B5%D1%81%D1%83%D0%B5%D1%82%20%D0%BA%D1%83%D1%80%D1%81']")));
        whatsappWindow.click();

        for (String currentWindow : driver.getWindowHandles()) {
            if (!currentWindow.equals(originalWindow)) {
                driver.switchTo().window(currentWindow);
                break;
            }
        }
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public String activeLogo() {
        driver.findElement(By.cssSelector("a[href = '/events']")).click();
        driver.findElement(By.cssSelector("a[href = '/']")).click();
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    public WebElement buttonCareerPartner() {
        driver.findElement(By.xpath("//li[10]/button")).click();
        driver.findElement(By.cssSelector("a[href = '/career-center']")).click();
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".call-to-action__btn.btn.btn-register-short.call-career.btn-animate.career-center__btn--partner")).click();
        WebElement popup = driver.findElement(By.cssSelector(".popup__video-frame"));
        return popup;

    }
     public String validConsultForm() {
        wait = new WebDriverWait(driver,20);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".cookies-confirm")).click();
        driver.findElement(By.cssSelector(".btn-application.call-popup")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#phone_popup_call"))).sendKeys("79999999999");
        driver.findElement(By.cssSelector(".gdpr-policy__label.gdpr-policy__label--call-form")).click();
        driver.findElement(By.xpath("//*[@id='call_form']/div[2]/button")).click();
        WebElement message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".message-title")));
        System.out.println(message.getText());
        return message.getText();
     }

     public String invalidConsultForm() {
        wait = new WebDriverWait(driver,20);
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector(".cookies-confirm")).click();
        driver.findElement(By.cssSelector(".btn-application.call-popup")).click();
        driver.findElement(By.xpath("//*[@id='call_form']/div[2]/button")).click();
        WebElement inputError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#phone_popup_call")));
        System.out.println(inputError.getAttribute("class"));
        return  inputError.getAttribute("class");

     }
}

