package com.novoda.frankboylan.ncu;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.novoda.frankboylan.ncu.nodes.NodeMap;

public class MainActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FileReader fileReader = new FileReader();
        AssetManager assetManager = this.getAssets();

        String jsonData = fileReader.readFile(assetManager, "JsonZeroChildren.txt");

        FileValidator fileValidator = new FileValidator();
        String cleanjsonData = fileValidator.clean(jsonData);

        NodeMapCreator nodeMapCreator = new NodeMapCreator();
        NodeMap nodeMap = nodeMapCreator.createFromJsonString(cleanjsonData);
    }
}
