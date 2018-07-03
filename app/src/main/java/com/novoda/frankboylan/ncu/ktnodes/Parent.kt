package com.novoda.frankboylan.ncu.ktnodes

import com.google.gson.annotations.SerializedName

data class Parent(
        @SerializedName("node-id") val id: NodeId
)
