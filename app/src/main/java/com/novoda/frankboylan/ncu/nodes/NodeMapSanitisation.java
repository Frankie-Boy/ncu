package com.novoda.frankboylan.ncu.nodes;


public class NodeMapSanitisation {

    private NodeMap nodeMap;

    public NodeMapSanitisation(NodeMap nodeMap) {
        this.nodeMap = nodeMap;
    }

    boolean isChildCountValid() {
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

    boolean isLayerNodeCountValid() {
        for (Layer layer : nodeMap.getLayerList()) {
            if (layer.getNodeList().size() == 0 || layer.getNodeList().size() > 3) {
                return false;
            }
        }
        return true;
    }

    // TODO: To avoid constantly nesting, have a method to map data to a database (Room & RxJava)
}
