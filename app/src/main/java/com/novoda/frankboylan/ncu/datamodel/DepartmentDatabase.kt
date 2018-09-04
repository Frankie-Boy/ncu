package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context

@Database(entities = [(Metadata::class), (Node::class), (Objectives::class), (NodeRelationship::class)], version = 1)
@TypeConverters(StatusConverter::class)
abstract class DepartmentDatabase : RoomDatabase() {

    abstract fun metadataDao(): MetadataDao
    abstract fun nodeDao(): NodeDao
    abstract fun objectivesDao(): ObjectivesDao
    abstract fun nodeRelationshipDao(): NodeRelationshipDao

    companion object {
        private var INSTANCE: DepartmentDatabase? = null

        fun getInstance(context: Context): DepartmentDatabase? {
            if (INSTANCE == null) {
                synchronized(DepartmentDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            DepartmentDatabase::class.java, "NodeMap.db")
                            .allowMainThreadQueries() // ToDo: Remove and use Kotlin Coroutines
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}
