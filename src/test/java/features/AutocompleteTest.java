package features;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import core.BaseTestConfiguration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import static Pages.MainPage.*;
import static Pages.SearchResultPage.assertResultOfSearchPage;

public class AutocompleteTest extends BaseTestConfiguration {

    @DataProvider(name = "SearchWords")
    public static Object[][] searchWords(){
        return new Object[][] {{"плеер"}, {"телевизор"},{"доберман"}};
    }

    @Features("Autocomplete Test")
    @Test(dataProvider = "SearchWords")
    public void testAutocomplete(String searchWords){

        //Enter search value in search field;
        enterSearchValue(searchWords);

        //Assert that size of autocomplete results greater than 1;
        autocompleteResults.shouldHave(CollectionCondition.sizeGreaterThan(1));

        //Get size of autocomplete results;
        int sizeOfAutocompleteResults = autocompleteResults.size();

        //Assert that autocomplete results contains search value;
        assertAutocompleteResults(sizeOfAutocompleteResults, searchWords);

        //Select first autocomplete result;
        autocompleteResults.get(0).click();

        //Assert thar page of search results is opened;
        assertResultOfSearchPage(searchWords);

        //Check search field(input);
        searchField.shouldHave(Condition.value(searchWords));
    }

}
