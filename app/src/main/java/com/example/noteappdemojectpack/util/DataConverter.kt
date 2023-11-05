package com.example.noteappdemojectpack.util

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun timeStampFromDate( data : Date) : Long {
        return data.time
    }

    @TypeConverter
    fun dataFormTimestamp(timestamp : Long) :Date?{
        return Date(timestamp)
    }
}