package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface MetadataDao {
    @Query("SELECT * FROM metadata")
    fun getMetadata(): Metadata

    @Insert
    fun insert(metadata: Metadata)
}
