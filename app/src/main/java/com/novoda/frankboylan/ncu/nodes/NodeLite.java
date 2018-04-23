package com.novoda.frankboylan.ncu.nodes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

class NodeLite { // ToDo: Extend Node

    @SerializedName("node-id")
    private String nodeId;

    @SerializedName("node-status")
    private NodeStatus nodeStatus;

    @SerializedName("parent")
    private List<NodeId> parentList = new ArrayList<>();

    @SerializedName("children")
    private List<NodeId> childrenList = new ArrayList<>();

    @SerializedName("pos-x")
    private int posX;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public NodeStatus getNodeStatus() {
        return nodeStatus;
    }

    public void setNodeStatus(NodeStatus nodeStatus) {
        this.nodeStatus = nodeStatus;
    }

    public List<NodeId> getParentList() {
        return parentList;
    }

    public void setParentList(List<NodeId> parentList) {
        this.parentList = parentList;
    }

    public List<NodeId> getChildrenList() {
        return childrenList;
    }

    public void setChildrenList(List<NodeId> childrenList) {
        this.childrenList = childrenList;
    }

    public int getPosX() {
        return posX;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
}
