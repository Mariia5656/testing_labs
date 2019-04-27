package com.aircanada.website.framework.core.runner;

import com.aircanada.website.framework.core.driver.Browser;
import com.aircanada.website.framework.core.driver.WebDriverTypes;
import com.aircanada.website.framework.utils.TestNGParser;
import org.testng.TestNG;
import org.testng.xml.XmlSuite;

import java.util.List;

public class Runner {

    public static void main(String[] args) {
        String pathToSuite = args[0];
        String browserName = args[1];
        int result = -1;
        try {
            result = new Runner().run(pathToSuite, browserName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.exit(result);
    }

    private int run(String pathToSuite, String browserName) throws Exception {
        TestNG testNG = new TestNG();
        Browser.setDefaultWebDriverType(WebDriverTypes.valueOf(browserName.toUpperCase()));
        try {
            List<XmlSuite> list = new TestNGParser(pathToSuite).parseToList();
            testNG.setXmlSuites(list);
            testNG.run();
        } finally {
            Browser.getInstance().exit();
        }
        return testNG.hasFailure() ? -1 : 0;
    }

}
