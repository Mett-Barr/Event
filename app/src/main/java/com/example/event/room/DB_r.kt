package com.example.event.room

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.event.EventDAO
import java.util.*

@Database(entities = [EventEntity::class], version = 1)
abstract class DB_r : RoomDatabase() {
    abstract fun eventDao(): EventDAO

    companion object {
        //用字串定義資料庫的名稱
        private const val databaseName = "event.db"

        //建立DB建立 DB_r 類別的 instance
        @Volatile
        private var instance: DB_r? = null

        //通用模式單例程式碼
        private fun getDatabase(context: Context): DB_r? {

            //首先檢查instance是否存在
            if (instance == null) {
                synchronized(DB_r::class.java) {
                    //若不存在則建議一個資料庫
                    if (instance == null) {
                        instance = Room.databaseBuilder<DB_r>(
                            context.applicationContext,
                            DB_r::class.java, databaseName
                        ).allowMainThreadQueries()
                            .build()
                    }
                }
            }
            //若存在則回傳instance
            return instance
        }

        fun insert(c: Context, e: EventEntity?) {
            if (e != null) {
                getDatabase(c)!!.eventDao().insert(e)
            }
        }

        fun update(c: Context, e: EventEntity?) {
            if (e != null) {
                getDatabase(c)!!.eventDao().update(e)
            }
        }

        fun delete(c: Context, e: EventEntity?) {
            if (e != null) {
                getDatabase(c)!!.eventDao().delete(e)
            }
        }

        fun getCount(c: Context): Int {
            return getDatabase(c)!!.eventDao().count
        }

        fun getById(c: Context, position: Int): EventEntity {
            return getDatabase(c)!!.eventDao().getByID(position)
        }

        fun getId(c: Context): Int {
            return getDatabase(c)!!.eventDao().id
        }

        //獲取當日事件
        fun getDailyEvents(c: Context, today: Calendar?): List<EventEntity?>? {
            return getDatabase(c)!!.eventDao().getDailyEvents(today)
        }

        fun getEventName(c: Context, position: Int): String? {
            return getDatabase(c)!!.eventDao().getEventName(position)
        }

        fun insert2(c: Context, e: EventEntity?) {
            AsyncTask.execute(Runnable { //Insert Data
                //新增資一筆資料的工作放到背景去執行
                if (e != null) {
                    getDatabase(c)!!.eventDao().insert(e)
                }
            })
        }
    }
}