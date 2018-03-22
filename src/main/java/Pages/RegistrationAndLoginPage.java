package Pages;

import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;

public class RegistrationAndLoginPage {

    public static SelenideElement registrationEmailField = $("#join-now-tabbed-first div input[type='email']");
    public static SelenideElement registrationPasswordField = $("#join-now-tabbed-first div input[type='password']");
    public static SelenideElement createSiteButton = $("#join-now-tabbed-first button");
    public static SelenideElement infoMessage = $("#cabinet_flash_message+div div h2");


    /**
     * Make registration of new user;
     * @param email - email of user;
     * @param password - password of user;
     */
    @Step
    public static void makeRegistration(String email, String password){
        registrationEmailField.setValue(email);
        registrationPasswordField.setValue(password);
        createSiteButton.click();
        assertEquals("Registration doesn't complete", infoMessage.getText(), "Остался всего 1 шаг, чтобы войти в Кабинет компании");
    }
}
