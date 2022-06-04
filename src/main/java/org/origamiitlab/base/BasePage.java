package org.origamiitlab.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.origamiitlab.manager.DriverFactory;

import java.util.List;

public class BasePage {

    public BasePage() {
        PageFactory.initElements(DriverFactory.getTlDriver(), this);
    }

}
