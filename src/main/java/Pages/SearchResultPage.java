package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import core.Tools;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertEquals;

public class SearchResultPage {

    public static SelenideElement resultFoSearch = $(".x-title h1");
    public static ElementsCollection pagesOfSearchResults = $$(".x-pager__content .x-pager__item");
    public static ElementsCollection searchResultsLineItems = $$(".x-catalog__content .x-gallery-tile__content span[itemprop='name']");

    @Step
    public static void assertResultOfSearchPage(String searchValue) {
        resultFoSearch.shouldHave(Condition.matchesText(searchValue));
    }

    /**
     * Check search results;
     * @param searchValue - search value;
     * @param quantityOfPages - quantity of pages;
     */
    @Step
    public static void checkSearchResults(String searchValue, int quantityOfPages) {
        for (int a = 0; a <quantityOfPages; a++) {
            Tools.sleepWait(3500);
            pagesOfSearchResults.get(a).click();
            Tools.sleepWait(3500);
            int sizeOfSearchResults = searchResultsLineItems.filter(Condition.visible).size();
            for (int i = 0; i < sizeOfSearchResults; i++) {
                 if (searchResultsLineItems.get(i).has(Condition.not(Condition.text(searchValue)))) {
                    System.out.println("Search result item doesn't contains search value =" + searchResultsLineItems.get(i).getText());
                }
            }
        }
    }
}

