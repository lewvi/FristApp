package com.example.fristapp

import androidx.room.*

@Dao
interface addContactDao {

    @Insert
    fun insert(add:addContact)

    @Update
    fun update(add:addContact)

    @Delete
    fun delete(add:addContact)

    @Query("DELETE FROM addcontact_table")
    fun clear()

}