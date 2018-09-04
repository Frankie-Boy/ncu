package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "metadata")
data class Metadata(

        @PrimaryKey
        @ColumnInfo(name = "department-code")
        @SerializedName("department-code")
        val departmentCode: String,

        @ColumnInfo(name = "journey-title")
        @SerializedName("title")
        val title: String,

        @ColumnInfo(name = "last-updated-timestamp")
        @SerializedName("last-updated-timestamp")
        val lastUpdatedTimestamp: Int,

        @ColumnInfo(name = "colour-hex")
        @SerializedName("colour-hex")
        val hexColourCode: String
)
