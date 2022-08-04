package project;

import org.junit.Test;

public class SearchItemsTest {
    SearchItems searchItems=new SearchItems();

    @Test
    public void SearchProcessTest() throws InterruptedException {
        searchItems.connect();
        searchItems.searchProcess();
        //searchItems.quit();
    }
}
