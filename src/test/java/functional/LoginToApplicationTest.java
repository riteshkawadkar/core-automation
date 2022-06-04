package functional;

import com.aventstack.extentreports.Status;
import data.LoginData;
import org.origamiitlab.base.BaseTest;
import org.origamiitlab.objects.page.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginToApplicationTest extends BaseTest  {

    private LoginPage loginPage;


    @Test(dataProvider = "get_username_password_rename",
            dataProviderClass = LoginData.class,
            description = "Run 4 set of correct username and password data in parallel and check if we can login")
    public void test_perform_login_with_all_user_type(String username, String password, String message) {
        test.get().log(Status.INFO,"Starting the tests : " + test.get().getStatus());
        test.get().assignCategory("P1");

        loginPage  = new LoginPage();

        Assert.assertEquals(loginPage
                        .perform_login(username, password)
                        .getCurrentPageURL()
                        , message);

    }

    @Test(dataProvider = "get_username_password_error_message",
            dataProviderClass = LoginData.class,
            description = "Run 4 set of incorrect username and password data in parallel and check if get expected error message")
    public void test_validate_error_with_incorrect_credentials(String username, String password, String message) {
        test.get().log(Status.INFO,"Starting the tests : " + test.get().getStatus());
        test.get().assignCategory("P1");

        loginPage  = new LoginPage();
        Assert.assertEquals(loginPage
                        .perform_incorrect_login(username, password)
                        .get_message_from_error_container()
                , message);
    }



}
