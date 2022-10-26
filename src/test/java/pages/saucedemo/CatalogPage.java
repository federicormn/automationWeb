package pages.saucedemo;

import controlSelenium.Button;
import controlSelenium.Label;
import org.openqa.selenium.By;

public class CatalogPage
{
    public Button SortButton = new Button(By.xpath("//select[@class=\"product_sort_container\"]"));
    public Button priceHighToLowButton = new Button(By.xpath("//option[text()=\"Price (high to low)\"]"));
    public Button priceLowToHighButton = new Button(By.xpath("//option[text()=\"Price (low to high)\"]"));
    //public Label catalogFirstElement = new Label(By.xpath("//div[@class=\"inventory_list\"]/div[1]//a/div"));
    public Label catalogList = new Label(By.xpath("//div[@class=\"inventory_container\"]"));
    public Button addToCartButton = new Button(By.xpath("//button[@data-test=\"add-to-cart-sauce-labs-onesie\"]"));

    public Button cartButton = new Button(By.xpath("//span[@class=\"shopping_cart_badge\"]"));

    public String getFirstItemName()
    {
        String itemName = catalogList.getAttribute("innerText");
        String[] array = itemName.split("\n", 0);

        return array[0];
    }
}
