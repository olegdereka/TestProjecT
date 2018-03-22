package features;

import core.BaseTestConfiguration;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import static Pages.MainPage.makeSearch;
import static Pages.SearchResultPage.checkSearchResults;

public class SearchTest extends BaseTestConfiguration{
    @Features("Search Test")
    @DataProvider(name = "SearchWords")
    public static Object[][] searchWords(){
        return new Object[][] {{"плеер"}, {"телевизор"}};
    }

    @Test(dataProvider = "SearchWords")

    public void testSearch(String searchValue){
        //Test data
        int quantityOfPages = 2;

        //Make search of item;
        makeSearch(searchValue);

        //Check search results
        checkSearchResults(searchValue, quantityOfPages);
    }
}
