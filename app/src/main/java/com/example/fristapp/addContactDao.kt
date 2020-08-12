package com.example.fristapp

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface addContactDao {

    @Query("SELECT * from addcontact_table ORDER BY `add` ASC")
    fun getAlphabetizedWords(): LiveData<List<addContact>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(add: addContact)

    @Query("DELETE FROM addcontact_table")
    fun deleteAll()

}