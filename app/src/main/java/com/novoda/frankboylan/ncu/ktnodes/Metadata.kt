package com.novoda.frankboylan.ncu.ktnodes

import com.google.gson.annotations.SerializedName

data class Metadata(
        @SerializedName("title") val title: String,
        @SerializedName("last-updated-timestamp") val lastUpdatedTimestamp: Int,
        @SerializedName("department-code") val departmentCode: String,
        @SerializedName("colour-hex") val hexColourCode: String
)
