package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.*
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "node")
data class Node(
        @PrimaryKey
        @ColumnInfo(name = "node-id")
        @SerializedName("node-id")
        var id: Int,

        @TypeConverters(StatusConverter::class)
        @NotNull
        @ColumnInfo(name = "node-status")
        @SerializedName("node-status")
        var status: NodeStatus,

        @NotNull
        @ColumnInfo(name = "x-position")
        @SerializedName("pos-x")
        var posX: Int,

        @NotNull
        @ColumnInfo(name = "layer-number")
        var layerNumber: Int,

        @Ignore
        @SerializedName("parents") val parentsList: List<Parent>,

        @Ignore
        @SerializedName("children") val childrenList: List<Child>,

        @ColumnInfo(name = "title")
        var title: String,

        @ColumnInfo(name = "description")
        var description: String,

        @ColumnInfo(name = "progress")
        var progress: Float,

        @ColumnInfo(name = "link-url")
        var linkUrl: String,

        @ColumnInfo(name = "vid-url")
        var vidUrl: String
){
    constructor():this(0, NodeStatus.UNLOCKED, 0, 0, emptyList(), emptyList(), "", "", 0F, "", "")
}
