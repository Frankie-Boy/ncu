package com.novoda.frankboylan.ncu;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.novoda.frankboylan.ncu.nodes.NodeMap;

public class MainActivity extends AppCompatActivity {

    private static final String JSON_STRING_TEMP = "{ \"metadata\": { \"title\":\"engineering\" }, \"layers\": [{ \"layer-number\":\"0\", \"nodes\": [ {\"node-id\":\"1\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"0\", \"parent\":[{\"node-id\":\"0\"}], \"children\":[{\"node-id\":\"4\"}, {\"node-id\":\"5\"}]}, {\"node-id\":\"2\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"2\", \"parent\":[{\"node-id\":\"0\"}], \"children\":[{\"node-id\":\"5\"}]}, {\"node-id\":\"3\", \"node-status\":\"UNLOCKED\", \"pos-x\":\"4\", \"parent\":[{\"node-id\":\"0\"}], \"children\":[{\"node-id\":\"6\"}]} ]\t},{ \"layer-number\":\"1\", \"nodes\": [ {\"node-id\":\"4\", \"node-status\":\"LOCKED\", \"pos-x\":\"0\", \"parent\":[{\"node-id\":\"1\"}], \"children\":[{\"node-id\":\"7\"}]}, {\"node-id\":\"5\", \"node-status\":\"LOCKED\", \"pos-x\":\"2\", \"parent\":[{\"node-id\":\"1\"}, {\"node-id\":\"2\"}], \"children\":[{\"node-id\":\"8\"}]}, {\"node-id\":\"6\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[{\"node-id\":\"3\"}], \"children\":[]} ]\t},{ \"layer-number\":\"2\", \"nodes\": [ {\"node-id\":\"7\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[{\"node-id\":\"4\"}], \"children\":[{\"node-id\":\"9\"}, {\"node-id\":\"10\"}]}, {\"node-id\":\"8\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[{\"node-id\":\"5\"}], \"children\":[{\"node-id\":\"10\"}, {\"node-id\":\"11\"}]} ] },{ \"layer-number\":\"3\", \"nodes\": [ {\"node-id\":\"9\", \"node-status\":\"LOCKED\", \"pos-x\":\"1\", \"parent\":[{\"node-id\":\"7\"}], \"children\":[]}, {\"node-id\":\"10\", \"node-status\":\"LOCKED\", \"pos-x\":\"3\", \"parent\":[{\"node-id\":\"7\"}, {\"node-id\":\"8\"}], \"children\":[]}, {\"node-id\":\"11\", \"node-status\":\"LOCKED\", \"pos-x\":\"4\", \"parent\":[{\"node-id\":\"8\"}], \"children\":[]} ]\t} ] }\n";
    private NodeMap nodeMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FileReader reader = new FileReader();
        AssetManager assetManager = getAssets();

        String jsonData = reader.readFile("JsonZeroChildren.txt");

        // ToDo: Create the creator :o

        NodeMapCreator nodeMapCreator = new NodeMapCreator();
        nodeMap = nodeMapCreator.createFromJsonString(jsonData);

        Log.d("SearchThis", nodeMap.getMetadata() + "");
    }
}
