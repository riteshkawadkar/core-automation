package functional;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.origamiitlab.base.BaseTest;
import org.origamiitlab.objects.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ProductsPageTest extends BaseTest {
    private LoginPage loginPage;


    @Test(description = "Check no of items available on Products page")
    public void test_count_of_products() {
        loginPage = new LoginPage();
        int count = loginPage
                    .perform_login("standard_user", "secret_sauce")
                    .get_count_of_inventory_items();
//        test.log(Status.INFO,"Dummy Step");
        Assert.assertEquals(count, 6);
    }

    @Test(description = "Get all inventory items")
    public void test_get_all_inventory() {
        loginPage = new LoginPage();
        List<String> invetories = loginPage
                        .perform_login("standard_user", "secret_sauce")
                        .get_list_inventory();

        test.get().log(Status.INFO,MarkupHelper.createOrderedList(invetories));
        test.get().log(Status.INFO,"Dummy Step");

        Assert.assertTrue(false);
    }

    @Test(description = "Check no of 'Add to Cart' available on Products page")
    public void test_count_of_add_to_cart_buttons() {
        loginPage = new LoginPage();
        int count = loginPage
                .perform_login("standard_user", "secret_sauce")
                .get_count_of_add_to_cart_buttons();

        test.get().log(Status.INFO,"Dummy Step");
        Assert.assertEquals(count, 6);
    }

}
