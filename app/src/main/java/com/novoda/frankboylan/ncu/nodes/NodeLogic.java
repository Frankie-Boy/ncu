package com.novoda.frankboylan.ncu.nodes;

import com.google.gson.Gson;

public class NodeLogic {

    public NodeMap getNodeMapFromJsonString(String json) {
        return new Gson().fromJson(json, NodeMap.class);
    }

    public boolean areChildrenValid(NodeMap nodeMap) {
        for (Layer layer : nodeMap.getLayerList()) {
            for (NodeLite node : layer.getNodeList()) {
                int childrenCount = node.getChildrenList().size();
                if (childrenCount > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
