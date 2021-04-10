package com.example.event.room

import androidx.room.TypeConverter
import java.text.SimpleDateFormat
import java.util.*

object Converters {
    var df = SimpleDateFormat("yyyy/MM/dd", Locale.getDefault())
    @TypeConverter
    fun calendarToToday(c: Calendar?): String? {

        //當c為空值回傳空值，否則就回傳經過型別轉換後的字串
        return if (c == null) null else df.format(c.time)
    } //    @TypeConverter
    //    public static Date fromTimestamp(Long value) {
    //        return value == null ? null : new Date(value);
    //    }
}