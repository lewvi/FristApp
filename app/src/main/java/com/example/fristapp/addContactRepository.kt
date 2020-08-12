package com.example.fristapp

import android.app.Application
import androidx.annotation.WorkerThread


import androidx.lifecycle.LiveData

class addContactRepository(private val addDao: addContactDao) {

    val allWords: LiveData<List<addContact>> = addDao.getAlphabetizedWords()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(word: addContact) {
        addDao.insert(word)
    }
}