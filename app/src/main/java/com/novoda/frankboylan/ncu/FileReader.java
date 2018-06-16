package com.novoda.frankboylan.ncu;

import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

public class FileReader {

    private static final String FILE_DIR = "json/";

    public String readFile(AssetManager assetManager, String fileName) {
        String json = null;
        try {
            InputStream is = assetManager.open(FILE_DIR + fileName);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
