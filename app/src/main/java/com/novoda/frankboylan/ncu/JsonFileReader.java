package com.novoda.frankboylan.ncu;

import com.google.gson.Gson;
import com.novoda.frankboylan.ncu.nodes.NodeMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonFileReader {

    public NodeMap readNodeMap(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            return new Gson().fromJson(bufferedReader, NodeMap.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
