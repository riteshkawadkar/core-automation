package data;

import org.testng.annotations.DataProvider;

public class LoginData {

    @DataProvider(parallel = true)
    public static Object[][] get_username_password_rename(){
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"locked_out_user", "secret_sauce", "https://www.saucedemo.com/"},
                {"problem_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"},
                {"performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"}
        };
    }

    @DataProvider(parallel = true)
    public static Object[][] get_username_password_error_message(){
        return new Object[][]{
                {"dummy", "dummy", "Epic sadface: Username and password do not match any user in this service"},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"problem_user", "", "Epic sadface: Password is required"}
        };
    }
}
