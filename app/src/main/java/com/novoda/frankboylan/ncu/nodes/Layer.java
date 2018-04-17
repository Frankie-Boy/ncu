package com.novoda.frankboylan.ncu.nodes;

import java.util.List;

class Layer {

    private int layerNumber;

    private List<NodeLite> nodeList;

    public int getLayerNumber() {
        return layerNumber;
    }

    public void setLayerNumber(int layerNumber) {
        this.layerNumber = layerNumber;
    }

    public List<NodeLite> getNodeList() {
        return nodeList;
    }

    public void setNodeList(List<NodeLite> nodeList) {
        this.nodeList = nodeList;
    }
}
