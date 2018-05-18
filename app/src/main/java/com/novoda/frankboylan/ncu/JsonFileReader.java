package com.novoda.frankboylan.ncu;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonFileReader {

    public Object readJsonFromFile(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            return new Gson().fromJson(bufferedReader, Object.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
