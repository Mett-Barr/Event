package com.example.event

import android.database.Cursor
import androidx.room.*
import com.example.event.room.Converters
import com.example.event.room.EventEntity
import java.util.*

@Dao
interface EventDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(item: EventEntity)

    @Update
    fun update(item: EventEntity)

    @Delete
    fun delete(item: EventEntity)

    //由ID取得資料
    @Query("SELECT * FROM event WHERE id = :id")
    fun getByID(id: Int): EventEntity

    //獲得總筆數
    @get:Query("SELECT COUNT(*) FROM event")
    val count: Int

    //取得所有資料，大多用來驗證程式碼有無錯誤
    @get:Query("SELECT * FROM event")
    val all: Cursor?

    //取得今天的所有資料
    //Calendar的資料要轉換成字串
    @Query("SELECT * FROM event WHERE staringDate = :today")
    @TypeConverters(
        Converters::class
    )
    fun getDailyEvents(today: Calendar?): List<EventEntity?>?

    //    public Cursor getDailyData(Calendar c);
    //取出ArrayList裡的ID用的
    @get:Query("SELECT id FROM event")
    val id: Int

    //取出ArrayList裡的eventName用的
    @Query("SELECT eventName FROM event WHERE id = :position")
    fun getEventName(position: Int): String?

    //取出ArrayList裡的category用的
    @get:Query("SELECT category FROM event")
    val cateGory: String?

    //取出ArrayList裡的staringTime用的
    @get:Query("SELECT staringTime FROM event")
    val staringTime: String?

    //取出ArrayList裡的staringDate用的
    @get:Query("SELECT staringDate FROM event")
    val staringDate: String?

    //取出ArrayList裡的endingTime用的
    @get:Query("SELECT endingTime FROM event")
    val endingTime: String?

    //取出ArrayList裡的endingDate用的
    @get:Query("SELECT endingDate FROM event")
    val endingDate: String?

    //取出ArrayList裡的detail用的
    @get:Query("SELECT detail FROM event")
    val detail: String?
}