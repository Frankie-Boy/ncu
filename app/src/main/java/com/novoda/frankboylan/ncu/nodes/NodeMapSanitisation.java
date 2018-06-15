package com.novoda.frankboylan.ncu.nodes;


class NodeMapSanitisation {

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

    // TODO: To avoid constantly reading each layer of the nodemap, this should be done once and entered into a data structure in a database (Room & RxJava?)
}
