package com.aircanada.website.framework.core.driver;

public enum WebDriverTypes {

    FIREFOX("firefox"), IE("ie"), CHROME("chrome"), OPERA("opera"), EDGE("edge");

    public String value;

    WebDriverTypes(final String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
