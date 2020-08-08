package com.example.fristapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [addContact::class], version = 1)
abstract class addContactDatabase: RoomDatabase(){

    private var instance: addContactDatabase? = null
    abstract fun addDao(): addContactDao?

    @Synchronized
    open fun getInstance(context: Context): addContactDatabase? {
        if (instance == null) {
            instance = Room.databaseBuilder<addContactDatabase>(
                context.getApplicationContext(),
                addContactDatabase::class.java, "note_database"
            )
                .fallbackToDestructiveMigration()
                .build()

        }
        return instance
    }

}