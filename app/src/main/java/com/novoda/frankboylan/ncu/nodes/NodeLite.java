package com.novoda.frankboylan.ncu.nodes;

import java.util.List;

class NodeLite { // ToDo: Extend Node

    private int nodeId;

    private NodeStatus nodeStatus;

    private List<NodeId> parentList;

    private List<NodeId> childrenList;

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
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
}
