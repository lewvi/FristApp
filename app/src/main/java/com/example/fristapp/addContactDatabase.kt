package com.example.fristapp

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [addContact::class], version = 1)
public abstract class addContactDatabase: RoomDatabase() {

    private var instance: addContactDatabase? = null
    abstract fun addDao(): addContactDao?

    @Synchronized
    open fun getInstance(context: Context): addContactDatabase? {
        if (instance == null) {
            instance = Room.databaseBuilder<addContactDatabase>(
                context.getApplicationContext(),
                addContactDatabase::class.java, "addcontact_database"
            )
                .fallbackToDestructiveMigration()
                .addCallback(roomCallback)
                .build()

        }
        return instance
    }

    private val roomCallback: Callback = object : Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            //PopulateDbAsyncTask(instance).execute()
        }
    }
}
    private class PopulateDbAsyncTask(val handler: () -> Unit) : AsyncTask<Void, Void, Void>() {
        private var addDao: addContactDao? = null

        private fun PopulateDbAsyncTask(db: addContactDatabase) {
           addDao = db.addDao()
        }

        override fun doInBackground(vararg void: Void?): Void? {
            addDao?.insert(addContact())
            return null
        }
    }

