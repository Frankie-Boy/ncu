package com.novoda.frankboylan.ncu.nodes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NodeMap {

    @SerializedName("metadata")
    private Metadata metadata;

    @SerializedName("layers")
    private List<Layer> layerList = new ArrayList<>();

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Layer> getLayerList() {
        return layerList;
    }

    public void setLayerList(List<Layer> layerList) {
        this.layerList = layerList;
    }
}
