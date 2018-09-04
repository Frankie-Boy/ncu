package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "node-relationship")
data class NodeRelationship(

        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "relationship-id")
        val relationshipId: Int,

        @ColumnInfo(name = "parent-id")
        val parentId: Int,

        @ColumnInfo(name = "child-id")
        val childId: Int
)
