package org.origamiitlab.objects.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.origamiitlab.base.BasePage;
import org.origamiitlab.manager.DriverFactory;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    @FindBy(className = "title")
    WebElement page_title;

    @FindBy(className = "inventory_item")
    List<WebElement> inventory_items;

    @FindBy(css = ".btn_inventory")
    List<WebElement> add_to_cart_buttons;

    @FindBy(css = ".shopping_cart_badge")
    WebElement cart_badge;


    public String getCurrentPageURL()
    {
        return DriverFactory.getTlDriver().getCurrentUrl();
    }

    public int get_count_of_inventory_items() {
        return inventory_items.size();
    }

    public List<String> get_list_inventory() {
        return inventory_items.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public int get_count_of_add_to_cart_buttons() {
        return add_to_cart_buttons.size();
    }

    public int get_items_added_to_cart(int no_of_items) {
        add_to_cart_buttons.subList(0, no_of_items).forEach(btn -> btn.click());
        return Integer.parseInt(cart_badge.getText());
    }
}
