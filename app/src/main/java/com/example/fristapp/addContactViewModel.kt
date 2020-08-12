package com.example.fristapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class addContactViewModel(application: Application) : AndroidViewModel(application){

    private val repository: addContactRepository
    // Using LiveData and caching what getAlphabetizedWords returns has several benefits:
    // - We can put an observer on the data (instead of polling for changes) and only update the
    //   the UI when the data actually changes.
    // - Repository is completely separated from the UI through the ViewModel.
    val allWords: LiveData<List<addContact>>

    init {
        val wordsDao = addContactDatabase.getDatabase(application, viewModelScope).addDao()
        repository = addContactRepository(wordsDao)
        allWords = repository.allWords
    }
    fun insert(word: addContact) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }

}