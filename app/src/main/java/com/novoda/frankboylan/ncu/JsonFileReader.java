package com.novoda.frankboylan.ncu;

import android.content.res.AssetManager;

import com.google.gson.Gson;
import com.novoda.frankboylan.ncu.nodes.NodeMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JsonFileReader {

    public NodeMap readNodeMap(AssetManager assetManager, String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open("json/" + filePath), "UTF-8"));
            return new Gson().fromJson(bufferedReader, NodeMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
