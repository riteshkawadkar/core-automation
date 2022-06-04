package org.origamiitlab.objects.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.origamiitlab.base.BasePage;
import org.origamiitlab.manager.DriverFactory;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id="login-button")
    WebElement login_button;
    @FindBy(className="error-message-container")
    WebElement error_container;


    public String getCurrentPageURL()
    {
        return DriverFactory.getTlDriver().getCurrentUrl();
    }

    public ProductsPage perform_login(String user_name, String pass) {
        username.sendKeys(user_name);
        password.sendKeys(pass);
        login_button.click();
        return new ProductsPage();
    }

    public LoginPage perform_incorrect_login(String _username, String _password) {
        username.sendKeys(_username);
        password.sendKeys(_password);
        login_button.click();
        return this;
    }

    public String get_message_from_error_container() {
        return error_container.getText();
    }

}
