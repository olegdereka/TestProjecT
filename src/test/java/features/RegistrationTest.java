package features;

import core.BaseTestConfiguration;
import core.Tools;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;

import static Pages.MainPage.TypeOfRegistration.company;
import static Pages.MainPage.selectTypeOfRegistration;
import static Pages.RegistrationAndLoginPage.makeRegistration;
import static core.Api.checkSubjectInEmail;
import static core.Api.createNewEmail;
import static org.junit.Assert.assertEquals;

public class RegistrationTest extends BaseTestConfiguration {

    @Features("Registration Test")
    @Test
    public void testRegistration(){
        //Test data;
        String email = "mail" + Tools.generateRandomNumberWithSize(7);
        String password = "P@ssword" + Tools.generateRandomNumberWithSize(3);

        //Create new email by API;
        String registeredEmail = createNewEmail(email);

        //Select type of user;
        selectTypeOfRegistration(company);

        //Make registration;
        makeRegistration(registeredEmail, password);

        //Check subject in email by API;
        checkSubjectInEmail(email);
    }

    public static void main(String[] args) {
        System.out.println("хуй");

        assertEquals("мседж", "привет", "пока");
    }


}
