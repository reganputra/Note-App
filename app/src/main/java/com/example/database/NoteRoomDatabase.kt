package com.example.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Note::class], version = 1)
abstract class NoteRoomDatabase: RoomDatabase() {

    //  membuat variabel global berupa Singleton untuk Dao yang nanti akan dipanggil di kelas repository

    abstract fun noteDao(): NoteDao

    companion object{
        @Volatile
       private var INSTANCE: NoteRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): NoteRoomDatabase{
            if (INSTANCE == null){
                synchronized(NoteRoomDatabase::class.java){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        NoteRoomDatabase::class.java, "note_database")//membuat atau membangun database pada aplikasi dengan nama note_database
                        .build()
                }
            }
            return INSTANCE as NoteRoomDatabase
        }
    }

}