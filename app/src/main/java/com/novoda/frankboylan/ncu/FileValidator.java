package com.novoda.frankboylan.ncu;

class FileValidator {

    public String clean(String uncleanJsonData) {
        return uncleanJsonData.replaceAll("\\s+", "");
    }
}
