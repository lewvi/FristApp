package com.example.fristapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Database(entities = [addContact::class], version = 1)
abstract class addContactDatabase: RoomDatabase() {

    abstract fun addDao(): addContactDao

    companion object {
        @Volatile
        private var INSTANCE: addContactDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): addContactDatabase{
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    addContactDatabase::class.java,
                    "word_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .addCallback(addDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }

        private class addDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                // If you want to keep the data through app restarts,
                // comment out the following line.
                INSTANCE?.let { database ->
                    scope.launch(Dispatchers.IO) {
                        populateDatabase(database.addDao())
                    }
                }
            }
        }

        fun populateDatabase(addDao: addContactDao) {
            // Start the app with a clean database every time.
            // Not needed if you only populate on creation.
            addDao.deleteAll()

            var word = addContact("Hello")
            addDao.insert(word)
            word = addContact("World!")
            addDao.insert(word)
        }
    }
}


