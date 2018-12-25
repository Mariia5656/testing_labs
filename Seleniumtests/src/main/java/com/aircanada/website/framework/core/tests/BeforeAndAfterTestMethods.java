package com.aircanada.website.framework.core.tests;

import com.aircanada.website.framework.core.driver.Browser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

// Да, кстати, хранение и поддержка тестов не в папке с тестами является нормальным делом
// Хоть и тоже очень плохим паттерном
// Зато папка с фреймворком набита всем, чем хочешь. Только в данном случае непонятно зачем

public class BeforeAndAfterTestMethods {

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        Browser.getInstance();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        Browser.getInstance().exit();
    }
}
