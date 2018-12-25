package com.aircanada.website.framework.utils;

public class Common {

    public static String checkFileExtension(String filePath, String ext) {
        String extEx = ".".concat(ext);
        if (!filePath.endsWith(extEx)) {
            filePath += extEx;
        }
        return filePath;
    }
}
