package functional;

import org.origamiitlab.base.BaseTest;
import org.origamiitlab.manager.DriverFactory;
import org.origamiitlab.objects.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsPageTest extends BaseTest {
    private LoginPage loginPage;


    @Test
    public void test_count_of_products() {
        appLog.info("test_count_of_products");
        loginPage = new LoginPage();
        int count = loginPage
                    .perform_login("standard_user", "secret_sauce")
                    .get_count_of_inventory_items();

        Assert.assertEquals(count, 6);
    }

    @Test
    public void test_count_of_add_to_cart_buttons() {
        appLog.info("test_count_of_products");
        loginPage = new LoginPage();
        int count = loginPage
                .perform_login("standard_user", "secret_sauce")
                .get_count_of_add_to_cart_buttons();

        Assert.assertEquals(count, 6);
    }

}
