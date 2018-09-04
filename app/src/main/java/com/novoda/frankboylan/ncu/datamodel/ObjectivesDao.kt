package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface ObjectivesDao {
    @Query("SELECT * FROM objectives")
    fun getAllObjectives(): List<Objectives>

    @Query("SELECT * FROM objectives WHERE `owner-node-id` = :nodeId")
    fun getObjectivesForNode(nodeId: Int): List<Objectives>

    @Query("SELECT * FROM objectives WHERE `owner-node-id` = :nodeId AND progress = 100")
    fun getCompleteObjectivesForNode(nodeId: Int): List<Objectives>

    @Insert
    fun insert(objectives: Objectives)
}
