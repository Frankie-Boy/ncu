package com.novoda.frankboylan.ncu.nodes;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NodeMap {

    @SerializedName("metadata")
    private Metadata metadata;

    @SerializedName("layers")
    private List<Layers> layersList = new ArrayList<>();

    public Metadata getMetadata() {
        return metadata;
    }

    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public List<Layers> getLayersList() {
        return layersList;
    }

    public void setLayersList(List<Layers> layersList) {
        this.layersList = layersList;
    }
}
