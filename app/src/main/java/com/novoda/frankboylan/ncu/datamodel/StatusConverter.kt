package com.novoda.frankboylan.ncu.datamodel

import android.arch.persistence.room.TypeConverter

class StatusConverter {

    @TypeConverter
    fun stringToStatus(value: String?): NodeStatus? {
        return if (value == null) null else when (value) {
            "LOCKED" -> return NodeStatus.LOCKED
            "UNLOCKED" -> return NodeStatus.UNLOCKED
            "IN_PROGRESS" -> return NodeStatus.IN_PROGRESS
            "COMPLETE" -> return NodeStatus.COMPLETE
            else -> return null // Unrecognised NodeStatus String
        }
    }

    @TypeConverter
    fun statusToString(value: NodeStatus?): String? {
        return if (value == null) null else value.toString()
    }
}
