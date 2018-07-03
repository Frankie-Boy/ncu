package com.novoda.frankboylan.ncu.ktnodes

import com.google.gson.annotations.SerializedName

data class NodeLite(
        @SerializedName("node-id") val id: NodeId,
        @SerializedName("node-status") val status: NodeStatus,
        @SerializedName("pos-x") val posX: Int,
        @SerializedName("parents") val parentsList: List<Parent>,
        @SerializedName("children") val childrenList: List<Child>
)
