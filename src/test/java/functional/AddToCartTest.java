package functional;

import com.aventstack.extentreports.Status;
import org.origamiitlab.base.BaseTest;
import org.origamiitlab.objects.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;


public class AddToCartTest extends BaseTest {

    @Test(description = "Add 3 items to cart and then check whether 3 are added or not")
    public void test_add_to_cart_with_three_items() {
        test.log(Status.INFO,"starting");
        test.assignCategory("P0");

        LoginPage loginPage = new LoginPage();

        int badge_count = loginPage
                .perform_login("standard_user", "secret_sauce")
                .get_items_added_to_cart(3);

        Assert.assertEquals(badge_count, 3);
    }

}
