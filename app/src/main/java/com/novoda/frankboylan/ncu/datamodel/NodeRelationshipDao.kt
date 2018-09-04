package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface NodeRelationshipDao {
    @Insert
    fun insertRelationship(nodeRelationship: NodeRelationship)

    @Insert
    fun insertRelationships(nodeRelationship: List<NodeRelationship>)

    @Query("SELECT * FROM `node-relationship` WHERE `parent-id` = :parentId")
    fun getChildrenFor(parentId: Int): NodeRelationship

    @Query("SELECT * FROM `node-relationship` WHERE `child-id` = :childId")
    fun getParentsFrom(childId: Int): NodeRelationship
    

}
