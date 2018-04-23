package com.novoda.frankboylan.ncu.nodes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

class Layers {

    @SerializedName("layer-number")
    private int layerNumber;

    @SerializedName("nodes")
    private List<NodeLite> nodeList = new ArrayList<>();

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
