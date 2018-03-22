package Pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static junit.framework.TestCase.fail;

public class MainPage {

    public static SelenideElement siteLogo = $(".x-header__logo-img");
    public static SelenideElement fullVersionOfSiteButton = $("[data-bazooka='MobileSwitch']");
    public static SelenideElement searchButton = $(".x-search__button-icon");
    public static SelenideElement searchField = $$("#search_form .x-search__inner input").find(Condition.visible);
    public static SelenideElement registrationButton = $("[data-qaid='reg_element']");
    public static SelenideElement buyerTypeButton = $("[data-qaid='reg_as_buyer_btn']");
    public static SelenideElement companyTypeButton = $("[data-qaid='reg_as_company_btn']");
    public static ElementsCollection autocompleteResults = $$(".x-autocomplete__group .x-autocomplete__item[data-qaid='suggest_item'] .x-autocomplete__text");

    public enum TypeOfRegistration {
        buyer,
        company
    }

    /**
     * Select type of registration;
     */
    @Step
    public static void selectTypeOfRegistration(TypeOfRegistration typeOfUser) {
        registrationButton.click();

        switch(typeOfUser){
            case buyer:
                buyerTypeButton.click();
                break;
            case company:
                companyTypeButton.click();
                break;
        }

    }

    /**
     * Enter search value (first 5 symbols);
     * @param searchValue - search value;
     */
    @Step
    public static void enterSearchValue(String searchValue) {
        searchField.setValue(searchValue.substring(0, 5));
    }

    /**
     * Make search by value;
     * @param searchValue;
     */
    @Step
    public static void makeSearch(String searchValue) {
        searchField.setValue(searchValue);
        autocompleteResults.shouldHave(CollectionCondition.sizeGreaterThan(2));
        searchButton.click();
    }

    /**
     * Check autocomplete results;
     * @param autocompleteSize - autocomplete size;
     * @param searchValue - search value;
     */
    @Step
    public static void assertAutocompleteResults(int autocompleteSize, String searchValue) {
        if (autocompleteSize == 0) {
            fail("Impossible to find items with " + searchValue);
        }
        for (int i = 0; i < autocompleteSize; i++) {
            autocompleteResults.get(i).shouldHave(Condition.matchesText(searchValue));
        }
    }
}
