package functional;

import data.LoginData;
import org.origamiitlab.base.BaseTest;
import org.origamiitlab.manager.DriverFactory;
import org.origamiitlab.objects.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToApplicationTest extends BaseTest  {

    private LoginPage loginPage;


    @Test(dataProvider = "get_username_password_rename", dataProviderClass = LoginData.class)
    public void test_perform_login_with_all_user_type(String username, String password, String message) {
        appLog.info("test_perform_login_with_all_user_type");
        loginPage  = new LoginPage();

        Assert.assertEquals(loginPage
                        .perform_login(username, password)
                        .getCurrentPageURL()
                        , message);

    }

    @Test(dataProvider = "get_username_password_error_message", dataProviderClass = LoginData.class)
    public void test_validate_error_with_incorrect_credentials(String username, String password, String message) {
        appLog.info("test_validate_error_with_incorrect_credentials");
        loginPage  = new LoginPage();
        Assert.assertEquals(loginPage
                        .perform_incorrect_login(username, password)
                        .get_message_from_error_container()
                , message);
    }



}
