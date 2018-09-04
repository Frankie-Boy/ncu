package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NodeDao {
    @Query("SELECT * FROM node")
    fun getAllNodes(): List<Node>

    @Query("SELECT * FROM node WHERE `layer-number` = :layerNumber")
    fun getNodesFromLayer(layerNumber: Int): Node

    @Query("SELECT * FROM node WHERE `node-id` = :nodeId")
    fun getNodeById(nodeId: Int): Node

    @Insert
    fun insert(node: Node)
}
