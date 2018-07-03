package com.novoda.frankboylan.ncu;

import com.google.gson.Gson;
import com.novoda.frankboylan.ncu.ktnodes.NodeMap;

class NodeMapCreator {
    public NodeMap createFromJsonString(String jsonData) {
        return new Gson().fromJson(jsonData, NodeMap.class);
    }
}
