package com.example.fristapp

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "addcontact_table")
data class addContact(@PrimaryKey @ColumnInfo(name = "add") val add: String)



