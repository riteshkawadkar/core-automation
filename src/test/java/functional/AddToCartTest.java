package functional;

import org.origamiitlab.base.BaseTest;
import org.origamiitlab.manager.DriverFactory;
import org.origamiitlab.objects.page.LoginPage;
import org.origamiitlab.objects.page.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddToCartTest extends BaseTest {

    @Test
    public void test_add_to_cart_with_three_items() {
        appLog.info("test_add_to_cart_with_three_items");
        LoginPage loginPage = new LoginPage();

        int badge_count = loginPage
                .perform_login("standard_user", "secret_sauce")
                .get_items_added_to_cart(3);

        Assert.assertEquals(badge_count, 3);
    }

}
