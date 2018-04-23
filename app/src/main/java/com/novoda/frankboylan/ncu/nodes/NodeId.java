package com.novoda.frankboylan.ncu.nodes;

import com.google.gson.annotations.SerializedName;

class NodeId {
    @SerializedName("node-id")
    private int nodeId;

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }
}
