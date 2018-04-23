package com.novoda.frankboylan.ncu.nodes;

import com.google.gson.Gson;

public class NodeLogic {

    public NodeMap getNodeMapFromJsonString(String json) {
        return new Gson().fromJson(json, NodeMap.class);
    }

    public boolean areChildrenValid(NodeMap nodeMap) {
        //TODO: Parse nodemap check children count
        return false;
    }
}
