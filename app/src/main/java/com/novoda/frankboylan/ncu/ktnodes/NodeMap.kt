package com.novoda.frankboylan.ncu.ktnodes

import com.google.gson.annotations.SerializedName

data class NodeMap(
        @SerializedName("metadata") val metadata: Metadata,
        @SerializedName("layers") val layers: List<Layer>
)
