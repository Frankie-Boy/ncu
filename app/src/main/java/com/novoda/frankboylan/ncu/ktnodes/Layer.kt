package com.novoda.frankboylan.ncu.ktnodes

import com.google.gson.annotations.SerializedName

data class Layer(
        @SerializedName("layer-number") val layerNumber: Int,
        @SerializedName("nodes") val nodeLiteList: List<NodeLite>
)
