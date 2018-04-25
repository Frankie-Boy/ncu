package com.novoda.frankboylan.ncu.nodes;

import com.google.gson.Gson;

public class NodeLogic {

    public NodeMap getNodeMapFromJsonString(String json) {
        return new Gson().fromJson(json, NodeMap.class);
    }

    public boolean isChildCountValid(NodeMap nodeMap) {
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

    public boolean isLayerNodeCountValid(NodeMap nodeMap) {
        for (Layer layer : nodeMap.getLayerList()) {
            if (layer.getNodeList().size() == 0 || layer.getNodeList().size() > 3) {
                return false;
            }
        }
        return true;
    }

    // TODO: To avoid constantly nesting, have a method to map data to a database (Room & RxJava)
}
