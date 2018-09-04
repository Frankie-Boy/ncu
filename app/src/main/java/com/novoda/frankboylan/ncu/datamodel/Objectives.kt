package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "objectives",
        foreignKeys = [(ForeignKey(entity = Node::class,
                parentColumns = arrayOf("node-id"),
                childColumns = arrayOf("owner-node-id"),
                onDelete = ForeignKey.CASCADE))])
data class Objectives(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "objective-id")
        @SerializedName("objective-id")
        val objectiveId: Int,

        @ColumnInfo(name = "task-title")
        @SerializedName("title")
        val title: String,

        @ColumnInfo(name = "task-desc")
        @SerializedName("description")
        val description: String,

        @ColumnInfo(name = "subtask")
        @SerializedName("is-subtask")
        val subtask: Boolean,

        @ColumnInfo(name = "progress")
        @SerializedName("progress")
        val progress: Float,

        @ColumnInfo(name = "owner-node-id")
        @SerializedName("owner-node-id")
        val ownerNodeId: Int
)
