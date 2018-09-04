package com.novoda.frankboylan.ncu.datamodel

import com.google.gson.annotations.SerializedName

data class Layer(
        @SerializedName("layer-number") val layerNumber: Int,
        @SerializedName("nodes") val nodeList: List<Node>
)
