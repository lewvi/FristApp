package com.example.fristapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class addContactViewModel(
    val database: addContactDao,
    application: Application
) : AndroidViewModel(application) {
}