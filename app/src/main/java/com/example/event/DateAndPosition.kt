package com.example.event

import java.text.SimpleDateFormat
import java.util.*

object DateAndPosition {
    var dfymd = SimpleDateFormat("yyyy/MM/dd")
    var dfmd = SimpleDateFormat("MM/dd")
    var dfd = SimpleDateFormat("dd")
    var tf = SimpleDateFormat("hh:mm a", Locale.US)

    private var calendar: Calendar = Calendar.getInstance()

    fun dateConvertToPosition(date: Calendar): Int {
        return calendar.get(Calendar.DAY_OF_MONTH) - date[Calendar.DAY_OF_MONTH] + 50
    }

    fun positionConvertToDate(position: Int): Calendar {
        calendar.add(Calendar.DAY_OF_MONTH, position - 50)
        return calendar
    }

    fun positionConvertToMMdd(position: Int): String {
        return dfmd.format(positionConvertToDate(position).time)
    }

    fun pTodd(position: Int): String = dfd.format(positionConvertToDate(position).time)

    fun getDateTextYMD(c: Calendar): String {
        return dfymd.format(c.time)
    }

    fun getTimeTextHMa(c: Calendar): String? {
        return tf.format(c.time)
    }
}