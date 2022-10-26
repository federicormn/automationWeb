package cleanTest.saucedemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Exercise1Test extends TestBaseSaucedemo
{

    @Test
    public void exercise1Test() throws InterruptedException
    {
        String testItem = "Sauce Labs Onesie";
        loginPageSaucedemo.login("standard_user","secret_sauce");

        catalogPage.SortButton.click();
        catalogPage.priceLowToHighButton.click();

        Assertions.assertEquals(catalogPage.getFirstItemName(), testItem);

        catalogPage.addToCartButton.click();
        catalogPage.cartButton.click();

        Assertions.assertTrue(cartPage.searchItemName(testItem));
    }
}
